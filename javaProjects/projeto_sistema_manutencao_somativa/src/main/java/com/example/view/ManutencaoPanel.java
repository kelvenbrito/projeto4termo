package com.example.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

public class ManutencaoPanel extends JPanel {
   //Atributos
    private ManutencaoController manutencaoController;
    private JTable manutencaoTable;
    private DefaultTableModel tableModel;
    private JButton btnEditar;
    private JButton btnCadastrarManutencao;
    private JButton btnRelatorio;
    int esc = 0;

    //COnstrutor
    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new ManutencaoController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "maquinaID", "data", "tipo", "pecasTrocadas", "tempoDeParada", "tecnicoId","observacoes"
        },0);
        manutencaoTable = new JTable(tableModel);

        AtualizarTabela();
        JScrollPane scrollPane = new JScrollPane(manutencaoTable);
        this.add(scrollPane, BorderLayout.CENTER);
        configurarBotoes();
        this.setSize(500, 500);
    }

    private void configurarBotoes() {
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar");
        btnEditar = new JButton("Editar");
        btnRelatorio = new JButton("Gerar Relatório");
        painelInferior.add(btnCadastrarManutencao);
        painelInferior.add(btnEditar);
        painelInferior.add(btnRelatorio);
        this.add(painelInferior, BorderLayout.SOUTH);

        btnCadastrarManutencao.addActionListener(e -> {
            esc = 1;
            JanelaCadastroManutencao();
        });

        btnEditar.addActionListener(e -> {
            int selectedRow = manutencaoTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecione uma Manutencao para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                esc = 2; // Modo edição
                JanelaCadastroManutencao();
            }
        });
        

        btnRelatorio.addActionListener(e -> gerarRelatorioPDF());
    }

    public void JanelaCadastroManutencao() {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Cadastrar Manutencao", true);
        dialog.setSize(500, 500);
        dialog.setLayout(new GridLayout(12, 2));
    
        JTextField[] inputs = criarCamposEntrada(dialog);
        JButton btnSalvar = new JButton("Salvar");
        dialog.add(btnSalvar);
    
        if (esc == 2) {
            preencherCamposParaEdicao(inputs);
        }
    
        btnSalvar.addActionListener(e -> {
            salvarManutencao(inputs, dialog);
        });
    
        dialog.setVisible(true);
        AtualizarTabela();
    }
    

    private JTextField[] criarCamposEntrada(JDialog dialog) {
        String[] labels = {  "ID:", "maquinaID:", "data:", "tipo:", "pecasTrocadas:", "tempoDeParada:",
         "tecnicoId:","observacoes:"};

        JTextField[] inputs = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
            dialog.add(new JLabel(labels[i]));
            inputs[i] = new JTextField(20);
            dialog.add(inputs[i]);
        }
        return inputs;
    }

    private void preencherCamposParaEdicao(JTextField[] inputs) {
        int selectedRow = manutencaoTable.getSelectedRow();
        if (selectedRow != -1) {
            String selectedId = tableModel.getValueAt(selectedRow, 0).toString();
            Manutencao manutencaoSelecionada = manutencaoController.readManutencao().stream()
                    .filter(manutencao -> manutencao.getId().equals(selectedId))
                    .findFirst()
                    .orElse(null);
    
            if (manutencaoSelecionada != null) {
                inputs[0].setText(manutencaoSelecionada.getId());
                inputs[0].setEnabled(false);
                inputs[1].setText(manutencaoSelecionada.getMaquinaID());
                inputs[2].setText(manutencaoSelecionada.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // Formatação correta
                inputs[3].setText(manutencaoSelecionada.getTipo());
                inputs[4].setText(manutencaoSelecionada.getPecasTrocadas());
                inputs[5].setText(String.valueOf(manutencaoSelecionada.getTempoDeParada()));
                inputs[6].setText(manutencaoSelecionada.getTecnicoID());
                inputs[7].setText(manutencaoSelecionada.getObservacoes());
            } else {
                JOptionPane.showMessageDialog(this, "Manutenção não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma Manutenção selecionada para edição.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void salvarManutencao(JTextField[] inputs, JDialog dialog) {
        if (validarCampos(inputs, dialog)) {
            try {
                Manutencao novaManutencao = criarManutencao(inputs);
                if (esc == 1) {
                    // Cadastro
                    manutencaoController.createManutencao(novaManutencao);
                    JOptionPane.showMessageDialog(dialog, "Manutenção cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else if (esc == 2) {
                    // Edição
                   
                    manutencaoController.updateManutencao(Integer.parseInt(inputs[0].getText()), novaManutencao);
                    JOptionPane.showMessageDialog(dialog, "Manutenção atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                dialog.dispose(); // Fechar o diálogo somente após salvar
                AtualizarTabela(); // Atualizar tabela após o fechamento do diálogo
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(dialog, "Erro ao salvar o Histórico de manutenção: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    
    
    private boolean validarCampos(JTextField[] inputs, JDialog dialog) {
        for (int i = 0; i < inputs.length; i++) {
            if (i < 5 && inputs[i].getText().isEmpty()) { // Campos obrigatórios
                JOptionPane.showMessageDialog(dialog, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        try {
            // Modificado para aceitar o formato DD/MM/YYYY
            DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(inputs[2].getText(), formatoBrasileiro); // Validar data
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "Data de aquisição inválida. Use o formato DD/MM/YYYY.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    

    private Manutencao criarManutencao(JTextField[] inputs) {
        Manutencao novaManutencao = new Manutencao();
        novaManutencao.setId(inputs[0].getText());
        novaManutencao.setMaquinaID(inputs[1].getText());
           // Utilize o formato brasileiro para a data
           DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           novaManutencao.setData(LocalDate.parse(inputs[2].getText(), formatoBrasileiro));
        novaManutencao.setTipo(inputs[3].getText());
        novaManutencao.setPecasTrocadas(inputs[4].getText());
        novaManutencao.setTempoDeParada(Integer.parseInt(inputs[5].getText()));
        novaManutencao.setTecnicoID(inputs[6].getText());
        novaManutencao.setObservacoes(inputs[7].getText());
        return novaManutencao;
    }

    private void AtualizarTabela() {
        tableModel.setRowCount(0);
        List<Manutencao> manutencoes = manutencaoController.readManutencao();
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato brasileiro
        for (Manutencao manutencao : manutencoes) {
            String dataAquisicaoFormatada = manutencao.getData().format(formatoBrasileiro);
            tableModel.addRow(new Object[]{
                manutencao.getId(),
                manutencao.getMaquinaID(),
                dataAquisicaoFormatada, // Adicione a data formatada
                manutencao.getTipo(),
                manutencao.getPecasTrocadas(),
                manutencao.getTempoDeParada(),
                manutencao.getTecnicoID(),
                manutencao.getObservacoes(),
            });
        }
    }

    public void gerarRelatorioPDF() {
        try {
            // Verifica se o diretório existe
            File diretorio = new File("RelatoriosPDF");
            if (!diretorio.exists()) {
                diretorio.mkdirs(); // Cria o diretório se não existir
            }
            
            String caminhoArquivo = "RelatoriosPDF/relatorio_historicoManutencao.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();
            document.add(new Paragraph("Relatório de Manutenção de Máquinas\n\n"));
    
            List<Manutencao> manutencoes = manutencaoController.readManutencao();
            for (Manutencao manutencao : manutencoes) {
                document.add(new Paragraph("ID: " + manutencao.getId()));
                document.add(new Paragraph("Máquina ID: " + manutencao.getMaquinaID()));
                document.add(new Paragraph("Data: " + manutencao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                document.add(new Paragraph("Tipo: " + manutencao.getTipo()));
                document.add(new Paragraph("Peças Trocadas: " + manutencao.getPecasTrocadas()));
                document.add(new Paragraph("Tempo de Parada: " + manutencao.getTempoDeParada()));
                document.add(new Paragraph("Técnico ID: " + manutencao.getTecnicoID()));
                document.add(new Paragraph("Observações: " + manutencao.getObservacoes()));
                document.add(new Paragraph("\n"));
            }
    
            document.close();
            System.out.println("Relatório gerado com sucesso: " + caminhoArquivo);
            abrirRelatorio(caminhoArquivo);
        } catch (Exception ex) {
            System.out.println("Erro ao gerar o relatório: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void abrirRelatorio(String caminhoArquivo) {
        try {
            File relatorio = new File(caminhoArquivo);
            Desktop.getDesktop().open(relatorio);
        } catch (Exception e) {
            System.out.println("Erro ao abrir o relatório: " + e.getMessage());
        }
    }
    

}

package com.example.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
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
import com.example.controllers.FalhaController;
import com.example.models.Falhas;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FalhasPanel extends JPanel {
    // Atributos
    private FalhaController falhaController;
    private JTable falhaTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarFalha;
    private JButton btnEditar;
    private JButton btnRelatorio;
    private int esc = 0; // 1 para cadastrar, 2 para editar

    // Construtor
    public FalhasPanel() {
        super(new BorderLayout());
        falhaController = new FalhaController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Máquina ID", "Data", "Problema", "Prioridade", "Operador"
        }, 0);
        falhaTable = new JTable(tableModel);

        // Criar a tabela
        atualizarTabela();
        JScrollPane scrollPane = new JScrollPane(falhaTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnEditar = new JButton("Editar");
        btnRelatorio = new JButton("Gerar Reltorio");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnEditar);
        painelInferior.add(btnRelatorio);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões
        btnCadastrarFalha.addActionListener(e -> {
            esc = 1; // Modo de cadastro
            janelaCadastroFalha();
        });

        btnEditar.addActionListener(e -> {
            int selectedRow = falhaTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecione uma falha para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                esc = 2; // Modo de edição
                janelaCadastroFalha();
            }
        });

        
        btnRelatorio.addActionListener(e -> gerarRelatorioPDF());
    }

    public void janelaCadastroFalha() {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Cadastro de Falha", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(8, 2));

        JTextField[] inputs = criarCamposEntrada(dialog);
        JButton btnSalvar = new JButton("Salvar");
        dialog.add(btnSalvar);

        if (esc == 2) {
            preencherCamposParaEdicao(inputs);
        }

        btnSalvar.addActionListener(e -> salvarFalha(inputs, dialog));
        dialog.setVisible(true);
    }

    private JTextField[] criarCamposEntrada(JDialog dialog) {
        String[] labels = {"ID:", "Máquina ID:", "Data:", "Problema:", "Prioridade:", "Operador:"};
        JTextField[] inputs = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            dialog.add(new JLabel(labels[i]));
            inputs[i] = new JTextField(20);
            dialog.add(inputs[i]);
        }
        return inputs;
    }

    private void preencherCamposParaEdicao(JTextField[] inputs) {
        int selectedRow = falhaTable.getSelectedRow();
        if (selectedRow != -1) {
            String selectedId = tableModel.getValueAt(selectedRow, 0).toString();
            Falhas falhaSelecionada = falhaController.readFalha().stream()
                    .filter(falha -> falha.getId().equals(selectedId))
                    .findFirst()
                    .orElse(null);

            if (falhaSelecionada != null) {
                inputs[0].setText(falhaSelecionada.getId());
                inputs[0].setEnabled(false);
                inputs[1].setText(falhaSelecionada.getMaquinaID());
             inputs[2].setText(falhaSelecionada.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // Formatação correta
                inputs[3].setText(falhaSelecionada.getProblema());
                inputs[4].setText(falhaSelecionada.getPrioridade());
                inputs[5].setText(falhaSelecionada.getOperador());
            } else {
                JOptionPane.showMessageDialog(this, "Falha não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void salvarFalha(JTextField[] inputs, JDialog dialog) {
        if (validarCampos(inputs, dialog)) {
            try {
                Falhas novaFalha = criarFalha(inputs);
                if (esc == 1) {
                    falhaController.createFalha(novaFalha);
                    JOptionPane.showMessageDialog(dialog, "Falha cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else if (esc == 2) {
                    falhaController.updateFalha(Integer.parseInt(inputs[0].getText()), novaFalha);
                    JOptionPane.showMessageDialog(dialog, "Falha atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                dialog.dispose();
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(dialog, "Erro ao salvar a falha: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

    private Falhas criarFalha(JTextField[] inputs) {
        Falhas novaFalha = new Falhas();
        novaFalha.setId(inputs[0].getText());
        novaFalha.setMaquinaID(inputs[1].getText());
         // Utilize o formato brasileiro para a data
           DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           novaFalha.setData(LocalDate.parse(inputs[2].getText(), formatoBrasileiro));
        novaFalha.setProblema(inputs[3].getText());
        novaFalha.setPrioridade(inputs[4].getText());
        novaFalha.setOperador(inputs[5].getText());
        return novaFalha;
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Falhas> falhas = falhaController.readFalha();
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato brasileiro
        for (Falhas falha : falhas) {
            String dataAquisicaoFormatada = falha.getData().format(formatoBrasileiro);
            tableModel.addRow(new Object[]{
                falha.getId(),
                falha.getMaquinaID(),
                dataAquisicaoFormatada, // Adicione a data formatada
                falha.getProblema(),
                falha.getPrioridade(),
                falha.getOperador(),
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

        String caminhoArquivo = "RelatoriosPDF/relatorio_historicoFalhas.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
        document.open();
        document.add(new Paragraph("Relatório de Falhas\n\n"));

        // Coleta as falhas
        List<Falhas> falhas = falhaController.readFalha();
        for (Falhas falha : falhas) {
            document.add(new Paragraph("ID: " + falha.getId()));
            document.add(new Paragraph("Máquina ID: " + falha.getMaquinaID()));
            document.add(new Paragraph("Data: " + falha.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            document.add(new Paragraph("Problema: " + falha.getProblema()));
            document.add(new Paragraph("Prioridade: " + falha.getPrioridade()));
            document.add(new Paragraph("Operador: " + falha.getOperador()));
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

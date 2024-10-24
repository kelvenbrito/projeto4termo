package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import java.time.LocalDate;
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

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import java.time.format.DateTimeFormatter;

public class MaquinasPanel extends JPanel {
    // Atributos
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnEditar;
    private JButton btnCadastrarMaquina;
    private JButton btnRelatorio;
    int esc = 0;

    // Construtor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();
        tableModel = new DefaultTableModel(new Object[]{
                "ID", "Nome", "Fabricante", "Modelo", "Detalhes", "Localização",
                "Tempo Vida"
        }, 0);
        maquinasTable = new JTable(tableModel);
        AtualizarTabela();
        JScrollPane scrollPane = new JScrollPane(maquinasTable);
        this.add(scrollPane, BorderLayout.CENTER);
        configurarBotoes();
        this.setSize(500, 500);
    }

    private void configurarBotoes() {
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnEditar = new JButton("Editar");
        btnRelatorio = new JButton("Gerar Relatório");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnEditar);
        painelInferior.add(btnRelatorio);
        this.add(painelInferior, BorderLayout.SOUTH);

        btnCadastrarMaquina.addActionListener(e -> {
            esc = 1;
            JanelaCadastroMaquina();
        });

        btnEditar.addActionListener(e -> {
            int selectedRow = maquinasTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecione uma máquina para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                esc = 2; // Modo edição
                JanelaCadastroMaquina();
            }
        });
        

        btnRelatorio.addActionListener(e -> gerarRelatorioPDF());
    }

    public void JanelaCadastroMaquina() {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Cadastrar Máquina", true);
        dialog.setSize(500, 500);
        dialog.setLayout(new GridLayout(12, 2));

        JTextField[] inputs = criarCamposEntrada(dialog);
        JButton btnSalvar = new JButton("Salvar");
        dialog.add(btnSalvar);

        if (esc == 2) {
            preencherCamposParaEdicao(inputs);
        }

        btnSalvar.addActionListener(e -> salvarMaquina(inputs, dialog));
        dialog.setVisible(true);
        AtualizarTabela();
    }

    private JTextField[] criarCamposEntrada(JDialog dialog) {
        String[] labels = {"ID:", "Código:", "Nome:", "Fabricante:", "Modelo:", "Data de Aquisição:",
                "Detalhes:", "Localização:", "Tempo Vida:", "Manual:"};

        JTextField[] inputs = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
            dialog.add(new JLabel(labels[i]));
            inputs[i] = new JTextField(20);
            dialog.add(inputs[i]);
        }
        return inputs;
    }
    private void preencherCamposParaEdicao(JTextField[] inputs) {
        int selectedRow = maquinasTable.getSelectedRow();
        if (selectedRow != -1) {
            // Aqui você deve garantir que o índice não seja maior que o tamanho do modelo
            String selectedId = tableModel.getValueAt(selectedRow, 0).toString();
            Maquina maquinaSelecionada = maquinaController.readMaquina().stream()
                    .filter(maquina -> maquina.getId().equals(selectedId))
                    .findFirst()
                    .orElse(null);
    
            if (maquinaSelecionada != null) {
                inputs[0].setText(maquinaSelecionada.getId());
                inputs[0].setEnabled(false);
                inputs[1].setText(maquinaSelecionada.getCodigo());
                inputs[2].setText(maquinaSelecionada.getNome());
                inputs[3].setText(maquinaSelecionada.getFabricante());
                inputs[4].setText(maquinaSelecionada.getModelo());
                inputs[5].setText(maquinaSelecionada.getDataAquisicao().toString());
                inputs[6].setText(maquinaSelecionada.getDetalhes());
                inputs[7].setText(maquinaSelecionada.getLocalizacao());
                inputs[8].setText(String.valueOf(maquinaSelecionada.getTempoVidaEstimado()));
                inputs[9].setText(maquinaSelecionada.getManual());
            } else {
                JOptionPane.showMessageDialog(this, "Máquina não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma máquina selecionada para edição.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void salvarMaquina(JTextField[] inputs, JDialog dialog) {
        if (validarCampos(inputs, dialog)) {
            try {
                Maquina novaMaquina = criarMaquina(inputs);
                if (esc == 1) {
                    maquinaController.createMaquina(novaMaquina);
                } else if (esc == 2) {
                    maquinaController.updateMaquina(Integer.parseInt(inputs[0].getText()), novaMaquina);
                }
                dialog.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(dialog, "Erro ao salvar a máquina: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
            LocalDate.parse(inputs[5].getText(), formatoBrasileiro); // Validar data
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "Data de aquisição inválida. Use o formato DD/MM/YYYY.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    

    private Maquina criarMaquina(JTextField[] inputs) {
        Maquina novaMaquina = new Maquina();
        novaMaquina.setId(inputs[0].getText());
        novaMaquina.setCodigo(inputs[1].getText());
        novaMaquina.setNome(inputs[2].getText());
        novaMaquina.setFabricante(inputs[3].getText());
        novaMaquina.setModelo(inputs[4].getText());
        // Utilize o formato brasileiro para a data
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        novaMaquina.setDataAquisicao(LocalDate.parse(inputs[5].getText(), formatoBrasileiro));
        novaMaquina.setDetalhes(inputs[6].getText());
        novaMaquina.setLocalizacao(inputs[7].getText());
        novaMaquina.setTempoVidaEstimado(Integer.parseInt(inputs[8].getText()));
        novaMaquina.setManual(inputs[9].getText());
        return novaMaquina;
    }
    
    private void AtualizarTabela() {
        tableModel.setRowCount(0);
        List<Maquina> maquinas = maquinaController.readMaquina();
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato brasileiro
        for (Maquina maquina : maquinas) {
            String dataAquisicaoFormatada = maquina.getDataAquisicao().format(formatoBrasileiro);
            tableModel.addRow(new Object[]{
                maquina.getId(),
                maquina.getNome(),
                maquina.getFabricante(),
                maquina.getModelo(),
                maquina.getDetalhes(),
                maquina.getLocalizacao(),
                dataAquisicaoFormatada, // Adicione a data formatada
                maquina.getTempoVidaEstimado(),
            });
        }
    }
    

    public void gerarRelatorioPDF() {
        try {
            String caminhoArquivo = "RelatoriosPDF/relatorio_maquinas.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();
            document.add(new Paragraph("Relatório de Máquinas\n\n"));

            List<Maquina> maquinas = maquinaController.readMaquina();
            for (Maquina maquina : maquinas) {
                document.add(new Paragraph("ID: " + maquina.getId()));
                document.add(new Paragraph("Código: " + maquina.getCodigo()));
                document.add(new Paragraph("Nome: " + maquina.getNome()));
                document.add(new Paragraph("Fabricante: " + maquina.getFabricante()));
                document.add(new Paragraph("Modelo: " + maquina.getModelo()));
                document.add(new Paragraph("Data de Aquisição: " + maquina.getDataAquisicao()));
                document.add(new Paragraph("Detalhes: " + maquina.getDetalhes()));
                document.add(new Paragraph("Localização: " + maquina.getLocalizacao()));
                document.add(new Paragraph("Tempo de Vida Estimado: " + maquina.getTempoVidaEstimado()));
                document.add(new Paragraph("Manual: " + maquina.getManual()));
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

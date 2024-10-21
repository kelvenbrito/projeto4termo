package com.example.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.TecnicosController;
import com.example.models.Tecnicos;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TecnicosPanel extends JPanel {
    // Atributos
    private TecnicosController tecnicosController;
    private JTable tecnicoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarTecnico;
    private JButton btnGerarRelatorio;
    int esc = 0; // 1 para cadastro, 2 para edição

    // Construtor
    public TecnicosPanel() {
        super(new BorderLayout());
        tecnicosController = new TecnicosController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Especialidade", "Disponibilidade"
        }, 0);
        tecnicoTable = new JTable(tableModel);

        atualizarTabela();
        JScrollPane scrollPane = new JScrollPane(tecnicoTable);
        this.add(scrollPane, BorderLayout.CENTER);
        configurarBotoes();
        this.setSize(500, 500);
    }

    private void configurarBotoes() {
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Editar");
        btnGerarRelatorio = new JButton("Gerar Relatório");
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        painelInferior.add(btnGerarRelatorio);
        this.add(painelInferior, BorderLayout.SOUTH);

        btnCadastrarTecnico.addActionListener(e -> {
            esc = 1;
            janelaCadastroTecnico();
        });

        btnSalvarAlteracoes.addActionListener(e -> {
            int selectedRow = tecnicoTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecione um Técnico para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                esc = 2; // Modo edição
                janelaCadastroTecnico();
            }
        });

        btnGerarRelatorio.addActionListener(e -> gerarRelatorioPDF());
    }

    public void janelaCadastroTecnico() {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Cadastrar Técnico", true);
        dialog.setSize(500, 500);
        dialog.setLayout(new GridLayout(5, 2));

        JTextField[] inputs = criarCamposEntrada(dialog);
        JButton btnSalvar = new JButton("Salvar");
        dialog.add(btnSalvar);

        if (esc == 2) {
            preencherCamposParaEdicao(inputs);
        }

        btnSalvar.addActionListener(e -> {
            salvarTecnico(inputs, dialog);
        });

        dialog.setVisible(true);
        atualizarTabela();
    }

    private JTextField[] criarCamposEntrada(JDialog dialog) {
        String[] labels = {"ID:", "Nome:", "Especialidade:", "Disponibilidade:"};

        JTextField[] inputs = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
            dialog.add(new JLabel(labels[i]));
            inputs[i] = new JTextField(20);
            dialog.add(inputs[i]);
        }
        return inputs;
    }

    private void preencherCamposParaEdicao(JTextField[] inputs) {
        int selectedRow = tecnicoTable.getSelectedRow();
        if (selectedRow != -1) {
            String selectedId = tableModel.getValueAt(selectedRow, 0).toString();
            Tecnicos tecnicoSelecionado = tecnicosController.readTecnicos().stream()
                    .filter(tecnico -> tecnico.getId().equals(selectedId))
                    .findFirst()
                    .orElse(null);

            if (tecnicoSelecionado != null) {
                inputs[0].setText(tecnicoSelecionado.getId());
                inputs[0].setEnabled(false);
                inputs[1].setText(tecnicoSelecionado.getNome());
                inputs[2].setText(tecnicoSelecionado.getEspecialidade());
                inputs[3].setText(tecnicoSelecionado.getDisponibilidade());
            } else {
                JOptionPane.showMessageDialog(this, "Técnico não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Técnico selecionado para edição.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarTecnico(JTextField[] inputs, JDialog dialog) {
        if (validarCampos(inputs, dialog)) {
            try {
                Tecnicos novoTecnico = criarTecnico(inputs);
                if (esc == 1) {
                    // Cadastro
                    tecnicosController.createTecnicos(novoTecnico);
                    JOptionPane.showMessageDialog(dialog, "Técnico cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else if (esc == 2) {
                    // Edição
                    tecnicosController.updateTecnicos(Integer.parseInt(inputs[0].getText()), novoTecnico);
                    JOptionPane.showMessageDialog(dialog, "Técnico atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                dialog.dispose(); // Fechar o diálogo somente após salvar
                atualizarTabela(); // Atualizar tabela após o fechamento do diálogo

            } catch (Exception e) {
                JOptionPane.showMessageDialog(dialog, "Erro ao salvar o Técnico: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validarCampos(JTextField[] inputs, JDialog dialog) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].getText().isEmpty()) { // Campos obrigatórios
                JOptionPane.showMessageDialog(dialog, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private Tecnicos criarTecnico(JTextField[] inputs) {
        Tecnicos novoTecnico = new Tecnicos();
        novoTecnico.setId(inputs[0].getText());
        novoTecnico.setNome(inputs[1].getText());
        novoTecnico.setEspecialidade(inputs[2].getText());
        novoTecnico.setDisponibilidade(inputs[3].getText());
        return novoTecnico;
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Tecnicos> tecnicos = tecnicosController.readTecnicos();
        for (Tecnicos tecnico : tecnicos) {
            tableModel.addRow(new Object[]{
                tecnico.getId(),
                tecnico.getNome(),
                tecnico.getEspecialidade(),
                tecnico.getDisponibilidade(),
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

        String caminhoArquivo = "RelatoriosPDF/relatorio_historicoTecnicos.pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
        document.open();
        document.add(new Paragraph("Relatório de Técnicos\n\n"));

        // Coleta os técnicos
        List<Tecnicos> tecnicos = tecnicosController.readTecnicos();
        for (Tecnicos tecnico : tecnicos) {
            document.add(new Paragraph("ID: " + tecnico.getId()));
            document.add(new Paragraph("Nome: " + tecnico.getNome()));
            document.add(new Paragraph("Especialidade: " + tecnico.getEspecialidade()));
            document.add(new Paragraph("Disponibilidade: " + tecnico.getDisponibilidade()));
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

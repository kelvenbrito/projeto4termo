package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel extends JPanel {
    // Atributos
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnEditar;
    private JButton btnCadastrarMaquina;
    int esc = 0;

    // COnstrutor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();

        tableModel = new DefaultTableModel(new Object[] {
                "ID", "Código", "Nome", "Fabricante", "Modelo", "Detalhes", "Data de Aquisicao", "Localização",
                "Tempo Vida", "Manual"
        }, 0);
        maquinasTable = new JTable(tableModel);

        AtualizarTabela();
        JScrollPane scrollPane = new JScrollPane(maquinasTable);

        this.add(scrollPane, BorderLayout.CENTER);

        // adicionar os botoes
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnEditar = new JButton("SEditar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnEditar);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões

        btnCadastrarMaquina.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                esc = 1;
                JanelaCadastroMaquina();

            }
        });
        //
        btnEditar.addActionListener(e -> {

            esc = 2;
            JanelaCadastroMaquina();
        });

        this.setSize(500, 500);
    }

    // Método para abrir a nova janela de cadastro de máquina
    private void JanelaCadastroMaquina() {
        // Criar o diálogo
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Cadastrar Máquina", true);
        dialog.setSize(500, 500);
        dialog.setLayout(new GridLayout(12, 2));

        // Campos de entrada
        JLabel lblId = new JLabel("ID:");
        JTextField inputId = new JTextField(20);
        JLabel lblcod = new JLabel("codigo:");
        JTextField inputcod = new JTextField(20);
        JLabel lblNome = new JLabel("Nome:");
        JTextField inputNome = new JTextField(20);
        JLabel lblFabricante = new JLabel("Fabricante:");
        JTextField inputFabricante = new JTextField(20);
        JLabel lblModelo = new JLabel("Modelo:");
        JTextField inputModelo = new JTextField(20);
        JLabel lblDataAquiz = new JLabel("Data de Aquisicao:");
        JTextField inputDataAquiz = new JTextField(20);
        JLabel lblDetalhes = new JLabel("Detalhes:");
        JTextField inputDetalhes = new JTextField(20);
        JLabel lblLocalizacao = new JLabel("Localização:");
        JTextField inputLocalizacao = new JTextField(20);
        JLabel lblTempoVida = new JLabel("Tempo Vida:");
        JTextField inputTempoVida = new JTextField(20);
        JLabel lblmanual = new JLabel("Manual:");
        JTextField inputmanual = new JTextField(20);

        // Botão para salvar a nova máquina
        JButton btnSalvar = new JButton("Salvar");

        // Adicionar componentes ao diálogo
        dialog.add(lblId);
        dialog.add(inputId);
        dialog.add(lblcod);
        dialog.add(inputcod);
        dialog.add(lblNome);
        dialog.add(inputNome);
        dialog.add(lblFabricante);
        dialog.add(inputFabricante);
        dialog.add(lblModelo);
        dialog.add(inputModelo);
        dialog.add(lblDataAquiz);
        dialog.add(inputDataAquiz);
        dialog.add(lblDetalhes);
        dialog.add(inputDetalhes);
        dialog.add(lblLocalizacao);
        dialog.add(inputLocalizacao);
        dialog.add(lblTempoVida);
        dialog.add(inputTempoVida);
        dialog.add(lblmanual);
        dialog.add(inputmanual);
        dialog.add(btnSalvar);

        if (esc == 1) {

        } else if (esc == 2) {
            int selectedRow = maquinasTable.getSelectedRow(); // Obter a linha selecionada

            if (selectedRow != -1) { // Verificar se alguma linha está selecionada
                // Obter os valores da linha selecionada e preencher os campos
                inputId.setText(tableModel.getValueAt(selectedRow, 0).toString());
                inputcod.setText(tableModel.getValueAt(selectedRow, 1).toString());
                inputNome.setText(tableModel.getValueAt(selectedRow, 2).toString());
                inputFabricante.setText(tableModel.getValueAt(selectedRow, 3).toString());
                inputModelo.setText(tableModel.getValueAt(selectedRow, 4).toString());
                inputDataAquiz.setText(tableModel.getValueAt(selectedRow, 5).toString());
                inputDetalhes.setText(tableModel.getValueAt(selectedRow, 6).toString());
                inputLocalizacao.setText(tableModel.getValueAt(selectedRow, 7).toString());
                inputTempoVida.setText(tableModel.getValueAt(selectedRow, 8).toString());
                inputmanual.setText(tableModel.getValueAt(selectedRow, 9).toString());
            } else {
                System.out.println("Nenhuma máquina selecionada para edição.");
                return; // Não abre o diálogo se nenhuma linha estiver selecionada
            }
        } else {
            System.out.println("ERRO CAD ou EDIT");
        }

        // ActionListener do botão "Salvar"
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Criar nova máquina com os dados inseridos
                Maquina novaMaquina = new Maquina();
                novaMaquina.setId(inputId.getText());
                novaMaquina.setCodigo(inputcod.getText());
                novaMaquina.setNome(inputNome.getText());
                novaMaquina.setFabricante(inputFabricante.getText());
                novaMaquina.setModelo(inputModelo.getText());
                novaMaquina.setDataAquisicao(LocalDate.parse(inputDataAquiz.getText()));
                novaMaquina.setDetalhes(inputDetalhes.getText());
                novaMaquina.setLocalizacao(inputLocalizacao.getText());
                novaMaquina.setTempoVidaEstimado(Integer.parseInt(inputTempoVida.getText()));
                novaMaquina.setManual(inputmanual.getText());
                if (esc == 1) {
                    // Enviar os dados ao controlador
                    maquinaController.createMaquina(novaMaquina);
                } else if (esc == 2) {

                    maquinaController.updateMaquina(Integer.parseInt(inputId.getText()), novaMaquina);
                } else {
                    System.out.println("ERRO CAD ou EDIT");
                }

                // Fechar o diálogo
                dialog.dispose();
            }
        });

        // Exibir o diálogo
        dialog.setVisible(true);

        // Atualizar a tabela com a nova máquina
        AtualizarTabela();
    }

    private void AtualizarTabela() {
        // Limpar a tabela antes de adicionar novos dados
        tableModel.setRowCount(0);
        // Criar a tabela
        List<Maquina> maquinas = maquinaController.readMaquina();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[] {
                    maquina.getId(),
                    maquina.getCodigo(),
                    maquina.getNome(),
                    maquina.getFabricante(),
                    maquina.getModelo(),
                    maquina.getDataAquisicao(),
                    maquina.getDetalhes(),
                    maquina.getLocalizacao(),
                    maquina.getTempoVidaEstimado(),
                    maquina.getManual()

            });
        }
    }

}

package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.TecnicosController;

import com.example.models.Tecnicos;

public class TecnicosPanel extends JPanel {
    // Atributos
    private TecnicosController tecnicosController;
    private JTable tecnicoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    // Construtor
    public TecnicosPanel() {
        super(new BorderLayout());
        tecnicosController = new TecnicosController();

        tableModel = new DefaultTableModel(new Object[] {
                "ID", "nome", "especialidade", "disponibilidade"
        }, 0);
        tecnicoTable = new JTable(tableModel);

        // Criar a tabela
        List<Tecnicos> tecnicos = tecnicosController.readTecnicos();
        for (Tecnicos tecnico : tecnicos) {
            tableModel.addRow(new Object[] {
                    tecnico.getId(),
                    tecnico.getNome(),
                    tecnico.getEspecialidade(),
                    tecnico.getDisponibilidade(),

            });
        }
        JScrollPane scrollPane = new JScrollPane(tecnicoTable);

        this.add(scrollPane, BorderLayout.CENTER);

        // adicionar os botoes
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões
        btnCadastrarMaquina.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //
        btnSalvarAlteracoes.addActionListener(e -> {

        });
    }
}

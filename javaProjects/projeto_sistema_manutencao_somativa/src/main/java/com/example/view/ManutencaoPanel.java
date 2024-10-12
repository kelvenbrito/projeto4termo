package com.example.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;

public class ManutencaoPanel extends JPanel {
   //Atributos
    private ManutencaoController manutencaoController;
    private JTable manutencaoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    //COnstrutor
    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new ManutencaoController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "maquinaID", "data", "tipo", "pecasTrocadas", "tempoDeParada", "tecnicoId","observacoes"
        },0);
        manutencaoTable = new JTable(tableModel);

        //Criar a tabela
        List<Manutencao> manutencoes = manutencaoController.readManutencao();
        for (Manutencao manutencao : manutencoes) {
            tableModel.addRow(new Object[]{
                manutencao.getId(),
                manutencao.getMaquinaID(),
                manutencao.getData(),
                manutencao.getTipo(),
                manutencao.getPecasTrocadas(),
                manutencao.getTempoDeParada(),
                manutencao.getTecnicoID(),
                manutencao.getObservacoes(),
             
               
            });
        }
        JScrollPane scrollPane = new JScrollPane(manutencaoTable);
      

        this.add(scrollPane, BorderLayout.CENTER);

        //adicionar os botoes
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes =  new JButton("Salvar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        //Criar as ActionListener para Botões
        btnCadastrarMaquina.addActionListener(new ActionListener(){
        
           

            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        //
        btnSalvarAlteracoes.addActionListener(e -> {
            
        });
    }
}

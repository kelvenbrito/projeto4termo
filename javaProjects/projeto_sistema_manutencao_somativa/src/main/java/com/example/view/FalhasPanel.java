package com.example.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.FalhaController;
import com.example.models.Falhas;
public class FalhasPanel extends JPanel {
//Atributos
    private FalhaController falhaController;
    private JTable falhaTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    //Construtor
    public FalhasPanel() {
        super(new BorderLayout());
        falhaController = new FalhaController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "maquinaID", "data", "problema", "prioridade", "operador",
        },0);
        falhaTable = new JTable(tableModel);

        //Criar a tabela
        List<Falhas> falhas = falhaController.readFalha();
        for (Falhas falha : falhas) {
            tableModel.addRow(new Object[]{
                falha.getId(),
                falha.getMaquinaID(),
                falha.getData(),
                falha.getProblema(),
                falha.getPrioridade(),
                falha.getOperador(),
              
             
               
            });
        }
        JScrollPane scrollPane = new JScrollPane(falhaTable);
      

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

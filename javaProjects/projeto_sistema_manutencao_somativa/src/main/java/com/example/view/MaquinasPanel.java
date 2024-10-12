package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;



public class MaquinasPanel extends JPanel {
    //Atributos
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;
    private JTextField inputNome;
    private JTextField inputID;

    //COnstrutor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Fabricante", "Modelo", "Detalhes", "Localização", "Tempo Vida"
        },0);
        maquinasTable = new JTable(tableModel);

        //Criar a tabela
        List<Maquina> maquinas = maquinaController.readMaquina();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[]{
                maquina.getId(),
                maquina.getNome(),
                maquina.getFabricante(),
                maquina.getModelo(),
                maquina.getDetalhes(),
                maquina.getLocalizacao(),
                maquina.getTempoVidaEstimado()
               
            });
        }
        JScrollPane scrollPane = new JScrollPane(maquinasTable);
      

        this.add(scrollPane, BorderLayout.CENTER);

        //adicionar os botoes
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes =  new JButton("Salvar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);


        inputNome = new JTextField(20);

        //Criar as ActionListener para Botões
        Maquina novaMaquina = new Maquina();
        MaquinaController mc = new MaquinaController();
        btnCadastrarMaquina.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
               novaMaquina.setNome(inputNome.getText());
               mc.createMaquina(novaMaquina);
            }
        });
        //
        btnSalvarAlteracoes.addActionListener(e -> {
            
        });
    }

}

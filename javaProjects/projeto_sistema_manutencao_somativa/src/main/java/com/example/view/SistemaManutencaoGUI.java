package com.example.view;

import javax.swing.*;

import java.awt.*;


public class SistemaManutencaoGUI extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel painelMaquinas;
    private JPanel painelManutencao;
    private JPanel painelFalhas;
    private JPanel painelTecnicos;

    public SistemaManutencaoGUI() {
        //Configurações iniciais do frame
        super("Sistema de Manutenção");
        this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        //Inicialização dos paineis
        painelMaquinas = new MaquinasPanel();
        painelManutencao =  new ManutencaoPanel();
        painelFalhas = new FalhasPanel();
        painelTecnicos = new TecnicosPanel();

        //Criar meu TabbedPane
        tabbedPane = new JTabbedPane();
        tabbedPane.add("Maquinas", painelMaquinas);
        tabbedPane.add("Manutenção", painelManutencao);
        tabbedPane.add("Falhas", painelFalhas);
        tabbedPane.add("Técnicos", painelTecnicos);

        this.add(tabbedPane, BorderLayout.CENTER);
    }

}

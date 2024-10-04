package com.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CalculadoraAbas extends JFrame {
    //Atributos


    //construtor
    public CalculadoraAbas() {
        super("Calculadora ABAS!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);

        //Adicionar os componentes
        JTabbedPane abas = new JTabbedPane();
        
        JPanel calcSimples = new CalculadoraSimples();
        abas.addTab("Simples", calcSimples);

       JPanel calcAvancada = new CalculadoraAvancada();
        abas.addTab("Avancada", calcAvancada);

        this.add(abas);
        this.setVisible(true); 
    }
}

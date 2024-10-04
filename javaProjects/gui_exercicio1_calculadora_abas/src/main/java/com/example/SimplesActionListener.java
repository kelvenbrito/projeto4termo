package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SimplesActionListener implements ActionListener {
    private double valorAtual;
    JPanel calcSimples = new CalculadoraSimples();

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.matches("\\d")) {
            //composição dos numeros
          ((CalculadoraSimples) calcSimples).setDisplay(((CalculadoraSimples) calcSimples).getDisplay() + comando);
        
    } else if(comando.matches("[+\\-*/]")){
        //seleção da operação
        valorAtual = Double.parseDouble(((CalculadoraSimples) calcSimples).getDisplay())
    }
    
}

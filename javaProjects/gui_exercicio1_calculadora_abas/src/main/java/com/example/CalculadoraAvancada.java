package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class  CalculadoraAvancada extends JPanel  {
      JTextField displayAvancado;
    String[] botoes = {"^", "sqrt", "log", "!",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "C" };

    // Construtor
    public CalculadoraAvancada() {
        super(new BorderLayout());
        displayAvancado = new JTextField();
        displayAvancado.setHorizontalAlignment(JTextField.RIGHT);
        displayAvancado.setEditable(false);
        this.add(displayAvancado, BorderLayout.NORTH);

        // Criar um painel para os botões
        JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 3, 3));
        for (String textoBotoes : botoes) {
            JButton botao = new JButton(textoBotoes);
            // adicionar ação dos botoes
            painelBotoes.add(botao);

            this.add(painelBotoes, BorderLayout.CENTER);
        }
    }
}



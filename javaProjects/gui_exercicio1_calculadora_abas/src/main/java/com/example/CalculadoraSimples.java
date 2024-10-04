package com.example;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSimples extends JPanel {
    JTextField displaySimples;
    String[] botoes = { "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "C" };

    // Construtor
    public CalculadoraSimples() {
        super(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        this.add(displaySimples, BorderLayout.NORTH);

        // Criar um painel para os botões
        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 3, 3));
        for (String textoBotoes : botoes) {
            JButton botao = new JButton(textoBotoes);
            // adicionar ação dos botoes
            botao.addActionListener(new ActionListener() {
                
            });
            painelBotoes.add(botao);
        }
            this.add(painelBotoes, BorderLayout.CENTER);
      
    }

    //altera valor display
 public void setDisplay(String texto) {
     this.displaySimples.setText(texto);
    }

    //pega valor display
    public String getDisplay(){
        return displaySimples.getText();
   

    public class SimpleActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }
        
    }

}
package com.example;

public class Eletronico extends Produto {
    // atributo
    private double peso;

    //construtor
    public Eletronico(String nome, double preco, double peso){
        super(nome, preco);
        this.peso=peso;
    }
}

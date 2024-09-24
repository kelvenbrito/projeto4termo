package com.example;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Professor extends Pessoa {
    //Atributo
    private double salario;

    public Professor(String nome, String cpf, double salario) {
        super(nome, cpf);
        this.salario=salario;
    }
    // Métodos exibir Info
    @Override
    public String exibirInfo(){
        super.exibirInfo();
        return " Salário: "+salario;
    }
}

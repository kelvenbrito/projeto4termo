package com.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class Funcionario {
    //atributos
    private String nome;
    private int idade;
    private double salario;
  
    
    //toString
    @Override
    public String toString(){
        return " Nome:" +nome+ " Salario" +salario+ " Idade" +idade;
    }
}

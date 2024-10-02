package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Usuario {
// atributos
private String id;
private String nome;
private int idade;
private String endereco;


@Override
public String toString(){
    return "Nome: "+nome+" idade:"+idade;
}

    
}
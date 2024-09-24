package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Contrutor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Pessoa {
    // Atributos
    private String nome;
    private String cpf;
    //Método
    public String exibirInfo(){
        return "Nome: "+nome+" CPF "+cpf;
    }

    

}

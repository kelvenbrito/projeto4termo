package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;

    public SetExemplo(){
        nomes = new HashSet<>();
    }
    // add
    public void adicionarNome(String nome) {
        nomes.add(nome);
        System.out.println(nomes);
    }

    // list
    public void listarNomes() {
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    // remove
    public void deleteNome(String nome) {
        nomes.remove(nome);
        System.out.println(nome);
    }

    //update
    public void  modificarNomeIndex(String nome, String nomeNovo){
       nomes.remove(nome);
        nomes.add(nomeNovo);
        System.out.println("Nome Alterado de "+nome+" para "+nomeNovo);
    }
}


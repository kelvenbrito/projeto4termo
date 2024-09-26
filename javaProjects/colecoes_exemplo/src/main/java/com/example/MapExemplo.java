package com.example;
import java.util.Map; 
import java.util.HashMap;;

public class MapExemplo {
    private Map<String,Integer> nomeIdade;

    public MapExemplo() {
       nomeIdade = new HashMap<>();
    }

    public void adicionarNomeIdade(String nome, int idade ){
        nomeIdade.put(nome,idade);
    }

    //Listar
    public void listarNomesIdades(){
        for (String nome: nomeIdade.keySet()) {
            int value = nomeIdade.get(nome);
            System.out.println(nome + " "+value);
        }
    }

    //Remove
    public void deletarNomeIdade(String key){
        nomeIdade.remove(key);
    }

    //Update
    public void update(String key, int value){
        nomeIdade.replace(key, value);
    }
}

package com.example.controllers;
import java.util.*;

import com.example.api.ManutencaoAPI;
import com.example.models.Manutencao;



public class ManutencaoController {
        private List<Manutencao> manutencoes;
    public ManutencaoController() {
       manutencoes = new ArrayList<>();
    }

     //Métodos - CRUD

    //Criar
    public void createManutencao(Manutencao manutencao){
        ManutencaoAPI.postManutencao(manutencao);
        this.manutencoes.add(manutencao);
    }

    //list
    public List<Manutencao> readManutencao(){
      manutencoes = ManutencaoAPI.getManutencao();
      return manutencoes;
    }

    //update
    public void updateManutencao(int posicao,Manutencao manutencao){
        ManutencaoAPI.putManutencao(manutencao);
        manutencoes.set(posicao,manutencao);
    }

    

}

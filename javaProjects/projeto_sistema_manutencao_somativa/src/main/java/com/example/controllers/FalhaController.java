package com.example.controllers;
import java.util.*;

import com.example.api.FalhaAPI;
import com.example.models.Falha;


public class FalhaController {
     private List<Falha> falhas;

public FalhaController() {
      falhas = new ArrayList<>();
}

  //Métodos - CRUD

    //Criar
    public void createFalha(Falha falha){
        this.falhas.add(falha);
    }

    //list
    public List<Falha> readFalha(){
      falhas = FalhaAPI.getFalha();
      return falhas;
    }

    //update
    public void updateFalha(int posicao,Falha falha){
        falhas.set(posicao,falha);
    }

    //Delete
    public void deleteFalha(int posicao){
        falhas.remove(posicao);
    }

}

    

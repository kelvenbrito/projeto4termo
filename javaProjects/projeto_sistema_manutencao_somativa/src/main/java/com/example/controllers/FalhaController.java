package com.example.controllers;
import java.util.*;

import com.example.api.FalhaAPI;
import com.example.models.Falhas;


public class FalhaController {
     private List<Falhas> falhas;

public FalhaController() {
      falhas = new ArrayList<>();
}

  //Métodos - CRUD

    //Criar
    public void createFalha(Falhas falha){
      FalhaAPI.postFalha(falha);
        this.falhas.add(falha);
    }

    //list
    public List<Falhas> readFalha(){
      falhas = FalhaAPI.getFalha();
      return falhas;
    }

    //update
    public void updateFalha(int posicao,Falhas falha){
      FalhaAPI.putFalha(falha);
        falhas.set(posicao,falha);
    }

  

}

    

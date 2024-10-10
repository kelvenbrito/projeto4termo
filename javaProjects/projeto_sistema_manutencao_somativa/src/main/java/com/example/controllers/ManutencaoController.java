package com.example.controllers;
import java.util.*;

import com.example.api.MaquinaAPI;
import com.example.models.Maquina;


public class ManutencaoController {
        private List<Maquina> maquinas;
    public ManutencaoController() {
       maquinas = new ArrayList<>();
    }

     //Métodos - CRUD

    //Criar
    public void createFalha(Maquina maquina){
        this.maquinas.add(maquina);
    }

    //list
    public List<Maquina> readMaquina(){
      maquinas = MaquinaAPI.getMaquinas();
      return maquinas;
    }

    //update
    public void updateMaquina(int posicao,Maquina maquina){
        maquinas.set(posicao,maquina);
    }

    //Delete
    public void deleteMaquina(int posicao){
        maquinas.remove(posicao);
    }

}

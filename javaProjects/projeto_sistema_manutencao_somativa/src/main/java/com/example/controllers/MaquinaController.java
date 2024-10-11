package com.example.controllers;

import com.example.api.MaquinaAPI;
import com.example.models.Maquina;
import java.util.List;
import java.util.ArrayList;


public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController(){
        maquinas = new ArrayList<>();
    }

    //Métodos - CRUD

    //Criar
    public void createMaquina(Maquina maquina){
        MaquinaAPI.postMaquina(maquina);//adicionar a API no crontrolle
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

package com.example.controllers;
import java.util.List;
import java.util.ArrayList;

import com.example.api.TecnicosAPI;
import com.example.models.Tecnicos;


public class TecnicosController {
      private List<Tecnicos> tecnicos;

    public TecnicosController(){
        tecnicos = new ArrayList<>();
    }

     //Métodos - CRUD

    //Criar
    public void createTecnicos(Tecnicos tecnicos){
        TecnicosAPI.postTecnicos(tecnicos);//adicionar a API no crontrolle
        this.tecnicos.add(tecnicos);
    }

    //list
    public List<Tecnicos> readTecnicos(){
      tecnicos = TecnicosAPI.getTecnicos();
      return tecnicos;
    }

    //update
    public void updateTecnicos(int posicao,Tecnicos tecnico){
        TecnicosAPI.putTecnicos(tecnico);
        tecnicos.set(posicao,tecnico);
    }

    //Delete
    public void deleteTecnicos(int posicao, String id){
        TecnicosAPI.deleteTecnicos(id);
        tecnicos.remove(posicao);
    }
}

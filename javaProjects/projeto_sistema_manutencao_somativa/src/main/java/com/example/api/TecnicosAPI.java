package com.example.api;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Tecnicos;

public class TecnicosAPI {
    // private URL url;

    public static List<Tecnicos> getTecnicos() {
        String json = ApiConnection.getData("tecnicos");
        List<Tecnicos> tecnicos = new ArrayList<>();
        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tecnicos tecnico = new Tecnicos(
                        jsonObject.getString("id"),
                        jsonObject.getString("nome"),
                        jsonObject.getString("especialidade"),
                        jsonObject.getString("disponibilidade")

                );
                tecnicos.add(tecnico);
            }
        }

        return tecnicos;
    }

     public  static void postTecnicos(Tecnicos tecnico) {
        // estabelecer conexão

    
        JSONObject tecnicoJson = new JSONObject();
        tecnicoJson.put("id", tecnico.getId());
        tecnicoJson.put("nome", tecnico.getNome());
        tecnicoJson.put("especialidade", tecnico.getEspecialidade());
        tecnicoJson.put("disponibilidade", tecnico.getDisponibilidade());
       if (!tecnicoJson.isEmpty()) {
        ApiConnection.postData("tecnicos", tecnicoJson.toString());
       }
       
     
    }

    public  static void putTecnicos(Tecnicos tecnico) {
        // estabelecer conexão
        JSONObject tecnicoJson = new JSONObject();
        tecnicoJson.put("id", tecnico.getId());
        tecnicoJson.put("nome", tecnico.getNome());
        tecnicoJson.put("especialidade", tecnico.getEspecialidade());
        tecnicoJson.put("disponibilidade", tecnico.getDisponibilidade());
       if (!tecnicoJson.isEmpty()) {
        ApiConnection.postData("tecnicos", tecnicoJson.toString());
       }
       
    }


    public  static void deleteTecnicos(String id) {
        if (!id.isEmpty()) {
            ApiConnection.deleteData("tecnicos", id);
        }
    }
}



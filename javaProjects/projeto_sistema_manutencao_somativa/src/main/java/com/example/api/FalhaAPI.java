package com.example.api;

import java.util.*;
import java.time.LocalDate;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Falhas;


public class FalhaAPI {
    // private URL url;

    public static List<Falhas> getFalha() {
        String json = ApiConnection.getData("falhas");
        List<Falhas> falhas = new ArrayList<>();
        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Falhas falha = new Falhas(
                        jsonObject.getString("id"),
                        jsonObject.getString("maquinaId"),
                        LocalDate.parse(jsonObject.getString("data")),
                        jsonObject.getString("problema"),
                        jsonObject.getString("prioridade"),
                        jsonObject.getString("operador")

                );
                falhas.add(falha);
            }
        }

        return falhas;
    }

    public  static void postFalha(Falhas falha) {
        // estabelecer conexão

    
        JSONObject falhaJson = new JSONObject();
        falhaJson.put("id", falha.getId());
        falhaJson.put("maquinaId", falha.getMaquinaID());
        falhaJson.put("data", falha.getData().toString());
        falhaJson.put("problema", falha.getProblema());
        falhaJson.put("prioridade", falha.getPrioridade());
        falhaJson.put("operador", falha.getOperador());
       if (!falhaJson.isEmpty()) {
        ApiConnection.postData("falhas", falhaJson.toString());
       }
       
     
    }

    public  static void putFalha(Falhas falha) {
        // estabelecer conexão
        JSONObject falhaJson = new JSONObject();
        falhaJson.put("id", falha.getId());
        falhaJson.put("maquinaId", falha.getMaquinaID());
        falhaJson.put("data", falha.getData().toString());
        falhaJson.put("problema", falha.getProblema());
        falhaJson.put("prioridade", falha.getPrioridade());
        falhaJson.put("operador", falha.getOperador());
       if (!falhaJson.isEmpty()) {
        ApiConnection.postData("falhas", falhaJson.toString());
       }

    }


    public  static void deleteFalha(String id) {
        if (!id.isEmpty()) {
            ApiConnection.deleteData("historicoManutencao", id);
        }
    }
}




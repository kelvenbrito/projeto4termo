package com.example.api;
import java.net.URL;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Manutencao;
import com.example.models.Maquina;

public class ManutencaoAPI {
    
    private URL url;

    public static List<Manutencao> getManutencao() {
       String json = ApiConnection.getData("historicoManutencao");
        List<Maquina> manutencoes = new ArrayList<>();
        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Manutencao manutencao = new Manutencao(
                    jsonObject.getString("id"),
                    jsonObject.getString("maquinaId"),
                    jsonObject.getString("data"),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getInt("tempoDeParada"),
                    jsonObject.getString("tecnicoId"),
                    jsonObject.getString("observacoes")
                   
                );
            }
        }

    return null;
    }
}

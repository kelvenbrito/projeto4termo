package com.example.api;

import java.util.*;
import java.time.LocalDate;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Falha;

public class FalhaAPI {
    // private URL url;

    public static List<Falha> getFalha() {
        String json = ApiConnection.getData("falhas");
        List<Falha> falhas = new ArrayList<>();
        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Falha falha = new Falha(
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
}

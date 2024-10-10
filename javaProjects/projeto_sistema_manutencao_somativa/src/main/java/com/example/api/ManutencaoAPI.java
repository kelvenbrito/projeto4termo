package com.example.api;

import java.util.*;
import java.time.LocalDate;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Manutencao;

public class ManutencaoAPI {

    // private URL url;

    public static List<Manutencao> getManutencao() {
        String json = ApiConnection.getData("historicoManutencao");
        List<Manutencao> manutencoes = new ArrayList<>();
        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Manutencao manutencao = new Manutencao(
                        jsonObject.getString("id"),
                        jsonObject.getString("maquinaId"),
                        LocalDate.parse(jsonObject.getString("data")),
                        jsonObject.getString("tipo"),
                        jsonObject.getString("pecasTrocadas"),
                        jsonObject.getInt("tempoDeParada"),
                        jsonObject.getString("tecnicoId"),
                        jsonObject.getString("observacoes")

                );
                manutencoes.add(manutencao);
            }
        }

        return manutencoes;
    }
}

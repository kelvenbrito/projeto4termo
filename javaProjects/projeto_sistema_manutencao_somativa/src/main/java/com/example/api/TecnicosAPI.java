package com.example.api;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Tecnicos;

public class TecnicosAPI {
    // private URL url;

    public static List<Tecnicos> getTecnicos() {
        String json = ApiConnection.getData("Tecnicos");
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
}

package com.example.api;

import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.*;
import java.time.LocalDate;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Maquina;;

public class MaquinaAPI {

    private URL url;

    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("maquinas");
        List<Maquina> maquinas = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Maquina maquina = new Maquina(
                        jsonObject.getString("id"),
                        jsonObject.getString("codigo"),
                        jsonObject.getString("nome"),
                        jsonObject.getString("modelo"),
                        jsonObject.getString("fabricante"),
                        LocalDate.parse(jsonObject.getString("dataAquisicao")),
                        jsonObject.getInt("tempoVidaEstimado"),
                        jsonObject.getString("localizacao"),
                        jsonObject.getString("detalhes"),
                        jsonObject.getString("manual"));
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    public void createUser(Maquina maquina) throws IOException {
        // estabelecer conexão

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        // informações necessárias para o post
        // criando o Objeto Json
        JSONObject maquinaJson = new JSONObject();
        maquinaJson.put("id", maquina.getId());
        maquinaJson.put("codigo", maquina.getCodigo());
        maquinaJson.put("nome", maquina.getNome());
        maquinaJson.put("modelo", maquina.getModelo());
        maquinaJson.put("fabricante", maquina.getFabricante());
        maquinaJson.put("dataAquisicao", maquina.getDataAquisicao());
        maquinaJson.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaJson.put("localizacao", maquina.getFabricante());
        maquinaJson.put("fabricante", maquina.getLocalizacao());
        maquinaJson.put("fabricante", maquina.getFabricante());
        // "id": "1",
        // "codigo": "M001",
        // "nome": "Torno CNC",
        // "modelo": "Delta CNC",
        // "fabricante": "Siemens",
        // "dataAquisicao": "2022-06-10",
        // "tempoVidaEstimado": 10,
        // "localizacao": "Linha 4",
        // "detalhes": "Operação em alta precisão",
        // "manual": "URL do manual"

    }
}

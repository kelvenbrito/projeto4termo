package com.example.api;


import java.util.*;
import java.time.LocalDate;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Maquina;;

public class MaquinaAPI {


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

    public  static void postMaquina(Maquina maquina) {
        // estabelecer conexão

    
        JSONObject maquinaJson = new JSONObject();
        maquinaJson.put("id", maquina.getId());
        maquinaJson.put("codigo", maquina.getCodigo());
        maquinaJson.put("nome", maquina.getNome());
        maquinaJson.put("modelo", maquina.getModelo());
        maquinaJson.put("fabricante", maquina.getFabricante());
        maquinaJson.put("dataAquisicao", maquina.getDataAquisicao().toString());
        maquinaJson.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaJson.put("localizacao", maquina.getLocalizacao());
        maquinaJson.put("detalhes", maquina.getDetalhes());
        maquinaJson.put("manual", maquina.getManual());
       if (!maquinaJson.isEmpty()) {
        ApiConnection.postData("maquinas", maquinaJson.toString());
       }
       
     
    }

    public  static void putMaquina(Maquina maquina) {
        // estabelecer conexão
        JSONObject maquinaJson = new JSONObject();
        maquinaJson.put("id", maquina.getId());
        maquinaJson.put("codigo", maquina.getCodigo());
        maquinaJson.put("nome", maquina.getNome());
        maquinaJson.put("modelo", maquina.getModelo());
        maquinaJson.put("fabricante", maquina.getFabricante());
        maquinaJson.put("dataAquisicao", maquina.getDataAquisicao().toString());
        maquinaJson.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaJson.put("localizacao", maquina.getLocalizacao());
        maquinaJson.put("detalhes", maquina.getDetalhes());
        maquinaJson.put("manual", maquina.getManual());
       if (!maquinaJson.isEmpty()) {
        ApiConnection.putData("maquinas", maquinaJson.toString(),maquina.getId());
       }
       
      
    }


    public  static void deleteMaquina(String id) {
        if (!id.isEmpty()) {
            ApiConnection.deleteData("maquinas", id);
        }
    }
}

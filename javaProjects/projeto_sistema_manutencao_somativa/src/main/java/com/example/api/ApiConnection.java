package com.example.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ApiConnection {
    private static final String API_URL = "http://localhost:3000/";

    public static String getData(String endpoint) {
        try {
            URL url = new URL(API_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();
            return content.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void postData(String endPoint, String inputData) {
        try {
            URL url = new URL(API_URL + endPoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // enviar dos dados para a API
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))) {
                bw.write(inputData.toString());
                bw.flush();
            }
            // Verificar o status da resposta
            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_CREATED) { // HTTP 201 Created
                throw new Exception("Erro ao criar usuário: " + status);
            }

            System.out.println("Usuario Cadastrado com Sucesso");

            connection.disconnect();

            // Retorna o conteúdo da resposta como string

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void putData(String endpoint, String inputData , String id) {
        try {
            // Cria uma URL completa com o endpoint
            URL url = new URL(API_URL + endpoint+ "/"+id);
            // estabelecer conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // enviar dos dados para a API
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))) {
                bw.write(inputData.toString());
                bw.flush();
            }

          // Verificar o status da resposta
          int status = connection.getResponseCode();
          if (status != HttpURLConnection.HTTP_OK) {
                throw new Exception("Erro de Conexão"+status);
            }
            getData(endpoint +"/"+ id);

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void deleteData(String endpoint, String id) {
        try {
            // Cria uma URL completa com o endpoint
            URL url = new URL(API_URL + endpoint + "/"+id);
            // estabelecer conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setDoOutput(true);
            int status = connection.getResponseCode();
             if (status != HttpURLConnection.HTTP_OK) {
                throw new Exception("Erro ao deletar usuario" + status);
            }

            System.out.println("Deletado com sucesso");
            getData(endpoint +"/"+ id);

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}

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

    public static String postData(String endpoint) {
        try {
            URL url = new URL(API_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
         // enviar dos dados para a API
         try (BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))) {
        bw.write(endpoint.toString());
        bw.flush();
    }
    // Verificar o status da resposta
    int status = connection.getResponseCode();
    if (status != HttpURLConnection.HTTP_CREATED) { // HTTP 201 Created
        throw new Exception("Erro ao criar usuário: " + status);
    }

    System.out.println("Usuario Cadastrado com Sucesso");

    
    connection.disconnect();
    return content.toString();

} catch (Exception e) {
    e.printStackTrace();
}
    }

}

package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class UsuarioController {
    private List<Usuario> usuarios;
    private URL url;

    public UsuarioController() {
        usuarios = new ArrayList<>();

    }

    public void read() {
        try {

            // Estabelecer conexão
            url = new URL("http://localhost:3000/usuarios");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // Verificar status da conexão
            int status = con.getResponseCode();
            if (status != 200) {// diferente de 200 lançar uma exception
                throw new Exception("Erro de conexão");
            }

            // Gravar os dados da api na memoria
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linha;
            // Converter em um arquivo de texto(String)
            StringBuffer content = new StringBuffer();
            // Lê a resposta da API linha por linha
            while ((linha = br.readLine()) != null) {
                content.append(linha);
            }
            br.close();// Fecha a conexão
            // Converter o arquivo de texto para dados da classe usuario
            JSONArray dadosUsuarios = new JSONArray(content.toString());

            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuarioJson = dadosUsuarios.getJSONObject(i);
                usuarios.add(new Usuario(
                        usuarioJson.getString("id"),
                        usuarioJson.getString("nome"),
                        usuarioJson.getInt("idade"),
                        usuarioJson.getString("endereco"))

                );
            }
            System.out.println(usuarios.toString() + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createUser(Usuario usuario) {
        try {
            // Estabelecer conexão
            url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "aplication/json; utf-8");
            con.setRequestProperty("Accept", "aplication/json");
            con.setDoOutput(true);
            // Informações necessarias para o post
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());
            // enviar os dados para a API
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(con.getOutputStream(), "UTF-8"))) {
                bw.write(usuarioJson.toString());
                bw.flush();
            }
            // Verificar o status da resposta
            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_CREATED) { // HTTP 201 Created
                throw new Exception("Erro ao criar usuáio: " + status);
            }

            System.out.println("Usuario Cadastrado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

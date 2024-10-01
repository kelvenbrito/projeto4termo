package com.example;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
public class LeituraAPI {
    public void exemplo(){
        try {
            URL url = new URL("https://api.github.com/users/KelvenBrito");
            HttpURLConnection con =  (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status!=200) {
                throw new Exception("Erro de conexão");
            }

            //conexão estabelecida
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //Laço de repetição
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
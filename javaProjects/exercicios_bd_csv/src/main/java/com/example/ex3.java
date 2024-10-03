package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ex3
 */
public class ex3 {
    private ResultSet rs;

    public void produtos() {
        try {
            // estabelece a conexão
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "postgres");
            // Tradutor de sql
            Statement stmt = con.createStatement();
            // Armazenar os resultados
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarProduto() {
        try {
            if (rs == null) {
                System.out.println("O ResultSet não foi inicializado. Chame o método produtos() primeiro.");
                return;
            }
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " Nome: " + rs.getString("nome")
                        + " Preço: " + rs.getDouble("preco"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MaiorMenor() {
        try {
            if (rs == null) {
                System.out.println("O ResultSet não foi inicializado. Chame o método produtos() primeiro.");
                return;
            }

            if (!rs.first())
                return; // Verifica se o ResultSet não está vazio
            double precoMenor = rs.getDouble("preco");
            double precoMaior = rs.getDouble("preco");
            while (rs.next()) {

                if (rs.getDouble("preco") < precoMenor) {
                    precoMenor = rs.getDouble("preco");
                } else if (rs.getDouble("preco") > precoMaior) {
                    precoMaior = rs.getDouble("preco");
                } else {

                }
            }

            System.out.println("Produto mais caro: " + precoMaior);
            System.out.println("Produto mais barato: " + precoMenor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

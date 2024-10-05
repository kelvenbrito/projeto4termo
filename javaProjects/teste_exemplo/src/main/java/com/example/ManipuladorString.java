package com.example;

public class ManipuladorString {
    // Método para inverter a string
    public String invertString(String original) {
        if (original == null) {
            return null;
        }
        return new StringBuilder(original).reverse().toString();
    }

    // Método para contar vogais
    public int contarVogais(String texto) {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        int contador = 0;
        for (char c : texto.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    // Método para contar palavras
    public int contarPalavras(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        String[] palavras = texto.trim().split("\\s+");
        return palavras.length;
    }
}

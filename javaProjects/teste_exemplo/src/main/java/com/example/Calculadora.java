package com.example;

public class Calculadora {
    //Soma
    public double soma(double a, double b){
        return a + b;
    } 

    //Subtrai
    public double subtrai(double a, double b){
        return a - b;
    } 

    //multiplica
    public double multiplica(double a, double b){
        return a * b;
    } 

    //divide
    public double divide(double a, double b){
        if (b == 0) {
           throw new IllegalArgumentException("Não dividiras por Zero"); 
        }
        return a/b;
    } 
}

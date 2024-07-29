package com.example;

public class Calculadora {
    // soma
    public int soma(int a, int b) {
        return a + b;
    }

    // subtração
    public int subtracao(int a, int b) {
        return a - b;
    }

    //multiplicação
    public int multiplicacao(int a, int b) {
        return a * b; 

}

//divisão
public double divisao(double a, double b){
    if (b==0) {
        throw new IllegalArgumentException("Divisãpo por 0 , não permidida");
    }
    return a / b;
}

//potencia
public double potencia(double a, double b){
    return Math.pow(a, b);
}

//raiz
public double raiz(double a, double b){
    if (b<=0) {
        throw new IllegalArgumentException();
    }
    double raiz = 1/b;
    if (a<0 && b%2==0) {
        throw new ArithmeticException();                            
    }
    return Math.pow(a, raiz);

}
}
package com.example;
//Importar a biblioteca

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class CalculadoraTeste {
    Calculadora calc;

    @Before
    public void setup(){
        calc = new Calculadora();
    }

    @Test
    public void testeSoma() {
        int resultado = calc.soma(2, 3);
        assertEquals(5, resultado);
    }

    @Test
    public void testeSubtracao(){
        int resultado = calc.subtracao(9, 4);
        assertEquals(5, resultado);
    }

    @Test
    public void testeMultiplicacao() {
        int resultado = calc.multiplicacao(2, 3);
        assertEquals(6, resultado);
    }


    @Test
    public void testeDivisao() {
        double resultado =  calc.divisao(6, 4);
        assertEquals(1, resultado, 0);
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void testeDivisaoPorZero() {
        double resultado = calc.divisao(5, 0);
    }

    @Test
    public void testePotencia(){
        double resultado = calc.potencia(3, 3);
        assertEquals(27, resultado, 0.1);
    }

    @Test
    public void testeRaiz(){
        double resultado = calc.raiz(27, 3);
        assertEquals(3, resultado, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeRaizZero(){
        double resultado = calc.raiz(4, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testeRaizNegativa(){
        double resultado = calc.raiz(-8, 2);
    }
}




package com.example;
import java.util.Scanner;


public class Exercicio4Recursao{
    //atributos
    int numero = -1;

    Scanner sc = new Scanner(System.in);

    //metodo
    //calcular o fatorial!!!! - recursao

    public long fatorial (int numero){
        if (numero==0||numero == 1) {
            return 1;
        }else{
            return numero*fatorial(numero-1);
        }
    }

    // faser a operação
    public void caculadora() throws Exception{
        while (true)  {
            System.out.println("Digite o n°!");
            numero =  sc.nextInt();
            if (numero<0) {
                throw new Exception("Não é permetido n° negativos! ");
            }
            try {
                long resultado = fatorial(numero);
                System.out.println("O fatorial é "+resultado);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}

package com.example;

import java.util.Scanner;

public class Exercicio3 {
    // Atributos
    boolean sair = false;
    int n1, n2;
    double result;
    String op, resp="";

    public double soma(double a, double b) {
        this.result = a + b;
        return result;
    }

    public double sub(double a, double b) {
        this.result = a * b;
        return result;
    }

    public double mult(double a, double b) {
        this.result = a * b;
        return result;
    }

    public double div(double a, double b) {
        
        try {
            if (a < 0) {
                throw new Exception(" Numero deve ser maior que Zero") {

                };
            }
            this.result = a / b;

        } catch (Exception e) {
            System.err.println(e);
        }
        return result;

    }

    public double raizQ(double a, double b) {

        try {
            if (a < 0) {
                throw new Exception(" Numero deve ser maior que Zero") {

                };
            }
            this.result = Math.sqrt(a);

        } catch (Exception e) {
            System.err.println(e);
        }
        return result;

    }

    public void caculadora() {
        Scanner sc = new Scanner(System.in);
        Scanner ss = new Scanner(System.in);
   

    
      

            do{
                try {
                System.out.println("Escolha a operação que voce deseja (+, -, *, /, %-[raiz quatrada])");
                op = ss.nextLine();
                System.out.println("Escolha o 1° numero");
                n1 = sc.nextInt();
                System.out.println("Escolha o 2° numero");
                n2 =  sc.nextInt();
                
                switch (op) {
                    case "+":
                       soma(n2, n1);
                        break;
                    case "-":
                       sub(n2, n1);
                        break;
                    case "*":
                       mult(n2, n1);
                        break;
                    case "/":
                       div(n2, n1);
                        break;
                    case "%":
                       raizQ(n2, n1);
                        break;

                    default:
                    System.out.println("digite um simbolo valido!");
                    result=0;
                        break;
                }
                System.out.println("Resposta: " +result);
                System.out.println("\nDejesa sair");
                resp = ss.nextLine();
                if (resp.equals("sim")) {
                
                   sair = true; 
                }
            } catch (Exception e) {
                System.out.println("Digite um numero valido!/n");
            }
            } while (!sair);
     

    }
}

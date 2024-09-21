package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FuncionarioController gerenciaFuncionario = new FuncionarioController();
        int operacao = 0;
        do {
            operacao = Integer.parseInt(JOptionPane.showInputDialog("""


                    \n---Gerenciamento de Funcionarios---\n
                    1-Adicionar Funcionario\n
                    2-Listar Funcionario\n
                    3-Buscar FUncionario\n
                    4-Remover Funcionario\n
                    4-Media salarial\n
                    5-Sair...
                    """));
            switch (operacao) {
                case 1:
                    gerenciaFuncionario.addFuncionario();
                    break;
                case 2:
                    gerenciaFuncionario.listarFuncionarios();
                    break;
                case 3:
                    gerenciaFuncionario.buscarFuncionario();
                    break;
                case 4:
                    gerenciaFuncionario.deletarFuncinario();
                    break;
                case 5:
                    gerenciaFuncionario.calculoMediaSalario();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Insira uma opção valida!");
                    break;
            }
        } while (operacao != 6);
    }
}
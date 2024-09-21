package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * FuncionarioController
 */
public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    // Método add
    public void addFuncionario() {
        // Criar um funcionario
        String nome = JOptionPane.showInputDialog("Digite o Nome do funcionário");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário"));
        Funcionario funcionario = new Funcionario(nome, idade, salario); // Adicionado '=' aqui
        funcionarios.add(funcionario);
    }

    // Método listar todos os funcionários
    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }
    
    // Buscar funcionário pelo nome
    public void buscarFuncionario() {
        String nome = JOptionPane.showInputDialog("Digite o nome a ser buscado");

        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    System.out.println(funcionario.toString());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionário não encontrado");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Corrigido para exibir apenas a mensagem
        }
    }

    //Deletar funcionario pelo nomr
    public void deletarFuncinario(){
        String nome = JOptionPane.showInputDialog("Digite o nome a ser removido");

        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    funcionarios.remove(funcionario);
                    System.out.println("funcionario removido com sucesso!");
                    encontrado = true;
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionário não encontrado!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Corrigido para exibir apenas a mensagem
        }
    }

    //calculo de media salarial
    public void  calculoMediaSalario()  {
        double mediaSalarios = 0;
        if (funcionarios.size()==0) {
            System.out.println("Lista Vazia!");
        }else{
            for (Funcionario funcionario : funcionarios) {
                mediaSalarios += funcionario.getSalario();
            }
            mediaSalarios/=funcionarios.size();
            System.out.println("A média de salarios é "+mediaSalarios);
        }
       
    } 
 }


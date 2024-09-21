package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoController agenda = new ContatoController(5);
        int operacao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n-----Agenda de Contatos---------");
            System.out.println(" 1 -  adicionar contato");
            System.out.println(" 2 -  Listar contatos");
            System.out.println(" 3 -  Buscar contato pelo nome");
            System.out.println(" 4 -  Deletar contato");
            System.out.println(" 5 - Sair");
            try {
                operacao = sc.nextInt();
                switch (operacao) {
                    case 1:
                        try {
                            System.out.println("Nome: ");
                            String nome = sc.nextLine();
                            System.out.println("Endereco: ");
                            String endereco = sc.nextLine();
                            System.out.println("Email: ");
                            String email = sc.nextLine();
                            System.out.println("Telefone: ");
                            String telefone = sc.nextLine();
                            Contato contato = new Contato(nome, email, endereco, telefone);
                            agenda.addContato(contato);
                        } catch (Exception e) {
                            System.err.println(e);
                        }

                        break;
                    case 2:
                        agenda.listarContato();
                        break;
                    case 3:
                        try {
                            System.out.println("Digite o nome a ser buscado:");
                            String nomeBusca = sc.next();
                            System.out.println(agenda.buscarContato(nomeBusca).toString());

                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Digite o nome a ser buscado:");
                            String nomeDeletar = sc.next();
                            agenda.removerContato(nomeDeletar);
                            System.out.println("Contato deletado com sucesso! ");
                            break;
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Digite um n° Valido");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Digite um valor valido");
                operacao = 2;
                break;
            }
        } while (operacao != 5);
        sc.close();
    }
}
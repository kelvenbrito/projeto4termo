package com.example;

public class ContatoController {
    // Atributos
    private Contato[] contatos;
    private int contadorDeContatos;

    // Contrutor
    public ContatoController(int maxContato) {
        maxContato = 3;
        contatos = new Contato[maxContato];
        contadorDeContatos = 0;
    }

    // métodos - adicionar conatato
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contadorDeContatos >= contatos.length) {
            throw new AgendaCheiaException("Agenda cheia");
        }
        try {
            contatos[contadorDeContatos] = contato;
            contadorDeContatos++;
            System.out.println("Contato adicionado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // metodos - Listar todos
    public void listarContato() {
        if (contadorDeContatos == 0) {
            System.out.println("Agenda vazia!");
        } else {
            for (int i = 0; i < contadorDeContatos; i++) {
                System.out.println("\nContato: " + contatos[i].toString());
            }
        }

    }

    // metodos -buscar contatos pelo nome
    public Contato buscarContato(String nome) throws ContatoNaoEncontrado {
        for (int i = 0; i < contadorDeContatos; i++) {

            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }

        }
        throw new ContatoNaoEncontrado("Contato não Encontado");
    }

    // Remover contato

    public void removerContato(String nome) throws ContatoNaoEncontrado {
        boolean encontrado = false;

        for (int i = 0; i < contadorDeContatos; i++) {

            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
                contatos[i]=contatos[contadorDeContatos-1];
                contatos[contadorDeContatos-1]=null;
                contadorDeContatos--;
            }

        }
        if (!encontrado) {
            throw new ContatoNaoEncontrado("Contato não Encontrado");
        }
    }

}

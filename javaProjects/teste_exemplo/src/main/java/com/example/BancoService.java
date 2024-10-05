package com.example;

public class BancoService {
    // Atributo
    private ContaBancariaRepository repository;

    // Construtor
    public BancoService(ContaBancariaRepository repository) {
        this.repository = repository;
    }

    // Depositar
    public void depositar(String numeroConta, double valor) {
        ContaBancaria conta = repository.encontrarPorNumero(numeroConta);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada.");
        }
        conta.depositar(valor);
        repository.atualizar(conta);
    }

    // Sacar
    public void sacar(String numeroConta, double valor) {
        ContaBancaria conta = repository.encontrarPorNumero(numeroConta);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada.");
        }
        conta.sacar(valor);
        repository.atualizar(conta);
    }

    // Consultar saldo
    public double consultarSaldo(String numeroConta) {
        ContaBancaria conta = repository.encontrarPorNumero(numeroConta);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada.");
        }
        return conta.getSaldo();
    }

}

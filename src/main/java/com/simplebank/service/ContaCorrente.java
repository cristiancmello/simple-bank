package com.simplebank.service;

public class ContaCorrente {
    private double saldo;

    public ContaCorrente(double saldoInicial) {
        saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void transfere(ContaCorrente contaCorrente, double valorATransferir) {
        saque(valorATransferir);
        contaCorrente.deposita(valorATransferir);
    }

    private void deposita(double valorADepositar) {
        saldo += valorADepositar;
    }

    private void saque(double valorASacar) {
        saldo -= valorASacar;
    }
}

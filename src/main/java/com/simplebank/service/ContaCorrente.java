package com.simplebank.service;

import java.math.BigDecimal;

public class ContaCorrente {
    private BigDecimal saldo;

    public ContaCorrente(BigDecimal saldoInicial) {
        saldo = saldoInicial;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void transfere(ContaCorrente contaCorrente, BigDecimal valorATransferir) {
        saque(valorATransferir);
        contaCorrente.deposita(valorATransferir);
    }

    private void deposita(BigDecimal valorADepositar) {
        saldo = saldo.add(valorADepositar);
    }

    private void saque(BigDecimal valorASacar) {
        saldo = saldo.subtract(valorASacar);
    }
}

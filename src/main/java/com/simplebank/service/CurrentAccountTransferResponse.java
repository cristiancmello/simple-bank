package com.simplebank.service;

import java.math.BigDecimal;

public class CurrentAccountTransferResponse {
    private BigDecimal saldoOrigem;

    private BigDecimal saldoDestino;

    public CurrentAccountTransferResponse() {}

    public BigDecimal getSaldoContaOrigem() {
        return saldoOrigem;
    }

    public BigDecimal getSaldoContaDestino() {
        return saldoDestino;
    }
}

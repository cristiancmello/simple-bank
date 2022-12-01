package com.simplebank.service;

import java.math.BigDecimal;

public class CurrentAccountTransferResponse {
    private BigDecimal saldoOrigem;

    private BigDecimal saldoDestino;

    public CurrentAccountTransferResponse() {
        this.saldoOrigem = BigDecimal.valueOf(820.0);
        this.saldoDestino = BigDecimal.valueOf(680.0);
    }

    public BigDecimal getSaldoContaOrigem() {
        return saldoOrigem;
    }

    public BigDecimal getSaldoContaDestino() {
        return saldoDestino;
    }
}

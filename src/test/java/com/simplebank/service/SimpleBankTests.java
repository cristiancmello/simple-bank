package com.simplebank.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class SimpleBankTests {
    @Test
    void dadaContaCorrenteAComSaldo_eOutraContaCorrenteBSaldo_quandoAtransferirValorB_entaoContasSaldosComputados() {
        var contaCorrenteA = new ContaCorrente(BigDecimal.valueOf(0.3));
        var contaCorrenteB = new ContaCorrente(BigDecimal.valueOf(0));

        contaCorrenteA.transfere(contaCorrenteB, BigDecimal.valueOf(0.1));

        assertThat(contaCorrenteA.getSaldo()).isEqualTo(BigDecimal.valueOf(0.2));
        assertThat(contaCorrenteB.getSaldo()).isEqualTo(BigDecimal.valueOf(0.1));
    }
}

package com.simplebank.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SimpleBankTests {
    @Test
    void dadaContaCorrenteAComSaldo_eOutraContaCorrenteBSaldo_quandoAtransferirValorB_entaoContasSaldosComputados() {
        var contaCorrenteA = new ContaCorrente(1200.0);
        var contaCorrenteB = new ContaCorrente(300.0);

        contaCorrenteA.transfere(contaCorrenteB, 380.0);

        assertThat(contaCorrenteA.getSaldo()).isEqualTo(820.0);
        assertThat(contaCorrenteB.getSaldo()).isEqualTo(680.0);
    }
}

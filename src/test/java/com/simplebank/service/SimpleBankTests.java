package com.simplebank.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class SimpleBankTests {
    @Autowired
    RestTemplate contaCorrenteClient;

    @Test
    void dadaContaCorrenteAComSaldo_eOutraContaCorrenteBSaldo_quandoAtransferirValorB_entaoContasSaldosComputados() {
        var contaCorrenteRequest = new HttpEntity<>(List.of(), new HttpHeaders());
        var response = contaCorrenteClient.postForEntity("/accounts/transfer", contaCorrenteRequest, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // Tempos um problema: current service ainda nao fornece API. E agora? SOLUCAO: Mockar com Mockito


//        assertThat(contaCorrenteClient.getSaldo()).isEqualTo(BigDecimal.valueOf(820.0));

//        var contaCorrenteA = new ContaCorrente(BigDecimal.valueOf(1200.0));
//        var contaCorrenteB = new ContaCorrente(BigDecimal.valueOf(300.0));
//
//        contaCorrenteA.transfere(contaCorrenteB, BigDecimal.valueOf(380.0));
//
//        assertThat(contaCorrenteA.getSaldo()).isEqualTo(BigDecimal.valueOf(820.0));
//        assertThat(contaCorrenteB.getSaldo()).isEqualTo(BigDecimal.valueOf(680.0));
    }
}

package com.simplebank.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimpleBankTests {
    @Mock
    RestTemplate contaCorrenteClient;

    @Test
    void dadaContaCorrenteAComSaldo_eOutraContaCorrenteBSaldo_quandoAtransferirValorB_entaoContasSaldosComputados() {
        var contaCorrenteTransferRequest = new HttpEntity<>(List.of(Map.of("valor", BigDecimal.valueOf(380.0))), new HttpHeaders());
        var currentAccountTransferResponse = new CurrentAccountTransferResponse();

        when(contaCorrenteClient
            .postForEntity("/accounts/transfer", contaCorrenteTransferRequest, CurrentAccountTransferResponse.class)
        ).thenReturn(new ResponseEntity<>(currentAccountTransferResponse, HttpStatus.OK));

        var response = contaCorrenteClient
            .postForEntity(
                "/accounts/transfer",
                contaCorrenteTransferRequest,
                CurrentAccountTransferResponse.class
            );

        var contaCorrenteTransferResponse = response.getBody();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(contaCorrenteTransferResponse.getSaldoContaOrigem()).isEqualTo(BigDecimal.valueOf(820.0));
        assertThat(contaCorrenteTransferResponse.getSaldoContaDestino()).isEqualTo(BigDecimal.valueOf(680.0));

        // Certo, o teste passou... Mas há algo estranho. O próprio teste está fazendo a requisição.
        // A implementação é quem deve fazer essa tarefa.

//        var contaCorrenteA = new ContaCorrente(BigDecimal.valueOf(1200.0));
//        var contaCorrenteB = new ContaCorrente(BigDecimal.valueOf(300.0));
//
//        contaCorrenteA.transfere(contaCorrenteB, BigDecimal.valueOf(380.0));
//
//        assertThat(contaCorrenteA.getSaldo()).isEqualTo(BigDecimal.valueOf(820.0));
//        assertThat(contaCorrenteB.getSaldo()).isEqualTo(BigDecimal.valueOf(680.0));
    }
}

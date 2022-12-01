package com.simplebank.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
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

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SimpleBankTests {
    @Mock
    RestTemplate contaCorrenteClient;

    @InjectMocks
    CurrentAccountServiceClient currentAccountServiceClient;

    @Test
    void dadaContaCorrenteAComSaldo_eOutraContaCorrenteBSaldo_quandoAtransferirValorB_entaoContasSaldosComputados() {
        var contaOrigem = new ContaCorrente();
        var contaDestino = new ContaCorrente();

        var contaCorrenteTransferRequest = new HttpEntity<>(List.of(
            Map.of("valor", BigDecimal.valueOf(380.0)),
            Map.of("id_conta_origem", contaOrigem.getId()),
            Map.of("id_conta_destino", contaDestino.getId())
        ), new HttpHeaders());

        var currentAccountTransferResponse = new CurrentAccountTransferResponse();

        when(contaCorrenteClient
            .postForEntity("/accounts/transfer", contaCorrenteTransferRequest, CurrentAccountTransferResponse.class)
        ).thenReturn(new ResponseEntity<>(currentAccountTransferResponse, HttpStatus.OK));

        var contaCorrenteTransferResponse = currentAccountServiceClient
            .transfer(contaOrigem, contaDestino, BigDecimal.valueOf(380.0));

        // Melhorou! Agora podemos lidar com a transferencia implementada fora do teste

        assertThat(contaCorrenteTransferResponse.getSaldoContaOrigem()).isEqualTo(BigDecimal.valueOf(820.0));
        assertThat(contaCorrenteTransferResponse.getSaldoContaDestino()).isEqualTo(BigDecimal.valueOf(680.0));
    }
}

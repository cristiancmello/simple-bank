package com.simplebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class CurrentAccountServiceClient {
    @Autowired
    private RestTemplate client;

    public CurrentAccountTransferResponse transfer(ContaCorrente contaOrigem, ContaCorrente contaDestino, BigDecimal valorATransferir) {
        return client
            .postForEntity(
                "/accounts/transfer",
                new HttpEntity<>(List.of(
                    Map.of("valor", valorATransferir),
                    Map.of("id_conta_origem", contaOrigem.getId()),
                    Map.of("id_conta_destino", contaDestino.getId())
                ), new HttpHeaders()),
                CurrentAccountTransferResponse.class
            ).getBody();
    }
}

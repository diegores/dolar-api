package br.com.bb.desafio.host.data.response;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class DolarQuoteResponseTest {

    @Test
    void testDolarQuoteResponseToString() {
        // Configuração do objeto DolarQuoteResponse
        DolarQuoteResponse dolarQuoteResponse = DolarQuoteResponse.builder()
                .cotacaoCompra(3.80)
                .cotacaoVenda(3.85)
                .dataHoraCotacao("2023-12-01T10:30:00.000")
                .timestampRequisicao(LocalDateTime.now())
                .dataCotacao(new Date())
                .build();

        // Verifica se o método toString() gera a string esperada
        assertThat(dolarQuoteResponse.toString()).contains("cotacaoCompra=3.8", "cotacaoVenda=3.85", "dataHoraCotacao='2023-12-01T10:30:00.000'");
    }
}


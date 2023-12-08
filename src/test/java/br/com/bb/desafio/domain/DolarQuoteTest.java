package br.com.bb.desafio.domain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class DolarQuoteTest {

    @Test
    void testDolarQuote() {
        // Criação de instância de DolarQuote para teste
        LocalDateTime timestampRequisicao = LocalDateTime.now();
        Date dataCotacao = new Date();
        String cotacaoCompra = "3.80";
        String cotacaoVenda = "3.85";
        LocalDateTime dataHoraCotacao = LocalDateTime.now();

        DolarQuote dolarQuote = DolarQuote.builder()
                .timestampRequisicao(timestampRequisicao)
                .dataCotacao(dataCotacao)
                .cotacaoCompra(cotacaoCompra)
                .cotacaoVenda(cotacaoVenda)
                .dataHoraCotacao(dataHoraCotacao)
                .build();

        // Verificações usando AssertJ
        assertThat(dolarQuote.getTimestampRequisicao()).isEqualTo(timestampRequisicao);
        assertThat(dolarQuote.getDataCotacao()).isEqualTo(dataCotacao);
        assertThat(dolarQuote.getCotacaoCompra()).isEqualTo(cotacaoCompra);
        assertThat(dolarQuote.getCotacaoVenda()).isEqualTo(cotacaoVenda);
        assertThat(dolarQuote.getDataHoraCotacao()).isEqualTo(dataHoraCotacao);
    }
}



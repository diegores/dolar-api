package br.com.bb.desafio.gateway.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class DolarQuoteEntityTest {

    @Test
    public void testDolarQuoteEntity() {
        // Criação de instância de DolarQuoteEntity para teste
        LocalDateTime timestampRequisicao = LocalDateTime.now();
        Date dataCotacao = new Date();
        double cotacaoCompra = 3.80;
        double cotacaoVenda = 3.85;
        LocalDateTime dataHoraCotacao = LocalDateTime.now();

        DolarQuoteEntity dolarQuoteEntity = DolarQuoteEntity.builder()
                .timestampRequisicao(timestampRequisicao)
                .dataCotacao(dataCotacao)
                .cotacaoCompra(cotacaoCompra)
                .cotacaoVenda(cotacaoVenda)
                .dataHoraCotacao(dataHoraCotacao)
                .build();

        // Verificações usando AssertJ
        assertThat(dolarQuoteEntity.getId()).isNull(); // O ID será gerado automaticamente
        assertThat(dolarQuoteEntity.getTimestampRequisicao()).isEqualTo(timestampRequisicao);
        assertThat(dolarQuoteEntity.getDataCotacao()).isEqualTo(dataCotacao);
        assertThat(dolarQuoteEntity.getCotacaoCompra()).isEqualTo(cotacaoCompra);
        assertThat(dolarQuoteEntity.getCotacaoVenda()).isEqualTo(cotacaoVenda);
        assertThat(dolarQuoteEntity.getDataHoraCotacao()).isEqualTo(dataHoraCotacao);
    }
}
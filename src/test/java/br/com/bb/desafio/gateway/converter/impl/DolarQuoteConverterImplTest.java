package br.com.bb.desafio.gateway.converter.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.entity.DolarQuoteEntity;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class DolarQuoteConverterImplTest {

    private final DolarQuoteConverterImpl converter = new DolarQuoteConverterImpl();

    @Test
    public void testConverterToDomain() {
        // Criação de instância de DolarQuoteEntity para teste
        LocalDateTime timestampRequisicao = LocalDateTime.now();
        LocalDateTime dataHoraCotacao = LocalDateTime.now();
        DolarQuoteEntity entity = DolarQuoteEntity.builder()
                .timestampRequisicao(timestampRequisicao)
                .dataCotacao(new Date())
                .cotacaoCompra(3.80)
                .cotacaoVenda(3.85)
                .dataHoraCotacao(dataHoraCotacao)
                .build();

        // Chama o método de conversão
        DolarQuote result = converter.converterToDomain(entity);

        // Verificações usando AssertJ
        assertThat(result.getTimestampRequisicao()).isEqualTo(timestampRequisicao);
        assertThat(result.getDataCotacao()).isEqualTo(entity.getDataCotacao());
        assertThat(result.getCotacaoCompra()).isEqualTo("3.8"); // Converte para String
        assertThat(result.getCotacaoVenda()).isEqualTo("3.85");  // Converte para String
        assertThat(result.getDataHoraCotacao()).isEqualTo(dataHoraCotacao);
    }

    @Test
    public void testConverterToDomainList() {
        // Criação de uma lista de DolarQuoteEntity para teste
        LocalDateTime timestampRequisicao1 = LocalDateTime.now();
        LocalDateTime timestampRequisicao2 = LocalDateTime.now().minusHours(1);
        LocalDateTime dataHoraCotacao1 = LocalDateTime.now();
        LocalDateTime dataHoraCotacao2 = LocalDateTime.now().minusHours(1);
        DolarQuoteEntity entity1 = DolarQuoteEntity.builder()
                .timestampRequisicao(timestampRequisicao1)
                .dataCotacao(new Date())
                .cotacaoCompra(3.80)
                .cotacaoVenda(3.85)
                .dataHoraCotacao(dataHoraCotacao1)
                .build();
        DolarQuoteEntity entity2 = DolarQuoteEntity.builder()
                .timestampRequisicao(timestampRequisicao2)
                .dataCotacao(new Date())
                .cotacaoCompra(3.75)
                .cotacaoVenda(3.90)
                .dataHoraCotacao(dataHoraCotacao2)
                .build();

        List<DolarQuoteEntity> entityList = Arrays.asList(entity1, entity2);

        // Chama o método de conversão
        List<DolarQuote> resultList = converter.converterToDomainList(entityList);

        // Verificações usando AssertJ
        assertThat(resultList).hasSize(2);

        assertThat(resultList.get(0).getTimestampRequisicao()).isEqualTo(timestampRequisicao1);
        assertThat(resultList.get(0).getDataCotacao()).isEqualTo(entity1.getDataCotacao());
        assertThat(resultList.get(0).getCotacaoCompra()).isEqualTo("3.8");
        assertThat(resultList.get(0).getCotacaoVenda()).isEqualTo("3.85");
        assertThat(resultList.get(0).getDataHoraCotacao()).isEqualTo(dataHoraCotacao1);

        assertThat(resultList.get(1).getTimestampRequisicao()).isEqualTo(timestampRequisicao2);
        assertThat(resultList.get(1).getDataCotacao()).isEqualTo(entity2.getDataCotacao());
        assertThat(resultList.get(1).getCotacaoCompra()).isEqualTo("3.75");
        assertThat(resultList.get(1).getCotacaoVenda()).isEqualTo("3.9");
        assertThat(resultList.get(1).getDataHoraCotacao()).isEqualTo(dataHoraCotacao2);
    }
}
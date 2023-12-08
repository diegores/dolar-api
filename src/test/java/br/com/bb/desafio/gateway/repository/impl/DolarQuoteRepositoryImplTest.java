package br.com.bb.desafio.gateway.repository.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.converter.DolarQuoteConverter;
import br.com.bb.desafio.gateway.entity.DolarQuoteEntity;
import br.com.bb.desafio.gateway.entity.converter.DolarQuoteEntityConverter;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@QuarkusTest
public class DolarQuoteRepositoryImplTest {

 /*   @InjectMock
    DolarQuoteEntityConverter dolarQuoteEntityConverter;

    @InjectMock
    DolarQuoteRepositoryImpl dolarQuoteRepository;

    @InjectMock
    DolarQuoteConverter dolarQuoteConverter;


    @Test
    void testSaveQuote() {
        // Configuração do Mock
        DolarQuote dolarQuote = createDolarQuote();

        // Configuração do Comportamento do Mock
        when(dolarQuoteEntityConverter.converterToEntity(any(DolarQuote.class))).thenReturn(createDolarQuoteEntity());

        // Chama o método que você está testando
        dolarQuoteRepository.saveQuote(dolarQuote);

        // Verifica se o método persist foi chamado
        Mockito.verify(dolarQuoteRepository, Mockito.times(1)).persist(any(DolarQuoteEntity.class));

    }

    @Test
    void testFindAllQuote() {
        // Configuração do Mock
        DolarQuoteEntity dolarQuoteEntity = createDolarQuoteEntity();

        // Configuração do Comportamento do Mock
        when(dolarQuoteRepository.listAll()).thenReturn(Collections.singletonList(dolarQuoteEntity));
        when(dolarQuoteConverter.converterToDomainList(any())).thenReturn(Collections.singletonList(createDolarQuote()));

        // Chama o método que você está testando
        List<DolarQuote> result = dolarQuoteRepository.findAllQuote();

        // Verifica se o resultado não está vazio
        assertThat(result).isNotEmpty();
    }

    @Test
    void testFindQuoteByDateQuote() {
        // Configuração do Mock
        DolarQuote dolarQuote = createDolarQuote();
        DolarQuoteEntity dolarQuoteEntity = createDolarQuoteEntity();

        // Configuração do Comportamento do Mock
        PanacheQuery<DolarQuoteEntity> panacheQueryMock = mock(PanacheQuery.class);
        when(dolarQuoteRepository.find(any(String.class), any(Parameters.class)))
                .thenReturn(panacheQueryMock);
        when(panacheQueryMock.firstResult()).thenReturn(dolarQuoteEntity);

        when(dolarQuoteConverter.converterToDomain(any(DolarQuoteEntity.class)))
                .thenReturn(dolarQuote);

        // Chama o método que você está testando
        DolarQuote result = dolarQuoteRepository.findQuoteByDateQuote(dolarQuote);

        // Verifica se o resultado não está nulo
        assertThat(result).isNotNull();

        // Verifica se o resultado é igual ao objeto esperado
        assertThat(result).isEqualTo(dolarQuote);
    }





    private DolarQuote createDolarQuote() {
        return DolarQuote.builder()
                .timestampRequisicao(LocalDateTime.now())
                .dataCotacao(new Date())
                .cotacaoCompra("3.80")
                .cotacaoVenda("3.85")
                .dataHoraCotacao(LocalDateTime.now())
                .build();
    }

    private DolarQuoteEntity createDolarQuoteEntity() {
        return DolarQuoteEntity.builder()
                .id(1L)
                .timestampRequisicao(LocalDateTime.now())
                .dataCotacao(new Date())
                .cotacaoCompra(3.80)
                .cotacaoVenda(3.85)
                .dataHoraCotacao(LocalDateTime.now())
                .build();
    }*/
}
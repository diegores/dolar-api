package br.com.bb.desafio.host.converter.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.host.converter.DolarQuoteResponseConverter;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
@QuarkusTest
public class DolarQuoteResponseConverterImplTest {

    @Inject
    private DolarQuoteResponseConverter converter;

    @Mock
    private DolarQuote dolarQuote;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        converter = new DolarQuoteResponseConverterImpl();
    }

    @Test
    void testConverterToResponse() {
        // Configuração do Mock
        LocalDateTime timestampRequisicao = LocalDateTime.now();
        when(dolarQuote.getDataHoraCotacao()).thenReturn(timestampRequisicao);
        when(dolarQuote.getCotacaoCompra()).thenReturn("3.80");
        when(dolarQuote.getCotacaoVenda()).thenReturn("3.85");
        when(dolarQuote.getDataCotacao()).thenReturn(new Date(2023-01-01));

        // Chama o método que você está testando
        DolarQuoteResponse response = converter.converterToResponse(dolarQuote);

        // Verifica se o resultado não está nulo e corresponde ao esperado
        assertThat(response).isNotNull();
        assertThat(response.getCotacaoCompra()).isEqualTo(Double.valueOf("3.80"));
        assertThat(response.getCotacaoVenda()).isEqualTo(Double.valueOf("3.85"));
        assertThat(response.getDataCotacao()).isEqualTo(new Date(2023-01-01));
    }

    @Test
    void testConverterToDomain() {
        // Configuração do Mock
        DolarQuoteResponse response = new DolarQuoteResponse();
        response.setTimestampRequisicao(LocalDateTime.parse("2023-01-01T12:00:00.000"));
        response.setCotacaoCompra(3.80);
        response.setCotacaoVenda(3.85);
        response.setDataCotacao(new Date(2023-01-01));
    }

    @Test
    void testConverterToDomainList() {
        // Configuração do Mock
        DolarQuoteResponse response1 = new DolarQuoteResponse();
        response1.setTimestampRequisicao(LocalDateTime.parse("2023-01-01T12:00:00.000"));
        response1.setCotacaoCompra(3.80);
        response1.setCotacaoVenda(3.85);
        response1.setDataCotacao(new Date(2023-01-01));

        DolarQuoteResponse response2 = new DolarQuoteResponse();
        response2.setTimestampRequisicao(LocalDateTime.parse("2023-01-01T12:00:00.000"));
        response2.setCotacaoCompra(3.81);
        response2.setCotacaoVenda(3.86);
        response2.setDataCotacao(new Date(2023-01-02));
    }

    @Test
    void testConverterToResponseList() {
        // Configuração do Mock
        DolarQuote domain1 = DolarQuote.builder()
                .timestampRequisicao(LocalDateTime.parse("2023-01-01T12:00:00.000"))
                .cotacaoCompra("3.80")
                .cotacaoVenda("3.85")
                .dataCotacao(new Date(2023-01-01))
                .build();

        DolarQuote domain2 = DolarQuote.builder()
                .timestampRequisicao(LocalDateTime.parse("2023-01-02T12:00:00.000"))
                .cotacaoCompra("3.81")
                .cotacaoVenda("3.86")
                .dataCotacao(new Date(2023-01-01))
                .build();
    }
}
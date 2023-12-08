package br.com.bb.desafio.service.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.repository.DolarQuoteRepository;
import br.com.bb.desafio.host.converter.DolarQuoteResponseConverter;
import br.com.bb.desafio.host.data.request.DolarQuoteRequest;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;
import br.com.bb.desafio.service.impl.DolarQuoteServiceImpl;
import br.com.bb.desafio.usercase.CallApiQuote;
import br.com.bb.desafio.usercase.CheckQuoteMade;
import br.com.bb.desafio.usercase.FindQuoteByDate;
import br.com.bb.desafio.usercase.SaveNewQuote;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@QuarkusTest
public class DolarQuoteServiceImplTest {

    @InjectMocks
    private DolarQuoteServiceImpl dolarQuoteService;

    @Mock
    private CheckQuoteMade checkQuoteMade;

    @Mock
    private CallApiQuote callApiQuote;

    @Mock
    private SaveNewQuote saveNewQuote;

    @Mock
    private DolarQuoteResponseConverter dolarQuoteResponseConverter;

    @Mock
    private FindQuoteByDate findQuoteByDate;

    @Mock
    private DolarQuoteRepository dolarQuoteRepository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Isso garante a inicialização dos mocks

        // Certifique-se de que o DolarQuoteRepository seja injetado corretamente
        dolarQuoteService = new DolarQuoteServiceImpl(
                checkQuoteMade,
                callApiQuote,
                saveNewQuote,
                dolarQuoteResponseConverter,
                findQuoteByDate,
                dolarQuoteRepository
        );
    }

    @Test
    void testGetAllQuote() {
        // Configuração do Mock
        when(dolarQuoteRepository.findAllQuote()).thenReturn(Collections.emptyList());
        when(dolarQuoteResponseConverter.converterToResponseList(any())).thenReturn(Collections.emptyList());

        // Chama o método que você está testando
        List<DolarQuote> result = dolarQuoteService.getAllQuote();

        // Verifica se o resultado está vazio
        assertThat(result).isEmpty();

        // Verifica se os métodos do mock foram chamados
        verify(dolarQuoteRepository, times(1)).findAllQuote();
        verify(dolarQuoteResponseConverter, times(1)).converterToResponseList(any());
    }

    @Test
    void testGetCotacao() {
        // Configuração do Mock
        DolarQuoteRequest request = new DolarQuoteRequest();
        request.setDataCotacao(new Date());

        when(checkQuoteMade.execute(any())).thenReturn(null);

        DolarQuoteResponse dolarCotacao = DolarQuoteResponse.builder().build();
        when(callApiQuote.execute(any())).thenReturn(dolarCotacao);

        DolarQuote domainDolarQuote = new DolarQuote();
        when(dolarQuoteResponseConverter.converterToDomain(any())).thenReturn(domainDolarQuote);

        // Chama o método que você está testando
        DolarQuoteResponse result = dolarQuoteService.getCotacao(request);

        // Verifica se o resultado não está nulo
        assertThat(result).isNotNull();

        // Verifica se os métodos do mock foram chamados
        verify(checkQuoteMade, times(1)).execute(any());
        verify(callApiQuote, times(1)).execute(any());
        verify(dolarQuoteResponseConverter, times(1)).converterToDomain(any());
        verify(saveNewQuote, times(1)).execute(any(), any());
    }
}


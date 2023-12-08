package br.com.bb.desafio.usercase;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.converter.DolarQuoteConverter;
import br.com.bb.desafio.gateway.entity.DolarQuoteEntity;
import br.com.bb.desafio.gateway.entity.converter.DolarQuoteEntityConverter;
import br.com.bb.desafio.gateway.repository.DolarQuoteRepository;
import br.com.bb.desafio.usercase.impl.CheckQuoteMadeImpl;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
public class CheckQuoteMadeImplTest {

  /*  @Mock
    private DolarQuoteRepository dolarQuoteRepository;
    @Mock
    private DolarQuoteConverter converter;

    @Mock
    private DolarQuoteEntityConverter dolarQuoteEntityConverter;

    @InjectMocks
    private CheckQuoteMadeImpl checkQuoteMade;

    @Test
    void testExecute() {
        // Criar instância de DolarQuote e DolarQuoteEntity conforme necessário
        DolarQuote dolarQuoteDomain = new DolarQuote();
        DolarQuoteEntity dolarQuoteEntity = new DolarQuoteEntity();

        // Configurar comportamento dos mocks
        Mockito.when(dolarQuoteRepository.findQuoteByDateQuote(any())).thenReturn(dolarQuoteDomain);
        Mockito.when(dolarQuoteEntityConverter.converterToEntity(any())).thenReturn(dolarQuoteEntity);
        Mockito.when(converter.converterToDomain(any())).thenReturn(dolarQuoteDomain);

        // Chamar o método que está sendo testado
        DolarQuote result = checkQuoteMade.execute(new Date());

        // Verificar se o resultado é o esperado
        assertEquals(dolarQuoteDomain, result);

        // Verificar interações com os mocks conforme necessário
        Mockito.verify(dolarQuoteRepository, Mockito.times(1)).findQuoteByDateQuote(any());
        Mockito.verify(dolarQuoteEntityConverter, Mockito.times(1)).converterToEntity(any());
        Mockito.verify(converter, Mockito.times(1)).converterToDomain(any());
    }*/
}
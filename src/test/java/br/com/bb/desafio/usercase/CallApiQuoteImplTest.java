package br.com.bb.desafio.usercase;

import br.com.bb.desafio.host.data.response.DolarQuoteResponse;
import br.com.bb.desafio.usercase.impl.CallApiQuoteImpl;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CallApiQuoteImplTest {

  /*  @Inject
    private CallApiQuoteImpl callApiQuote;

    @Inject
    private HttpClient httpClient; // Certifique-se de que está sendo injetado corretamente

    @Test
    void testExecute() throws Exception {
        // Configurar o mock HttpClient
        HttpClient mockHttpClient = Mockito.mock(HttpClient.class);
        // Configure o comportamento do mockHttpClient
        callApiQuote = new CallApiQuoteImpl(mockHttpClient);

        // Chamar o método que você está testando
        DolarQuoteResponse result = callApiQuote.execute(new Date(System.currentTimeMillis()));

        // Verificar se o resultado não é nulo
        assertNotNull(result);

        // Adicionar mais verificações conforme necessário
    }*/
}

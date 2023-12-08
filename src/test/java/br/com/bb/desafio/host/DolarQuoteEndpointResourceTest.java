package br.com.bb.desafio.host;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.host.converter.DolarQuoteResponseConverter;
import br.com.bb.desafio.host.data.request.DolarQuoteRequest;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;
import br.com.bb.desafio.service.DolarQuoteService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class DolarQuoteEndpointResourceTest {

    // Mock para o serviço
   // private static final DolarQuoteService mockService = new MockDolarQuoteService();

    @InjectMock
    DolarQuoteService service;

   /* @Test
    void testGetCotacao() {
        // Configuração do Mock para o serviço
        DolarQuoteEndpointResource resource = new DolarQuoteEndpointResource();
        resource.service = mockService;

        // Executa a requisição
        given()
                .when().get("/dolar/2023-12-01")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cotacaoCompra", equalTo(3.80f))
                .body("cotacaoVenda", equalTo(3.85f));
    }

    @Test
    void testGetCotacaoWithInvalidDateFormat() {
        // Executa a requisição com um formato de data inválido
        given()
                .when().get("/dolar/invalidDate")
                .then()
                .statusCode(400)
                .body(equalTo("Formato de data inválido. Use o formato yyyy-MM-dd."));
    }

    @Test
    void testGetAllCotacoes() {
        // Configuração do Mock para o serviço
        DolarQuoteEndpointResource resource = new DolarQuoteEndpointResource();
        resource.service = mockService;
        resource.converter = new MockDolarQuoteResponseConverter();

        // Executa a requisição
        given()
                .when().get("/dolar/all")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", equalTo(1))
                .body("[0].cotacaoCompra", equalTo(3.80f))
                .body("[0].cotacaoVenda", equalTo(3.85f));
    }

    // Implementação de serviço e converter mock para os testes
    private static class MockDolarQuoteService implements DolarQuoteService {
        @Override
        public DolarQuoteResponse getCotacao(DolarQuoteRequest request) {
            return DolarQuoteResponse.builder()
                    .cotacaoCompra(3.80)
                    .cotacaoVenda(3.85)
                    .build();
        }

        @Override
        public List<DolarQuoteResponse> getAllQuote() {
            return Collections.singletonList(DolarQuoteResponse.builder()
                    .cotacaoCompra(3.80)
                    .cotacaoVenda(3.85)
                    .build());
        }
    }

    private static class MockDolarQuoteResponseConverter implements DolarQuoteResponseConverter {
        @Override
        public DolarQuoteResponse converterToResponse(DolarQuote dolarQuote) {
            return DolarQuoteResponse.builder()
                    .cotacaoCompra(Double.valueOf(dolarQuote.getCotacaoCompra()))
                    .cotacaoVenda(Double.valueOf(dolarQuote.getCotacaoVenda()))
                    .build();
        }

        @Override
        public List<DolarQuoteResponse> converterToResponseList(List<DolarQuote> dolarQuotes) {
            return Collections.singletonList(converterToResponse(dolarQuotes.get(0)));
        }
    }*/
}


package br.com.bb.desafio.host.data.request;

import br.com.bb.desafio.host.data.request.DolarQuoteRequest;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class DolarQuoteRequestTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    void testValidDolarQuoteRequest() {
        // Configuração do objeto válido
        DolarQuoteRequest request = DolarQuoteRequest.builder()
                .dataCotacao(new Date())
                .build();

        // Validação
        Set<ConstraintViolation<DolarQuoteRequest>> violations = validator.validate(request);

        // Verifica se não há violações de validação
        assertThat(violations).isEmpty();
    }

    @Test
    void testInvalidDolarQuoteRequest() {
        // Configuração do objeto inválido (dataCotacao nula)
        DolarQuoteRequest request = DolarQuoteRequest.builder()
                .build();

        // Validação
        Set<ConstraintViolation<DolarQuoteRequest>> violations = validator.validate(request);

        // Verifica se há uma violação de validação para o campo dataCotacao
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getPropertyPath().toString()).isEqualTo("dataCotacao");
    }
}

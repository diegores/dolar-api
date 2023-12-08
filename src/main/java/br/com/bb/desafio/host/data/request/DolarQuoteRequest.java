package br.com.bb.desafio.host.data.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DolarQuoteRequest implements Serializable {

    private static final long serialVerionUID = 1L;

    @NotNull(message = "O campo dataCotação não poderá ser nulo")
    private Date dataCotacao;
}

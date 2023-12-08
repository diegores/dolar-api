package br.com.bb.desafio.host.converter;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;

import java.util.List;

public interface DolarQuoteResponseConverter {
    DolarQuoteResponse converterToResponse(DolarQuote dolarQuote);
    DolarQuote converterToDomain(DolarQuoteResponse dolarQuoteResponse);

    List<DolarQuote> converterToDomainList(List<DolarQuoteResponse> responses);
    List<DolarQuoteResponse> converterToResponseList(List<DolarQuote> dolarQuotes);
}

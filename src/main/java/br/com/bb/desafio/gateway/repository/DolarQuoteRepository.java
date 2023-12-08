package br.com.bb.desafio.gateway.repository;

import br.com.bb.desafio.domain.DolarQuote;

import java.util.List;

public interface DolarQuoteRepository {
    void saveQuote(DolarQuote dolarQuote);

    List<DolarQuote> findAllQuote();

    DolarQuote findQuoteByDateQuote(DolarQuote dolarQuote);

}

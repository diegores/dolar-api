package br.com.bb.desafio.usercase.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.repository.DolarQuoteRepository;
import br.com.bb.desafio.usercase.FindQuoteByDate;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class FindQuoteByDateImpl implements FindQuoteByDate {

    private final DolarQuoteRepository dolarQuoteRepository;

    @Override
    public DolarQuote execute(DolarQuote dolarQuote) {
        return dolarQuoteRepository.findQuoteByDateQuote(
                dolarQuote);
    }
}

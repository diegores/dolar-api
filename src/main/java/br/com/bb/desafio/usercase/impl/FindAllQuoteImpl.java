package br.com.bb.desafio.usercase.impl;

import br.com.bb.desafio.gateway.repository.DolarQuoteRepository;
import br.com.bb.desafio.usercase.FindAllQuote;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class FindAllQuoteImpl implements FindAllQuote {

    private final DolarQuoteRepository dolarQuoteRepository;

    @Override
    public FindAllQuote execute() {
        return (FindAllQuote) dolarQuoteRepository.findAllQuote();
    }
}

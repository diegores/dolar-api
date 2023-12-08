package br.com.bb.desafio.usercase.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.repository.DolarQuoteRepository;
import br.com.bb.desafio.gateway.converter.DolarQuoteConverter;
import br.com.bb.desafio.gateway.entity.converter.DolarQuoteEntityConverter;
import br.com.bb.desafio.usercase.CheckQuoteMade;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@ApplicationScoped
@RequiredArgsConstructor
public class CheckQuoteMadeImpl implements CheckQuoteMade {

    private final DolarQuoteRepository dolarQuoteRepository;
    private final DolarQuoteConverter converter;
    private final DolarQuoteEntityConverter dolarQuoteEntityConverter;

    @Override
    public DolarQuote execute(Date dataCotacao) {
        DolarQuote dolarQuote = new DolarQuote();
        dolarQuote.setDataCotacao(dataCotacao);
        return converter.converterToDomain(
                dolarQuoteEntityConverter.converterToEntity(
                        dolarQuoteRepository.findQuoteByDateQuote(dolarQuote)));
    }
}

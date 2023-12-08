package br.com.bb.desafio.usercase.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.repository.DolarQuoteRepository;
import br.com.bb.desafio.usercase.SaveNewQuote;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@ApplicationScoped
@RequiredArgsConstructor
public class SaveNewQuoteImpl implements SaveNewQuote {

    private final DolarQuoteRepository gateway;

    @Override
    public void execute(DolarQuote dolarQuote, Date dataCotacao) {
        dolarQuote.setDataCotacao(dataCotacao);
        dolarQuote.setTimestampRequisicao(LocalDateTime.now());
        gateway.saveQuote(dolarQuote);
    }
}

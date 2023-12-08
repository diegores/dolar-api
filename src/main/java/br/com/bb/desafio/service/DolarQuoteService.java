package br.com.bb.desafio.service;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.host.data.request.DolarQuoteRequest;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;

import java.util.List;

public interface DolarQuoteService {
    List<DolarQuote> getAllQuote();

    DolarQuoteResponse getCotacao(DolarQuoteRequest request);
}

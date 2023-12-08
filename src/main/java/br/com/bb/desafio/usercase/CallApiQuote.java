package br.com.bb.desafio.usercase;

import br.com.bb.desafio.host.data.response.DolarQuoteResponse;

import java.util.Date;

public interface CallApiQuote {
    DolarQuoteResponse execute(Date dataCotacao);
}

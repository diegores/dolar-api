package br.com.bb.desafio.usercase;

import br.com.bb.desafio.domain.DolarQuote;

import java.util.Date;

public interface CheckQuoteMade {

    DolarQuote execute(Date dataCotacao);
}

package br.com.bb.desafio.gateway.entity.converter;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.entity.DolarQuoteEntity;

public interface DolarQuoteEntityConverter {
    DolarQuoteEntity converterToEntity(DolarQuote dolarQuote);
}

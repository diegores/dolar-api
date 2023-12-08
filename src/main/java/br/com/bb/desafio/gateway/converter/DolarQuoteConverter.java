package br.com.bb.desafio.gateway.converter;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.entity.DolarQuoteEntity;

import java.util.List;

public interface DolarQuoteConverter {
    DolarQuote converterToDomain(DolarQuoteEntity entity);
    List<DolarQuote> converterToDomainList(List<DolarQuoteEntity> entities);
}

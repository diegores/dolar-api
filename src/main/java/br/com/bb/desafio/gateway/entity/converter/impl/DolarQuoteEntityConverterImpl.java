package br.com.bb.desafio.gateway.entity.converter.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.entity.DolarQuoteEntity;
import br.com.bb.desafio.gateway.entity.converter.DolarQuoteEntityConverter;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;

@ApplicationScoped
@RequiredArgsConstructor
public class DolarQuoteEntityConverterImpl implements DolarQuoteEntityConverter {
    @Override
    public DolarQuoteEntity converterToEntity(DolarQuote dolarQuote) {
        if(isNull(dolarQuote)){
            return null;
        }
        return DolarQuoteEntity.builder()
                .dataCotacao(dolarQuote.getDataCotacao())
                .cotacaoCompra(Double.valueOf(dolarQuote.getCotacaoCompra()))
                .cotacaoVenda(Double.valueOf(dolarQuote.getCotacaoVenda()))
                .dataHoraCotacao(dolarQuote.getDataHoraCotacao())
                .timestampRequisicao(dolarQuote.getTimestampRequisicao())
                .build();
    }
}

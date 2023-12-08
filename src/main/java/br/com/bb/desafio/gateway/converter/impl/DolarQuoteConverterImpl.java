package br.com.bb.desafio.gateway.converter.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.converter.DolarQuoteConverter;
import br.com.bb.desafio.gateway.entity.DolarQuoteEntity;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static org.hibernate.internal.util.StringHelper.isBlank;

@ApplicationScoped
@RequiredArgsConstructor
public class DolarQuoteConverterImpl implements DolarQuoteConverter {


    @Override
    public DolarQuote converterToDomain(DolarQuoteEntity entity) {
        if(isNull(entity)) {
            return null;
        }
        return DolarQuote.builder()
                .timestampRequisicao(entity.getTimestampRequisicao())
                .dataCotacao(entity.getDataCotacao())
                .cotacaoCompra(getString(String.valueOf(entity.getCotacaoCompra())))
                .cotacaoVenda(getString(String.valueOf(entity.getCotacaoVenda())))
                .dataHoraCotacao(entity.getDataHoraCotacao())
                .build();
    }

    @Override
    public List<DolarQuote> converterToDomainList(List<DolarQuoteEntity> entities) {
        return entities.stream()
                .map(this::converterToDomain)
                .collect(Collectors.toList());
    }

    private String getString(String str){
        return isBlank(str) ? null: str.trim();
    }
}

package br.com.bb.desafio.host.converter.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.host.converter.DolarQuoteResponseConverter;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@ApplicationScoped
@RequiredArgsConstructor
public class DolarQuoteResponseConverterImpl implements DolarQuoteResponseConverter {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    private static final DateTimeFormatter saveFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    @Override
    public DolarQuoteResponse converterToResponse(DolarQuote dolarQuote) {
        if(isNull(dolarQuote)) {
            return null;
        }
        return DolarQuoteResponse.builder()
                .dataHoraCotacao(String.valueOf(dolarQuote.getDataHoraCotacao()))
                .cotacaoCompra(Double.valueOf(dolarQuote.getCotacaoCompra()))
                .cotacaoVenda(Double.valueOf(dolarQuote.getCotacaoVenda()))
                .dataCotacao(dolarQuote.getDataCotacao())
                .timestampRequisicao(dolarQuote.getTimestampRequisicao())
                .build();
    }

    @Override
    public DolarQuote converterToDomain(DolarQuoteResponse dolarQuoteResponse) {
        if(isNull(dolarQuoteResponse)) {
            return null;
        }
        return DolarQuote.builder()
                .cotacaoCompra(String.valueOf(dolarQuoteResponse.getCotacaoCompra()))
                .cotacaoVenda(String.valueOf(dolarQuoteResponse.getCotacaoVenda()))
                .dataHoraCotacao(parseToLocalDateTime(dolarQuoteResponse.getDataHoraCotacao()))
                .dataCotacao(dolarQuoteResponse.getDataCotacao())
                .timestampRequisicao(dolarQuoteResponse.getTimestampRequisicao())
                .build();
    }

    @Override
    public List<DolarQuote> converterToDomainList(List<DolarQuoteResponse> responseList) {
        return responseList.stream()
                .map(this::converterToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<DolarQuoteResponse> converterToResponseList(List<DolarQuote> dolarQuotes) {
        return dolarQuotes.stream()
                .map(this::converterToResponse)
                .collect(Collectors.toList());
    }

    public LocalDateTime parseToLocalDateTime(String dataHoraString) {
        try {
            return LocalDateTime.parse(dataHoraString, formatter);
        } catch (DateTimeParseException e) {
            return LocalDateTime.parse(dataHoraString, saveFormatter);
        }
    }
}

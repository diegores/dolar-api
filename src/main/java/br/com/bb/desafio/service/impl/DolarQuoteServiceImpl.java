package br.com.bb.desafio.service.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.repository.DolarQuoteRepository;
import br.com.bb.desafio.host.converter.DolarQuoteResponseConverter;
import br.com.bb.desafio.host.data.request.DolarQuoteRequest;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;
import br.com.bb.desafio.service.DolarQuoteService;
import br.com.bb.desafio.usercase.CallApiQuote;
import br.com.bb.desafio.usercase.CheckQuoteMade;
import br.com.bb.desafio.usercase.FindQuoteByDate;
import br.com.bb.desafio.usercase.SaveNewQuote;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Log
@ApplicationScoped
@RequiredArgsConstructor
public class DolarQuoteServiceImpl implements DolarQuoteService {

    private final CheckQuoteMade check;
    private final CallApiQuote callApiQuote;
    private final SaveNewQuote saveNewQuote;
    private final DolarQuoteResponseConverter dolarQuoteResponseConverter;
    private final FindQuoteByDate findQuoteByDate;
    private final DolarQuoteRepository dolarQuoteRepository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    private static final DateTimeFormatter saveFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    @Override
    public List<DolarQuote> getAllQuote() {
        List<DolarQuoteResponse> responseList = dolarQuoteResponseConverter.converterToResponseList(
                dolarQuoteRepository.findAllQuote());
        if (responseList.isEmpty()) {
            return List.of();
        }
        return responseList.stream()
                .map(dolarQuoteResponseConverter::converterToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public DolarQuoteResponse getCotacao(DolarQuoteRequest request) {
        DolarQuote dolar = check.execute(request.getDataCotacao());
        if (isNull(dolar)) {
            DolarQuoteResponse dolarCotacao = callApiQuote.execute(request.getDataCotacao());
            DolarQuote domainDolarQuote = dolarQuoteResponseConverter.converterToDomain(dolarCotacao);
            saveNewQuote.execute(domainDolarQuote, request.getDataCotacao());
            return dolarCotacao;
        }
        return dolarQuoteResponseConverter.converterToResponse(
                dolar);
    }

    private LocalDateTime parseToLocalDateTime(String dataHoraString) {
        try {
            return LocalDateTime.parse(dataHoraString, formatter);
        } catch (DateTimeParseException e) {
            return LocalDateTime.parse(dataHoraString, saveFormatter);
        }
    }
}
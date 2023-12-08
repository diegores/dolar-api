package br.com.bb.desafio.gateway.repository.impl;

import br.com.bb.desafio.domain.DolarQuote;
import br.com.bb.desafio.gateway.repository.DolarQuoteRepository;
import br.com.bb.desafio.gateway.converter.DolarQuoteConverter;
import br.com.bb.desafio.gateway.entity.DolarQuoteEntity;
import br.com.bb.desafio.gateway.entity.converter.DolarQuoteEntityConverter;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.List;

@Log
@ApplicationScoped
@RequiredArgsConstructor
public class DolarQuoteRepositoryImpl implements DolarQuoteRepository, PanacheRepository<DolarQuoteEntity> {

    private final DolarQuoteConverter dolarQuoteConverter;
    private final DolarQuoteEntityConverter dolarQuoteEntityConverter;

    @Transactional
    @Override
    public void saveQuote(DolarQuote dolarQuote) {
        persist(dolarQuoteEntityConverter.converterToEntity(dolarQuote));
    }

    @Transactional
    @Override
    public List<DolarQuote> findAllQuote() {
        try {
            List<DolarQuoteEntity> entityList = listAll();
            List<DolarQuote> domainList = dolarQuoteConverter.converterToDomainList(entityList);
            return domainList;
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving and converting data", e);
        }
    }


    @Transactional
    @Override
    public DolarQuote findQuoteByDateQuote(DolarQuote dolarQuote) {
        return dolarQuoteConverter.converterToDomain(
                find("dataCotacao = :dataCotacao", Parameters.with("dataCotacao", dolarQuote.getDataCotacao()))
                        .firstResult());
    }
}
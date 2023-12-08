package br.com.bb.desafio.usercase.impl;

import br.com.bb.desafio.exception.DolarQuoteErrorWhenCallApiException;
import br.com.bb.desafio.exception.DolarQuoteNotFoundException;
import br.com.bb.desafio.host.data.response.QuoteResponse;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;
import br.com.bb.desafio.usercase.CallApiQuote;
import br.com.bb.desafio.utils.DolarQuoteUtils;
import br.com.bb.desafio.utils.LocalDateTimeTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

@ApplicationScoped
public class CallApiQuoteImpl implements CallApiQuote {

    private static final Logger LOG = Logger.getLogger(CallApiQuoteImpl.class.getName());

    @Inject
    @ConfigProperty(name = "api.url")
    String apiUrl;


    @Override
    public DolarQuoteResponse execute(Date dataCotacao) {
        HttpClient httpClient = HttpClient.newHttpClient();

        String dataformatada = DolarQuoteUtils.convertDate(String.valueOf(dataCotacao));

        String apiUrlWithData = String.format("%s?@dataCotacao='%s'&$format=json", apiUrl, dataformatada);
        // Construir a requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrlWithData))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            LOG.info("Response Body: " + response.body());

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                    .create();
            QuoteResponse quoteResponse = gson.fromJson(response.body(), QuoteResponse.class);

            if(quoteResponse.value.isEmpty()){
                throw new DolarQuoteNotFoundException("Quote Not Found");
            }

            LOG.info("DolarCotacaoResponse: " + quoteResponse.value.get(0).toString());
            return quoteResponse.value.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DolarQuoteErrorWhenCallApiException();
        }
    }
}


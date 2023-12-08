package br.com.bb.desafio.host;

import br.com.bb.desafio.host.converter.DolarQuoteResponseConverter;
import br.com.bb.desafio.host.data.request.DolarQuoteRequest;
import br.com.bb.desafio.host.data.response.DolarQuoteResponse;
import br.com.bb.desafio.service.DolarQuoteService;
import br.com.bb.desafio.utils.DolarQuoteUtils;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Date;
import java.time.format.DateTimeParseException;
import java.util.List;

@Path("/cotacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DolarQuoteEndpointResource {

    @Inject
    private DolarQuoteService service;

    @Inject
    private DolarQuoteResponseConverter converter;


    @GET
    @Path("/{dataCotacao}")
    @Produces(MediaType.APPLICATION_JSON)
    @Valid
    public Response getCotacao(@PathParam("dataCotacao") String dataCotacao) {
        try {
            DolarQuoteRequest request = new DolarQuoteRequest();
            request.setDataCotacao(Date.valueOf(DolarQuoteUtils.convertToLocaldate(dataCotacao, "yyyy-MM-dd")));
            return Response.ok(service.getCotacao(request)).build();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Formato de data inválido. Use o formato yyyy-MM-dd.").build();
        }
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCotacoes() {
        try {
            List<DolarQuoteResponse> dolarQuoteResponseList = converter.converterToResponseList(
                    service.getAllQuote());
            return Response.ok(dolarQuoteResponseList).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Não há dados na base.").build();
        }
    }
}
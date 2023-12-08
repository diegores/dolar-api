package br.com.bb.desafio.host.data.response;

import com.google.gson.annotations.SerializedName;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
public class DolarQuoteResponse implements Serializable {

    @SerializedName("cotacaoCompra")
    public Double cotacaoCompra;

    @SerializedName("cotacaoVenda")
    public Double cotacaoVenda;

    @SerializedName("dataHoraCotacao")
    public String dataHoraCotacao;

    public LocalDateTime timestampRequisicao;
    public Date dataCotacao;


    public String toString() {
        return "DolarCotacaoResponse{" +
                "cotacaoCompra=" + cotacaoCompra +
                ", cotacaoVenda=" + cotacaoVenda +
                ", dataHoraCotacao='" + dataHoraCotacao + '\'' +
                '}';
    }
}

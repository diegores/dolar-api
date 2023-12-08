package br.com.bb.desafio.domain;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DolarQuote implements Serializable {

    public LocalDateTime timestampRequisicao;
    public Date dataCotacao;
    public String cotacaoCompra;
    public String cotacaoVenda;
    public LocalDateTime dataHoraCotacao;
}

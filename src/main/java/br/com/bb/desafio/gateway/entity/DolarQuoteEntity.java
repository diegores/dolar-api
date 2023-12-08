package br.com.bb.desafio.gateway.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quote_dolar")
public class DolarQuoteEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "timestamp_requisicao")
    public LocalDateTime timestampRequisicao;
    @Column(name = "data_cotacao")
    public Date dataCotacao;
    @Column(name = "cotacao_compra")
    public double cotacaoCompra;
    @Column(name = "cotacao_venda")
    public double cotacaoVenda;
    @Column(name = "data_hora_cotacao")
    public LocalDateTime dataHoraCotacao;

}

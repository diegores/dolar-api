CREATE TABLE IF NOT EXISTS quote_dolar (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    timestamp_requisicao TIMESTAMP,
    data_cotacao DATE,
    cotacao_compra DOUBLE PRECISION,
    cotacao_venda DOUBLE PRECISION,
    data_hora_cotacao TIMESTAMP
);
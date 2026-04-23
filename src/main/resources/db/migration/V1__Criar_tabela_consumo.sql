-- V1: Cria a tabela REGISTRO_CONSUMO compatível com o mapeamento Java
CREATE TABLE IF NOT EXISTS REGISTRO_CONSUMO (
    id SERIAL PRIMARY KEY,
    local VARCHAR(255),
    equipamento VARCHAR(255),
    consumo_kwh DECIMAL(19,2),
    limite_alerta DECIMAL(19,2),
    data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Inserção de dados iniciais para o seu teste e print de evidência
INSERT INTO REGISTRO_CONSUMO (local, equipamento, consumo_kwh, limite_alerta)
VALUES ('Data Center Principal', 'Servidor de Aplicações', 850.75, 800.00);

INSERT INTO REGISTRO_CONSUMO (local, equipamento, consumo_kwh, limite_alerta)
VALUES ('Escritório Central', 'Ar Condicionado', 420.30, 500.00);
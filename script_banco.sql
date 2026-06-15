CREATE DATABASE IF NOT EXISTS db_alunos;
USE db_alunos;

-- Tabela de Produtos
CREATE TABLE IF NOT EXISTS produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    unidade VARCHAR(50) NOT NULL,
    quantidade_estoque INT NOT NULL DEFAULT 0,
    quantidade_minima INT NOT NULL DEFAULT 0,
    quantidade_maxima INT NOT NULL DEFAULT 0,
    id_categoria INT NOT NULL
);

-- Tabela de Movimentações
CREATE TABLE IF NOT EXISTS movimentacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT NOT NULL,
    data_movimentacao DATE NOT NULL,
    quantidade INT NOT NULL,
    tipo_movimentacao VARCHAR(50) NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

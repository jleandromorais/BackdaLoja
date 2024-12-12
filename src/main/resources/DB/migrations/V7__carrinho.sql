CREATE TABLE carrinho (
    productid INT PRIMARY KEY, -- Chave primária
    quantity INT NOT NULL, -- Quantidade do produto
    price INT NOT NULL, -- Preço do produto
    name VARCHAR(255) NOT NULL, -- Nome do produto
    imagem VARCHAR(255) NOT NULL, -- URL da imagem
    version INT DEFAULT 0 -- Controle de versão para concorrência
);

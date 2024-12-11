CREATE TABLE carrinho (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Coluna para o ID, com incremento automático
    name VARCHAR(255) NOT NULL,         -- Nome do item, não pode ser nulo
    price INT NOT NULL,                 -- Preço do item, não pode ser nulo
    imagem VARCHAR(255) NOT NULL,       -- Caminho da imagem do item, não pode ser nulo
    quantity INT NOT NULL               -- Quantidade do item, não pode ser nulo
);

# 🪑 Loja de Móveis - API e Frontend 🛠️

Este repositório contém o código do backend da loja de móveis desenvolvido em **Java Spring** (versão 21) e conectado a um frontend criado com **HTML, CSS e JavaScript**. A aplicação oferece funcionalidades para explorar o catálogo de móveis, registro/login de usuários e gestão de funcionários.

---

## 🚀 Funcionalidades

### Para Usuários Gerais 🌐
- **Explorar o catálogo de móveis**: Método `GET` no Insomnia.
- **Registrar e logar-se no sistema**: Método `POST` no Insomnia.

### Para Usuários da Empresa 🏢
- **Adicionar funcionários**:
  - Registrar **nome**, **função** e **salário**.
  - Método `POST` no Insomnia.
- **Editar dados de funcionários**:
  - Atualizar **nome**, **função** e **salário**.
  - Método `PUT` no Insomnia.
- **Remover funcionários**:
  - Deletar registros.
  - Método `DELETE` no Insomnia.
- **Listar funcionários ativos**:
  - Exibir todos os funcionários registrados que estão ativos.
  - Método `GET` no Insomnia.

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Linguagem**: Java ☕
- **Framework**: Spring Boot (versão 21)
- **Banco de Dados**: MySQL 🐬
- **Validações**: `jakarta.validation`

### Frontend
- **Linguagens**: HTML, CSS, JavaScript 🌐
- **Integração com API**: Conexão utilizando `fetch API` para consumir os endpoints criados no backend.

---

## 📁 Arquitetura

A aplicação segue uma arquitetura **RESTful**. Abaixo, destacamos os principais endpoints e seus métodos:

### 🌟 Endpoints e Métodos

1. **`POST /trabalho/trabalhadores`**
   - Cadastra um novo trabalhador.
   - **Validações**:
     - Nome e função não podem ser vazios.
     - Salário deve ser positivo e não nulo.
   - **Exemplo de requisição no Insomnia**:
     ```json
     {
       "nome": "João Silva",
       "funcao": "Vendedor",
       "salario": 2500.00
     }
     ```

2. **`GET /trabalho`**
   - Lista todos os trabalhadores ativos.
   - **Retorno**: Um array com nome, função e salário.

3. **`PUT /trabalho/{id}`**
   - Atualiza as informações de um trabalhador pelo **ID**.
   - **Exemplo de requisição**:
     ```json
     {
       "id": 1,
       "nome": "Maria Oliveira",
       "funcao": "Gerente",
       "salario": 4500.00
     }
     ```

4. **`DELETE /trabalho/{id}`**
   - Remove um trabalhador pelo **ID**.

---

## 🗂️ Estrutura de Arquivos

Os principais arquivos e suas responsabilidades:

1. **`TrabalhadoresController.java`**  
   - Controla as requisições e respostas relacionadas aos trabalhadores.
   - Implementa as operações de **CRUD** (Criar, Ler, Atualizar, Deletar).  
   📍 [Arquivo Fonte](TrabalhadoresController.java)

2. **`DadosdeCadastroTrabalhador.java`**  
   - Define o modelo de dados para o cadastro de trabalhadores.
   - Inclui validações para **nome**, **função** e **salário**.  
   📍 [Arquivo Fonte](DadosdeCadastroTrabalhador.java)

3. **`DadosAtualizarDados.java`**  
   - Define o modelo de dados para atualizar informações dos trabalhadores.
   - Inclui validações semelhantes ao cadastro, além de exigir um **ID válido**.  
   📍 [Arquivo Fonte](DadosAtualizarDados.java)

---

## 🖥️ Como Executar o Projeto

### Pré-requisitos
- **Java 17** ou superior instalado.
- **MySQL** configurado.
- **Node.js** (opcional, caso sirva o frontend com um servidor local).

### Backend
1. Clone o repositório:
   ```bash
   git clone https://github.com/jleandromorais/BackdaLoja.git

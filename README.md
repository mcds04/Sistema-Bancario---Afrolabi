# Sistema-Bancario--- System Banking - Afrolabi - **PROJETO FINAL**
Este Projeto Implementa um Sistema Bancário Simples
# Sistema Bancário - Readme

## Visão Geral do Projeto

Este é um projeto de um sistema bancário desenvolvido com Spring Boot, Spring Data JPA e banco de dados PostgreSQL. O objetivo deste sistema é fornecer uma plataforma para gerenciamento de clientes, contas e transações bancárias.

## Funcionalidades Principais

O sistema bancário implementa as seguintes funcionalidades:

1. **Gerenciamento de Clientes**:
   - Criação, atualização, exclusão e listagem de clientes.
   - Cada cliente possui informações como nome, CPF, e-mail, endereço e renda salarial.

2. **Gerenciamento de Contas**:
   - Criação, atualização, exclusão e listagem de contas bancárias.
   - Cada conta está associada a um cliente específico.
   - As contas possuem informações como número, saldo e categoria (corrente, poupança, etc.).

3. **Gerenciamento de Transações**:
   - Realização de transações bancárias (depósito, saque e transferência) entre as contas.
   - Registro de todas as transações realizadas.
   - Consulta do histórico de transações por conta.

## Tecnologias Utilizadas

- **Spring Boot**: Framework Java para desenvolvimento de aplicações web.
- **Spring Data JPA**: Módulo do Spring para acesso a dados usando o Java Persistence API (JPA).
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional.
- **PgAdmin**: Ferramenta gráfica para administração do banco de dados PostgreSQL.
- **Postman**: Aplicativo para teste e documentação de APIs.

## Estrutura do Projeto

O projeto está organizado da seguinte maneira:

1. **Pacotes**:
   - `com.bancosystem.model`: Contém as classes de entidade do modelo de domínio, como `Cliente` e `Conta`.
   - `com.bancosystem.repository`: Contém as interfaces de repositório JPA para acesso aos dados.
   - `com.bancosystem.service`: Contém as classes de serviço que implementam a lógica de negócios.
   - `com.bancosystem.controller`: Contém os controladores REST que expõem os endpoints da API.

2. **Arquivos de Configuração**:
   - `application.properties`: Contém as configurações do Spring Boot e do banco de dados PostgreSQL.

## Endpoints da API

A API REST do sistema bancário expõe os seguintes endpoints:

| Método | Rota | Descrição |
| --- | --- | --- |
| GET | `/api/clientes` | Lista todos os clientes |
| POST | `/api/clientes` | Cria um novo cliente |
| PUT | `/api/clientes/{id}` | Atualiza as informações de um cliente |
| DELETE | `/api/clientes/{id}` | Exclui um cliente |
| GET | `/api/contas` | Lista todas as contas |
| POST | `/api/contas` | Cria uma nova conta |
| PUT | `/api/contas/{id}` | Atualiza as informações de uma conta |
| DELETE | `/api/contas/{id}` | Exclui uma conta |
| POST | `/api/contas/{id}/transacoes` | Realiza uma transação em uma conta |
| GET | `/api/contas/{id}/transacoes` | Lista as transações de uma conta |

## Regras de Negócio

1. **Clientes**:
   - Um cliente deve possuir nome, CPF, e-mail, endereço e renda salarial.
   - Não é permitido cadastrar um cliente com o mesmo CPF.

2. **Contas**:
   - Uma conta deve estar associada a um cliente.
   - Uma conta pode ser do tipo corrente, poupança ou investimento.
   - O saldo de uma conta não pode ser negativo.

3. **Transações**:
   - As transações válidas são depósito, saque e transferência.
   - O saldo da conta de destino deve ser atualizado após uma transferência.
   - Não é permitido sacar um valor maior que o saldo da conta.

## Teste no Postman

Para testar a API do sistema bancário, você pode usar o Postman com as seguintes configurações:

1. **Criar um Cliente**:
   - Método: POST
   - Rota: `http://localhost:8080/api/clientes`
   - Body (JSON):
     ```json
     {
       "nome": "Cristina Sousa",
       "cpf": "12345678901",
       "email": "Cristina.Sousa@example.com",
       "endereco": "Rua das Flores, 123",
       "rendaSalarial": 3200.0
     }
     ```

2. **Criar uma Conta**:
   - Método: POST
   - Rota: `http://localhost:8080/api/contas`
   - Body (JSON):
     ```json
     {
       "cliente": "/api/clientes/1",
       "tipo": "CORRENTE",
       "saldo": 1000.0
     }
     ```

3. **Realizar uma Transação**:
   - Método: POST
   - Rota: `http://localhost:8080/api/contas/1/transacoes`
   - Body (JSON):
     ```json
     {
       "tipo": "DEPOSITO",
       "valor": 500.0
     }
     ```

4. **Listar as Transações de uma Conta**:
   - Método: GET ![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/54877071-c489-4b71-a47c-6d7ceb6c5bde)

   - Rota: `http://localhost:8080/api/contas/1/transacoes`


1. **Ícones de Tecnologias:**
   - Spring Boot: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/0dd56bbf-a189-4634-9e4b-35050d88e23f)
" />`
   - Spring Data JPA: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/3273d52b-4fd5-495a-8bfc-b36ee53eab38)
" />`
   - PostgreSQL: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/51e7a83e-7f61-437f-ad17-fd974026851b)
" />`
   - Postman: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/8265e651-ac76-4e3d-b8fc-09fbbec4e2ab)
" />`

2. **Ícones de Status**:
   - Construído com: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/45531de9-0192-410d-a770-666a0c569750)
" />`
   - Estado do Projeto: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/84af89eb-11a1-48a3-ab72-dc861dba94c2)
" />`

3. **Ícones de Licença**:
   - Licença MIT: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/0b93ddaa-a33b-417a-9079-914fa098e018)
" />`

4. **Ícones de Badges**:
   - Versão: `<img src="https://img.shields.io/badge/version-1.0-blue.svg" alt="version" />`
   - Tamanho do Repositório: `<img src="https://img.shields.io/github/repo-size/seu-usuario/seu-projeto.svg" alt="repo size" />`

5. **Ícones de Contato**:
   - LinkedIn: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/6f4f9b51-8ce7-409d-95bd-37ea2f54cc0c)
" alt="LinkedIn" /></a>` https://www.linkedin.com/in/cristina-sousa-359a9777/
   - E-mail: `<![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/8cded5d2-2fb3-4c21-955f-08f93a24b354)
>`



## Conclusão   ![image](https://github.com/mcds04/Sistema-Bancario---Afrolabi/assets/100251166/0f0b8ada-46db-4b46-b287-dcd1db3c3975)


Este projeto de sistema bancário demonstra a implementação de uma API REST utilizando Spring Boot, Spring Data JPA e PostgreSQL. Ele abrange as funcionalidades básicas de gerenciamento de clientes, contas e transações bancárias, com as respectivas regras de negócio.

fornece uma visão geral do projeto, as tecnologias utilizadas, a estrutura do código-fonte, os endpoints da API e as instruções de teste no Postman. Essa documentação pode ser utilizada como base para a implantação e manutenção deste sistema bancário.

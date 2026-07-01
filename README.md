# MovieFlix

API REST em Spring Boot para catálogo de filmes/streamings, com persistência em PostgreSQL via JPA + Flyway.

> ⚠️ Projeto em desenvolvimento inicial. Hoje o CRUD cobre apenas **Category** e **Streaming** — ainda não há entidade de Filme, e a camada de segurança (Spring Security/JWT) está no `pom.xml` mas comentada, ou seja, todos os endpoints estão abertos.

## Stack

- **Java 17**
- **Spring Boot 3.5.11**
  - Spring Web
  - Spring Data JPA
  - Bean Validation (dependência incluída, ainda sem uso nos DTOs)
- **PostgreSQL**
- **Flyway** (versionamento de schema)
- **Lombok**
- **JUnit 5 / spring-boot-starter-test** (estrutura de teste criada, sem testes escritos ainda)

## Estrutura do projeto

```
src/main/java/com/MovieFlix
├── Controller/
│   ├── CategoryController.java
│   └── StreamingController.java
├── entity/
│   ├── Category.java
│   └── Streaming.java
├── mapper/
│   ├── CategoryMapper.java
│   └── StreamingMapper.java
├── repository/
│   ├── CategoryRepository.java
│   └── StreamingRepository.java
├── request/
│   ├── CategoryRequest.java
│   └── StreamingRequest.java
├── response/
│   ├── CategoryResponse.java
│   └── StreamingResponse.java
└── service/
    ├── CategoryService.java
    └── StreamingService.java
```

Arquitetura em camadas simples: `Controller → Service → Repository`, com `Request`/`Response` DTOs e `Mapper` estático para conversão (sem MapStruct por enquanto).

## Como rodar

### Pré-requisitos

- JDK 17+
- PostgreSQL rodando localmente (ou em container)
- Maven (o projeto já inclui o wrapper `mvnw`)

### 1. Variáveis de ambiente

A aplicação lê a conexão com o banco via variáveis de ambiente (`src/main/resources/application.yaml`):

```
DB_URL=jdbc:postgresql://localhost:5432/movieflix
DB_USERNAME=postgres
DB_PASSWORD=sua_senha
```

Configure-as no seu ambiente ou na configuração de Run da sua IDE antes de subir a aplicação.

### 2. Banco de dados

O schema é criado automaticamente pelo Flyway ao iniciar a aplicação, a partir das migrations em `src/main/resources/db/migration`. Não é necessário criar as tabelas manualmente.

### 3. Rodar a aplicação

```bash
./mvnw spring-boot:run
```

A API sobe por padrão em `http://localhost:8080`.

## Endpoints

### Category — `/movieflix/category`

| Método | Rota            | Descrição                     |
|--------|-----------------|--------------------------------|
| GET    | `/listar`       | Lista todas as categorias      |
| GET    | `/buscar/{id}`  | Busca uma categoria por ID     |
| POST   | `/salvar`       | Cria uma nova categoria        |
| DELETE | `/deletar/{id}` | Remove uma categoria por ID    |

**Body (POST /salvar):**
```json
{
  "name": "Ação"
}
```

### Streaming — `/movieflix/streaming`

| Método | Rota            | Descrição                     |
|--------|-----------------|--------------------------------|
| GET    | `/listar`       | Lista todos os streamings      |
| GET    | `/buscar/{id}`  | Busca um streaming por ID      |
| POST   | `/salvar`       | Cria um novo streaming         |
| DELETE | `/deletar/{id}` | Remove um streaming por ID     |

**Body (POST /salvar):**
```json
{
  "name": "Netflix"
}
```

## Roadmap

- [ ] Entidade de Filme relacionando Category e Streaming
- [ ] Ativar Spring Security + JWT (dependências já previstas no `pom.xml`)
- [ ] Validação de entrada com Bean Validation nos `Request`
- [ ] Tratamento global de exceções (`@ControllerAdvice`)
- [ ] Testes unitários e de integração

## Autor

Desenvolvido por [João](https://github.com/joao2dev).

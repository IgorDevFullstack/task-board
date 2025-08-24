# 🗂️ Task Board (Spring Boot)

Um projeto simples de **Board de Tarefas** (como um mini-Trello) usando **Java + Spring Boot + H2 Database**.  
Permite gerenciar **Boards (quadros)** e **Tasks (tarefas)** via **APIs REST**.

---

## 🚀 Tecnologias
- Java 17
- Spring Boot 3 (Web, JPA, H2)
- Maven
- REST API (CRUD)

---

## 📦 Como rodar

1. Clone ou baixe este repositório.
2. Entre na pasta do projeto.
3. Rode:
   ```bash
   mvn spring-boot:run

    A API estará em:
    👉 http://localhost:8080

🗄️ Banco de Dados

O projeto usa H2 em memória (reinicia a cada execução).
Acesse o console em:

    URL: http://localhost:8080/h2-console

    JDBC: jdbc:h2:mem:boarddb

    User: sa

    Password: (vazio)

🌐 Endpoints
📋 Boards
Método	Endpoint	Descrição
GET	/api/boards	Lista todos os boards
GET	/api/boards/{id}	Busca board por ID
POST	/api/boards	Cria um novo board
PUT	/api/boards/{id}	Atualiza board existente
DELETE	/api/boards/{id}	Remove um board

Exemplo JSON (POST /api/boards):

{
  "name": "Projeto X"
}

✅ Tasks
Método	Endpoint	Descrição
GET	/api/tasks	Lista todas as tarefas
GET	/api/tasks/{id}	Busca tarefa por ID
POST	/api/tasks	Cria uma nova tarefa
PUT	/api/tasks/{id}	Atualiza tarefa existente
DELETE	/api/tasks/{id}	Remove uma tarefa

Exemplo JSON (POST /api/tasks):

{
  "title": "Criar API",
  "description": "Implementar endpoints",
  "status": "TODO"
}

⚡ Testes rápidos com cURL
Criar Board

curl -X POST http://localhost:8080/api/boards \
  -H "Content-Type: application/json" \
  -d '{"name":"Projeto X"}'

Criar Task

curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Implementar API","description":"CRUD completo","status":"DOING"}'

🎯 Próximos passos

    Relacionar tarefas a boards via API

    Adicionar autenticação com Spring Security

    Criar interface web ou mobile para consumir a API

💻 Feito com ☕ e Spring Boot 🚀


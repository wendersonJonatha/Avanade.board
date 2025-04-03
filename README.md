# Board de Tarefas

## 📌 Descrição
Este projeto consiste na criação de um **board de tarefas** utilizando **Java**, abordando todas as etapas do desenvolvimento, desde o planejamento e estruturação até a implementação de funcionalidades essenciais. O objetivo é consolidar conhecimentos sobre desenvolvimento de software, seguindo boas práticas e padrões de arquitetura.

## 🎯 Objetivos
- Planejar e estruturar o sistema.
- Implementar funcionalidades para gerenciamento de tarefas.
- Criar um back-end robusto utilizando **Java** e **Spring Boot**.
- Aplicar boas práticas de programação e arquitetura de software.
- Integrar as camadas do sistema (modelo, serviço e controle).

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java
- **Framework:** Spring Boot
- **Banco de Dados:** PostgreSQL / MySQL (definir durante o projeto)
- **Ferramentas:** Maven, Git, Docker (opcional)

## 📂 Estrutura do Projeto
```
Avanade.board/
├── src/
│   ├── main/
│   │   ├── java/com/board/Avanade/board
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── dto/
│   │   ├── resources/
│   │   │   ├── application.properties
│   ├── test/
│   │   ├── java/com/board/Avanade/board/
```

## 📌 Funcionalidades
- Criar, editar e excluir tarefas.
- Marcar tarefas como concluídas.
- Categorizar tarefas.
- Listar tarefas pendentes e concluídas.
- Integração com banco de dados para persistência.

## 🚀 Como Executar o Projeto
1. Clone este repositório:
   ```bash
   git clone https://github.com/wendersonJonatha/Avanade.board.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd Avanade.board
   ```
3. Configure o banco de dados no `application.properties`.
4. Compile e execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse a API em `http://localhost:8080`.

## 📝 Contribuição
Contribuições são bem-vindas! Para contribuir:
1. Faça um **fork** do projeto.
2. Crie uma **branch** para a funcionalidade:
   ```bash
   git checkout -b minha-nova-feature
   ```
3. Faça o commit das suas alterações:
   ```bash
   git commit -m "Adiciona nova funcionalidade"
   ```
4. Envie para o repositório remoto:
   ```bash
   git push origin minha-nova-feature
   ```
5. Abra um **Pull Request**.

## 📜 Licença
Este projeto está sob a licença MIT.


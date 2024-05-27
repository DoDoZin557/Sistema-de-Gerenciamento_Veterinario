# Sistema Veterinário

Um sistema de gerenciamento de uma clínica veterinária, desenvolvido em Java. Este sistema permite gerenciar donos, animais, funcionários, consultas e serviços oferecidos pela clínica.

## Descrição

O Sistema Veterinário é uma aplicação Java que permite:
- Adicionar, listar, atualizar e excluir donos, animais, funcionários, consultas e serviços.
- Conectar-se a um banco de dados PostgreSQL para persistência dos dados.

## Requisitos

- Java 11 ou superior
- PostgreSQL
- IDE Java (como IntelliJ IDEA, Eclipse, etc.)

## Configuração do Banco de Dados

1. **Instale o PostgreSQL**: Certifique-se de que o PostgreSQL está instalado no seu sistema.
2. **Crie o banco de dados**:
   - Abra o pgAdmin ou qualquer outra ferramenta de administração do PostgreSQL.
   - Crie um novo banco de dados chamado `SistemaVeterinario`.

3. **Crie as tabelas necessárias**:
   ```sql
   CREATE TABLE donos (
       id SERIAL PRIMARY KEY,
       nome VARCHAR(255) NOT NULL,
       endereco VARCHAR(255),
       telefone VARCHAR(15)
   );

   CREATE TABLE animais (
       id SERIAL PRIMARY KEY,
       nome VARCHAR(255) NOT NULL,
       especie VARCHAR(255) NOT NULL,
       idade INTEGER,
       dono_id INTEGER REFERENCES donos(id)
   );

   CREATE TABLE funcionarios (
       id SERIAL PRIMARY KEY,
       nome VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL,
       telefone VARCHAR(15)
   );

   CREATE TABLE consultas (
       id SERIAL PRIMARY KEY,
       data_consulta DATE NOT NULL,
       hora_consulta TIME NOT NULL,
       animal_id INTEGER REFERENCES animais(id),
       funcionario_id INTEGER REFERENCES funcionarios(id)
   );

   CREATE TABLE servicos (
       id SERIAL PRIMARY KEY,
       nome VARCHAR(255) NOT NULL,
       preco NUMERIC(10, 2) NOT NULL,
       animal_id INTEGER REFERENCES animais(id)
   );
Conceda permissões ao usuário:
sql
Copiar código
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO seu_usuario;
Instalação
Clone o repositório:

bash
Copiar código
git clone https://github.com/seu_usuario/sistema-veterinario.git
cd sistema-veterinario
Configure a conexão com o banco de dados no arquivo ConfiguracaoBancoDados.java:

java
Copiar código
private static final String URL = "jdbc:postgresql://localhost:5432/SistemaVeterinario";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
Adicione o driver do PostgreSQL ao seu projeto. No caso de usar Maven, adicione a dependência no seu pom.xml:

xml
Copiar código
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.2.5</version>
</dependency>
Uso
Compile o projeto e execute a classe Main:

bash
Copiar código
javac Main.java
java Main
O sistema irá apresentar um menu interativo para gerenciar donos, animais, funcionários, consultas e serviços.

Contribuição
Faça um fork do projeto
Crie uma branch para sua feature (git checkout -b feature/nova-feature)
Faça commit das suas alterações (git commit -am 'Adiciona nova feature')
Faça push para a branch (git push origin feature/nova-feature)
Abra um Pull Request

Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.


Certifique-se de substituir `seu_usuario` e `sua_senha` pelos valores corretos do seu banco de dados PostgreSQL. Adicione também um arquivo de licença se necessário.

Com isso, você pode colar este conteúdo no arquivo `README.md` do seu repositório no GitHub. Se precisar de mais alguma coisa, estou à disposição para ajudar!






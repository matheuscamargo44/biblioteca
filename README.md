# Biblioteca - Sistema de Gerenciamento de Livros

Sistema de gerenciamento de biblioteca desenvolvido em Java que permite o cadastro, consulta, empréstimo e devolução de livros através de uma interface de linha de comando.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação orientada a objetos
- **Scanner**: Biblioteca padrão do Java para entrada de dados via console
- **ArrayList**: Estrutura de dados para armazenamento em memória
- **Interface Repository**: Padrão de projeto para abstração de acesso a dados

## Estrutura do Projeto

```
biblioteca/
├── src/
│   ├── Main.java                    # Classe principal da aplicação
│   ├── model/
│   │   ├── Livro.java              # Entidade de livro
│   │   ├── Autor.java              # Entidade de autor
│   │   ├── IBibliotecaRepository.java    # Interface do repositório
│   │   └── BibliotecaRepository.java     # Implementação do repositório
│   ├── controller/
│   │   └── BibliotecaController.java     # Controlador da aplicação
│   └── view/
│       └── Menu.java                # Interface do usuário
└── biblioteca.iml
```

## Instalação

1. **Pré-requisitos:**
   - Java JDK 8 ou superior instalado
   - IDE compatível com Java (IntelliJ IDEA, Eclipse, VS Code, etc.)

2. **Clonar ou baixar o projeto:**
   ```bash
   git clone https://github.com/seu-usuario/biblioteca.git
   cd biblioteca
   ```

3. **Compilar o projeto:**
   ```bash
   javac -d bin src/**/*.java
   ```

4. **Executar a aplicação:**
   ```bash
   java -cp bin Main
   ```

   Ou execute através da IDE de sua preferência executando a classe `Main.java`.

## Modelos de Dados

O sistema possui as seguintes entidades principais:

- **Livro**: Representa um livro da biblioteca
  - `id`: Identificador único (gerado automaticamente)
  - `nome`: Título do livro
  - `emprestado`: Status de empréstimo (true/false)

- **Autor**: Representa o autor de um livro
  - `nome`: Nome do autor

## Funcionalidades Principais

### 1. Adicionar Livro
Permite cadastrar novos livros na biblioteca. O sistema valida se o nome não está vazio e gera automaticamente um ID único.

### 2. Remover Livro
Remove um livro do acervo pelo ID. Verifica se o livro existe antes de remover.

### 3. Listar Livros
Exibe todos os livros cadastrados com suas informações (ID, nome e status de empréstimo).

### 4. Buscar por ID
Permite localizar um livro específico pelo seu ID, exibindo todas as informações do livro.

### 5. Emprestar Livro
Realiza o empréstimo de um livro disponível. O sistema:
- Lista apenas os livros disponíveis
- Valida se o livro existe e está disponível
- Atualiza o status de empréstimo

### 6. Devolver Livro
Realiza a devolução de um livro emprestado. O sistema:
- Lista apenas os livros emprestados
- Valida se o livro existe e está emprestado
- Atualiza o status de empréstimo

## Arquitetura do Sistema

O projeto segue o padrão de arquitetura em camadas:

### Camada de Modelo (Model)
- `Livro.java`: Entidade que representa um livro
- `Autor.java`: Entidade que representa um autor
- `IBibliotecaRepository.java`: Interface que define os contratos de acesso a dados
- `BibliotecaRepository.java`: Implementação do repositório com armazenamento em memória

### Camada de Controle (Controller)
- `BibliotecaController.java`: Controlador que coordena as operações entre a view e o modelo

### Camada de Apresentação (View)
- `Menu.java`: Interface de usuário que exibe o menu e gerencia a interação com o usuário

## Padrões de Projeto Utilizados

- **Repository Pattern**: Abstração do acesso a dados através da interface `IBibliotecaRepository`
- **MVC (Model-View-Controller)**: Separação de responsabilidades em três camadas distintas

## Tratamento de Erros

O sistema implementa tratamento de erros para:
- Entradas inválidas (números quando esperado texto e vice-versa)
- Validação de campos obrigatórios (nome do livro não pode estar vazio)
- Verificação de existência de livros antes de operações
- Validação de status de empréstimo antes de operações

## Funcionalidades de Validação

- Validação de entrada numérica para IDs
- Validação de nome de livro não vazio
- Verificação de existência de livro antes de remover
- Verificação de disponibilidade antes de emprestar
- Verificação de status emprestado antes de devolver
- Mensagens de erro claras e informativas

## Observações

- Os dados são armazenados em memória (ArrayList), portanto são perdidos ao encerrar a aplicação
- Os IDs são gerados automaticamente de forma sequencial
- O sistema permite múltiplos empréstimos simultâneos
- A interface é interativa via console, com menu em loop até o usuário escolher sair

## Melhorias Futuras

- Persistência de dados em banco de dados ou arquivo
- Sistema de usuários e controle de empréstimos por usuário
- Data de empréstimo e devolução
- Sistema de multas por atraso
- Busca por nome do livro
- Relacionamento entre Livro e Autor
- Sistema de categorias de livros
- Interface gráfica (GUI)

## Desenvolvimento

O projeto utiliza Java puro sem frameworks adicionais, focando em:
- Boas práticas de programação orientada a objetos
- Separação de responsabilidades
- Código limpo e manutenível
- Tratamento adequado de exceções

## Uso do Sistema

Ao executar o programa, você verá um menu interativo com as seguintes opções:

```
=== MENU PRINCIPAL ===
[1] - Adicionar Livro
[2] - Remover Livro
[3] - Listar Livros
[4] - Buscar por ID
[5] - Emprestar Livro
[6] - Devolver Livro
[0] - Sair
```

Digite o número correspondente à opção desejada e siga as instruções exibidas na tela.


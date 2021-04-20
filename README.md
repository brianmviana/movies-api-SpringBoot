# API Rest de filmes

## 🚨 Requisitos

- Banco de dados _MySQL_ instalado maquina

## 🏗 O que foi desenvolvido?

Uma API rest com as seguintes funcionalidades:

- Administrador
  - Cadastro
  - Edição
  - Exclusão lógica (desativação)
  - Listagem de usuários não administradores ativos
    - Registros paginados
    - Filtros por nome e login
- Usuário
  - Cadastro
  - Edição
  - Exclusão lógica (desativação)
- Filmes
  - Cadastro (somente um usuário administrador poderá realizar esse cadastro)
  - Voto (a contagem de votos será feita por usuário de 0-4 que indica quanto o usuário gostou do filme)
  - Listagem
    - Filtros por diretor, nome, gênero e/ou atores
    - Registros paginados
  - Detalhes do filme trazendo todas as informações sobre o filme

## 🖥 Endpoints

    base_url : localhost:8080

### Token

    - [POST]    base_url/oauth/token
    - [POST]    base_url/token/revoke

### Filmes

    - [GET]     base_url/filmes
    - [GET]     base_url/filmes/{id}
    - [POST]    base_url/filmes
    - [PUT]     base_url/filmes/{id}
    - [DELETE]  base_url/filmes/{id}

### Usuarios

    - [GET]     base_url/usuarios
    - [GET]     base_url/usuarios/{login}
    - [POST]    base_url/usuarios
    - [PUT]     base_url/usuarios/{id}
    - [DELETE]  base_url/usuarios/{id}

### Votos

    - [GET]     base_url/filmes/{id}/votos
    - [GET]     base_url/usuario/{login}/votos
    - [POST]    base_url/filmes/{id}/votar

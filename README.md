![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/JoaoTorpe/testeCapyba.git
```

2. Install dependencies with Maven

3. Install [PostgresSQL](https://www.postgresql.org/)

## Authentication and security
- The user's authentication is based on stateless authentication using Bearer schema and JWT for generating the tokens.
- When the user logs out, the session token is thrown into a 'Black list' for preventing Session fixation and Replay attacks.
- Tokens have a 2 hours lifetime.
- Passwords are been encrypted.
 


## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080
3. The Swagger will be accessible at http://localhost:8080/swagger-ui/index.html

## API Endpoints
```markdown
GET /produtos - Retrieve a list of all products. (Auth required)
```
```json
[
  {
    "id": 1,
    "nome": "mouse",
    "preco": 120,
    "disponivel": true
  },
  {
    "id": 2,
    "nome": "teclado",
    "preco": 510,
    "disponivel": true
  },
  {
    "id": 3,
    "nome": "geledeira",
    "preco": 3400,
    "disponivel": false
  },
  {
    "id": 4,
    "nome": "garrafa",
    "preco": 34.5,
    "disponivel": false
  }
]
```
```markdown
GET /produtos?disposinel=true/false - Retrieve a list of all products filtered by the boolean 'disponivel'
```
**Ex: disponivel=true**
```json
[
  {
    "id": 1,
    "nome": "mouse",
    "preco": 120,
    "disponivel": true
  },
  {
    "id": 2,
    "nome": "teclado",
    "preco": 510,
    "disponivel": true
  }
]
```

```markdown
GET /produtos?orderby=nome/preco - Retrieve a list of all products ordered by 'nome'  or 'preco'
```
**Ex: Orderby=preco**
```json
[
  {
    "id": 4,
    "nome": "garrafa",
    "preco": 34.5,
    "disponivel": false
  },
  {
    "id": 1,
    "nome": "mouse",
    "preco": 120,
    "disponivel": true
  },
  {
    "id": 2,
    "nome": "teclado",
    "preco": 510,
    "disponivel": true
  },
  {
    "id": 3,
    "nome": "geledeira",
    "preco": 3400,
    "disponivel": false
  }
]
```

```markdown
GET /produtos?search=string -  Retrieve a list of all products that matches with the inputed string
```
**Ex: search=tec**
```json
[
  {
    "id": 2,
    "nome": "teclado",
    "preco": 510,
    "disponivel": true
  }
]
```

```markdown
POST /auth/login - Login into the App (Returns a token)
```
```json
{
"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
}
```
```markdown
POST /auth/registrar - Register a new user into the App
```
```markdown
POST /auth/logout - Logout the current user
```
```markdown
PUT /auth - Updates the current user credentials
```



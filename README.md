
### cursos
>- https://www.udemy.com/course/spring-boot-jwt-tutorial


### users { username - password}
>- admin admin
>- user user
>- nickname nickname

### urls de api
>- localhost:8080/api/hello
>- localhost:8080/api/authenticate
>- localhost:8080/api/signup 
>- localhost:8080/h2-console

### urls de swagger
>- localhost:8080/v3/api-docs/
>- localhost:8080/swagger-ui/index.html


### pendiente pruebas unitarias


###
http://localhost:8080/graphiql?query=%7B%0A%20%20hello%2C%0A%20%20soma(a%3A1%2C%20b%3A2)%0A%7D
# solo query o mutation
query GetCliente($id:ID!){
  hello,
  soma(a:1, b:2),
  t1: tio(id: $id) {
    id, nombre, email, password
  },
  t2: tio(id: 2) {
    ...fragTio
  },
  tios {
    id, nombre, password
  }
}

fragment fragTio on Tio {
  id, nombre, email, password
}


# solo se puede ejecutar uno a la vez
mutation{
 saveTio(tio:{
    nombre:"nuevo",
    email:"nuevo@ejemplo.com",
    password:"12345678"
  }) {
    id, nombre
  },
  deleteTio(id: 4)
}


#### ver esquema
http://localhost:8080/graphql/schema.json

### hacer dos peticiones
query {
  t1: tio(id: 1) {
    id,
    nombre,
   email
  },
  t2: tio(id: 2) {
    id,
    nombre,
   email
  }
}

### usando fragment
query {
  t1: tio(id: 1) {
    ...fragTio
  },
  t2: tio(id: 2) {
    ...fragTio
  }
}

fragment fragTio on Tio {
  id, nombre, email, password
}

#### http://localhost:8080/graphiql
query GetCliente($id:ID!){
  t1: tio(id: $id) {
    id, nombre, email, password
  }
}
#### query variables
{
  "id":1
}



# backend-challenge
Projeto do desafio iti digital

Aplicação construída na linguagem Java(11)-maven utilizando a stack springboot e baseada no conceito de arquitetura hexagonal, onde podemos desacoplar componentes e acoplar novos componentes utilizando as interfaces Ports, e deixando a camada Domain completamente especialista nas regras de negócio, sendo possível tambem a inclusão de um novo componente port/adapter para a persistência de credenciais novas a algum serviço de pool de usuários.

A Api expõe a avaliação (recurso: /credentials-eval) da senha com a premissa de que seja um novo usuario do sistema, no momento de sua criação, a Api valida se o valor digitado da senha condiz com as regras básicas da senha que são:
- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
- Não possuir caracteres repetidos dentro do conjunto
- Nota: Espaços em branco não devem ser considerados como caracteres válidos.

### Como executar
É necessário ter o maven previamente instalado (https://maven.apache.org/)

> **_cd /{diretorio do projeto}_** 

> **_mvn clean install_** 

> **_java -jar .\application\target\application-0.0.1-SNAPSHOT.jar_** 

### Exemplo de requisição

POST /credentials-eval HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "password" : "AbTp!9fok"
}

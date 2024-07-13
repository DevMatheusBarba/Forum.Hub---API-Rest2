# Forum Hub

## Descrição
API permite o cadastro e gerenciamento de topicos, usuarios, respostas e cursos, visando simular uma comunidade real de duvidas.

# Tecnologia Utilizada
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) - Linguagem de progração voltado para o back-end

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) -  Framework para construção de APIs com **Java**

![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) - Banco de dados relacional

![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens) - Para autenticações mais seguras

**Flyway** - Para gravar historico do banco de dados

**Bean Validation** - Para fazer validação de conteudos entregues a API




## Índice
- [Tecnologia Utilizadas](#tecnologia-utilizada)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
- [Contato](#contato)

# Instalação

### Requisitos
- [Java JDK 21](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Intellij IDEA Community](https://www.jetbrains.com/pt-br/idea/download/?section=windows)
- [Postman](https://www.postman.com/downloads/)

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/DevMatheusBarba/Voll.med---API-Rest.git
   ```
2. Crie as variaveis de ambiente no seu sistema operacional
   
``` bash
   #BD_HOST = localhost

   #BD_USER = postgres (Usuario padrão do PostgreSQL)

   #BD_PASSWORD = Sua Senha do Banco PostgreSQL
```
## Configuração

1. Crie um banco de dados nomeado como **Forum.hub** no postgreSQL
   > **OBS:**
   >
   > Caso crei o banco com outro nome precisa alterar o o endereço no **src/main/resources/application.properties** na propriedade spring.datasource.url .
   
2. Crie um usuário no banco de dados.
   >    Acesse o Postman com a sua aplicação rodando, dispare uma requisição do tipo POST para o endereço: http://localhost:8080/usuario
      
          {
            "nome":"User Name",
            "email":"Email User",
            "senha":"Password User"
          }

## Uso

#### 1. Rode a aplicação
- Intellij
  > Execute o unico método existente dentro da **Class** **ApiApplication**
```bash
 
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.1)

2024-07-11T19:08:11.111-03:00  INFO 16932 --- [api] [           main] forum.hub.api.ApiApplication             : Starting ApiApplication v0.0.1-SNAPSHOT using Java 21.0.2 with PID 16932 (C:\Users\mathe\OneDrive\├ürea de Trabalho\Java\Projetos Finais\Forum.Hub---API-Rest\target\api-0.0.1-SNAPSHOT.jar started by mathe in C:\Users\mathe\OneDrive\├ürea de Trabalho\Java\Projetos Finais\Forum.Hub---API-Rest)
2024-07-11T19:08:11.115-03:00  INFO 16932 --- [api] [           main] forum.hub.api.ApiApplication             : No active profile set, falling back to 1 default profile: "default"
2024-07-11T19:08:12.272-03:00  INFO 16932 --- [api] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2024-07-11T19:08:12.332-03:00  INFO 16932 --- [api] [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 52 ms. Found 4 JPA repository interfaces.
2024-07-11T19:08:12.972-03:00  INFO 16932 --- [api] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-07-11T19:08:12.995-03:00  INFO 16932 --- [api] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-07-11T19:08:12.995-03:00  INFO 16932 --- [api] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.25]
2024-07-11T19:08:13.027-03:00  INFO 16932 --- [api] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-07-11T19:08:13.032-03:00  INFO 16932 --- [api] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1842 ms
2024-07-11T19:08:13.312-03:00  INFO 16932 --- [api] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-07-11T19:08:13.566-03:00  INFO 16932 --- [api] [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection@27a9f025
2024-07-11T19:08:13.572-03:00  INFO 16932 --- [api] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2024-07-11T19:08:13.607-03:00  INFO 16932 --- [api] [           main] org.flywaydb.core.FlywayExecutor         : Database: jdbc:postgresql://localhost/forum.hub (PostgreSQL 16.3)
2024-07-11T19:08:13.662-03:00  INFO 16932 --- [api] [           main] o.f.core.internal.command.DbValidate     : Successfully validated 2 migrations (execution time 00:00.034s)
2024-07-11T19:08:13.717-03:00  INFO 16932 --- [api] [           main] o.f.core.internal.command.DbMigrate      : Current version of schema "public": 2
2024-07-11T19:08:13.722-03:00  INFO 16932 --- [api] [           main] o.f.core.internal.command.DbMigrate      : Schema "public" is up to date. No migration necessary.
2024-07-11T19:08:13.822-03:00  INFO 16932 --- [api] [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2024-07-11T19:08:13.892-03:00  INFO 16932 --- [api] [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.5.2.Final
2024-07-11T19:08:13.937-03:00  INFO 16932 --- [api] [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2024-07-11T19:08:14.242-03:00  INFO 16932 --- [api] [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2024-07-11T19:08:15.152-03:00  INFO 16932 --- [api] [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2024-07-11T19:08:15.152-03:00  INFO 16932 --- [api] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2024-07-11T19:08:15.512-03:00  INFO 16932 --- [api] [           main] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with UserDetailsService bean with name autenticacaoService
piApplication in 6.17 seconds (process running for 6.698)
2024-07-11T19:08:24.772-03:00  INFO 16932 --- [api] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-07-11T19:08:24.772-03:00  INFO 16932 --- [api] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-07-11T19:08:24.772-03:00  INFO 16932 --- [api] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
2024-07-11T19:08:25.472-03:00  INFO 16932 --- [api] [nio-8080-exec-9] o.springdoc.api.AbstractOpenApiResource  : Init duration for springdoc-openapi is: 332 ms

```

#### 2. Disparando requisição
> Todo o projeto está com o modulo de autenticação via Token, sendo liberado a principio apenas requisição de login! Para isso vamos utilziar o **Postman**
> Vai disparr uma requisição do tipo **POST** para a URL **http://localhost:8080/login** passando no corpo um **JSON** contendo o email e senha cadastrado no banco de dados, feito em [Configuração](#configuração) tópico 2.
> EX
> ```bash
   > {
   > email:"exemplo@dominio.com"
   > senha:"123456"
   > }
   > ```
> **OBS**
> Os campos login e senha sempre terá esses nomes, pois é como está definido na aplicação! Sómente seus valores serão alterado.
>
> Feito isso você deve receber um token com para liberar as demais requisições **OBS** esse token é valido por 2 horas após a sua criação

#### 3. Listando **Endpoints**

>Podemos pegar a lista de **Endpoints** presente em nossa aplicação acessando a **URL**
>
>http://localhost:8080/swagger-ui/index.html#/
>
>Você vai conseguir encontrar toda a documentação de forma visual sobre os endpoints e o que cada class precisa receber para que tudo possa ocorrer corretamente



# Contato

Para mais informações, entre em contato pelo email: matheus.silva081@icloud.com


## Licença
Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](./LICENSE.md) para mais detalhes.






# Aplicação para cadastro de Aeronaves com documentação Swagger

Para iniciar a aplicação, aconselho executar o arquivo Dockerfile.yml para subir um banco de dados MySql.

## Comando Docker

```bash
docker-compose -f Dockerfile.yml up
```

### Estrutura da tabela do banco de dados da aplicação
O arquivo create-tables.sql contém a estrutura da tabela que a aplicação usa.

### Documentação Swagger
Para acessar a documentação do Swagger entre nesse link quando a aplicação estiver rodando:
[http://localhost:8091/swagger-ui.html](http://localhost:8091/swagger-ui.html)
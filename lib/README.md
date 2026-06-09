# lib/

Coloque aqui os arquivos JAR das dependências externas necessárias para o projeto.

## Dependências necessárias

- **Driver JDBC** para o banco de dados utilizado (ex.: `mysql-connector-j-*.jar` para MySQL,
  `sqlite-jdbc-*.jar` para SQLite, `postgresql-*.jar` para PostgreSQL).

> Os arquivos `.jar` adicionados nesta pasta serão incluídos automaticamente no classpath
> durante a compilação (`ant compile`) e no JAR executável gerado (`ant jar`).

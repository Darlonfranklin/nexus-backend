# Use a imagem oficial do PostgreSQL
FROM postgres:latest

# Copie o script SQL de inicialização para a pasta docker-entrypoint-initdb.d
COPY ../sql/init.sql /docker-entrypoint-initdb.d/

# Exponha a porta padrão do PostgreSQL
EXPOSE 5432

CMD ["postgres", "-p", "5432"]
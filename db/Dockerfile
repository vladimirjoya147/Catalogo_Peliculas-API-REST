FROM mysql:8.0.32

ENV MYSQL_DATABASE=mydatabase
ENV MYSQL_USER=myuser
ENV MYSQL_PASSWORD=mypassword
ENV MYSQL_ROOT_PASSWORD=myrootpassword

EXPOSE 3306

COPY ./docker-entrypoint-initdb.d /docker-entrypoint-initdb.d

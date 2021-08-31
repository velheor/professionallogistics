FROM mysql:latest
COPY ./mysql-data ./var/lib/mysql
ADD ./docker/db/my.cnf ./etc/mysql/my.cnf
ENV MYSQL_ROOT_PASSWORD=password

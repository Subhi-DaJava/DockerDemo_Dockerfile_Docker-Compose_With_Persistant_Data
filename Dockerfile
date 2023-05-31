FROM openjdk:17-alpine
ADD target/docker-demo.jar docker-demo.jar
EXPOSE 9081
ENTRYPOINT ["java", "-jar", "docker-demo.jar"]

# 1. docker build -t docker-demo-30052023 . ( execute current directory Dockerfile)
# 2. docker run -d -p 3308:3306 --name=mysql-docker-demo-container --env="MYSQL_ROOT_PASSWORD=rootPassword" --env="MYSQL_PASSWORD=routPassword" --env="MYSQL_DATABASE=docker_demo_db" mysql ( d- detach mode-running background,
# -p 3308 port container- which port access to outside of container, 3306 mysql port inside container,
# execute current directory Dockerfile, mysql to run, go to MySQL Workbench, create new Connection with new connection name, user routname: and password or
# docker exec -it mysql-docker-demo-container bash -> mysql -uuser-root -proot-password -> get mysql> prompt ->  show databases; -> use docker_demo_db; -> show tables; for exiting enter : mysql> exit; #bash-4.4# exit; #exit)
# 3. docker run -t --link mysql-docker-demo-container:mysql -p 9081:9081 docker-demo-31052023 -> url: jdbc:mysql://mysql-docker-demo-container:3306/docker_demo_db?createDatabaseIfNotExist=true&serverTimezone=UTC

# 3. docker run -t --link mysql-docker-demo-container:mysql --env="MYSQL_HOST=mysql-docker-demo-container" -p 9081:9081 docker-demo-31052023 -> for url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/docker_demo_db?createDatabaseIfNotExist=true&serverTimezone=UTC

# check containers ->  docker container ls

# DockerDemo_Dockerfile_Docker-Compose_With_Persistant_Data
## Docker-Compose
#### Steps:
- docker-compose config
- docker-compose up
- check database
    - docker exec -it 002(container_hashcode) bin/bash  -> bash-4.4# mysql -uroot -p docker_demo_db -> Enter password: *********
    - sql> show databases; -> use docker_demo_db; -> show tables; -> select * from logins; -> Empty set (0.00 sec)
        - -> insert into logins value (1, 'subhi', 'subhi_80'); -> Query OK, 1 row affected (0.01 sec)
#### Show Table
-> select * from logins;
* +----+-------+----------+
* | id | name  | username |
* +----+-------+----------+
* |  1 | subhi | subhi_80 |
* +----+-------+----------+
#### Exit form Database
-  exit; -> Bye
-   #bash-4.4# -> exit;
#### Connect database with MySQL Workbench 
- Create new MySQL Server Connection 
- Set up new Server Connection, Refer to the example image below for guidance:
![new_mysql_server_connection_image](https://github.com/Subhi-DaJava/DockerDemo_Dockerfile_Docker-Compose_With_Persistant_Data/assets/90509456/a2fd572c-b788-4de3-b775-f87ee1cf2fcc)

#### Some Commands
- docker-compose kill -> stop containers
- docker-compose down  -> remove containers
- docker-compose down -v -> remove containers and remove volumes(data)

## Dockerfile
1. docker build -t docker-demo-31052023 . ( execute current directory Dockerfile)
2. docker run -d -p 3308:3306 --name=mysql-docker-demo-container --env="MYSQL_ROOT_PASSWORD=rootPassword" --env="MYSQL_PASSWORD=routPassword" --env="MYSQL_DATABASE=docker_demo_db" mysql ( d- detach mode-running background,
3. docker run -t --link mysql-docker-demo-container:mysql -p 9081:9081 docker-demo-31052023 -> url: jdbc:mysql://mysql-docker-demo-container:3306/docker_demo_db?createDatabaseIfNotExist=true&serverTimezone=UTC
3. docker run -t --link mysql-docker-demo-container:mysql --env="MYSQL_HOST=mysql-docker-demo-container" -p 9081:9081 docker-demo-31052023 -> for url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/docker_demo_db?createDatabaseIfNotExist=true&serverTimezone=UTC

#### Some Commands
- check containers -> docker container ls
- check imagaes -> docker images
- remove imgaes -> docker rmi imgae_hash_code
#### Explication
- -p 3308 port container- which port access to outside of container, 3306 mysql port inside container,
- execute current directory Dockerfile, mysql to run, go to MySQL Workbench, create new Connection with new connection name, user routname: and password or
- docker exec -it mysql-docker-demo-container bash -> mysql -uuser-root -proot-password -> get mysql> prompt ->  show databases; -> use docker_demo_db; -> show tables; for exiting enter : mysql> exit; #bash-4.4# exit; #exit)

# Nofluffcars - backend & db

< description obviously >

## Running with Docker

### Create network for backend and database containers
```
docker network create nofluffcars-network
```
### Create database container (data folder)
```
docker image build -t nofluffcars_db_image .
docker container run -d --network nofluffcars-network --name nofluffcars_db nofluffcars_db_image
docker container exec -it nofluffcars_db bash
mysql -uroot -proot < 202108252300_nfc_db_backup.sql;
```
### Create backend container
```
docker image build -t nofluffcars_backend_image .
docker container run -p 8081:8081 --network nofluffcars-network --name nofluffcars_backend nofluffcars_backend_image
```

### Usefull commands
```
mvnw clean package
source 202106131900_nfc_db_backup.sql;
docker pull mysql
docker network ls
docker network rm <network>
docker exec -i nofluffcars-db  mysql -uroot -proot nofluffcars < data/202106131900_nfc_db_backup.sql
```

## Todo
1. move manually added database creation from sql dump file to
an env param in mysql dockerfile
   
2. database persistence in docker

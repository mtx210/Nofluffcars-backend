<pre>
 __    _           ___  _             ___   ___    _____
|  \  | |         / _/ | |           / _/  / _/   / ___/     by Max U
|   \ | |   ___  | |_  | |   _   _  | |_  | |_   | |       ___    ___  _____
| |\ \  |  /   \ | _|  | |  | | | | | _|  | _|   | |      / _ \  |  / |  __/
| | \   | | [] | | |   | |_ | |_| | | |   | |    | |____ | /_\ | | |  |__  |
|_|  \__|  \___/ |_|    \__| \____| |_|   |_|     \____/ |_| |_| |_|  \____|
</pre>

# Nofluffcars - backend & database
< description, maybe one day >

## 1. Running .jar in commandline (change param values if needed)
```
mvnw clean package
cd target
java -Ddbhost=localhost -Ddbport=3306 -Ddbname=nofluffcars_data -jar nofluffcars-0.0.1-SNAPSHOT.jar
```

## 2. Running with Docker
### 2.1 Docker deployment speedrun xD 
```
cd data
docker-deploy-db.bat
cd ..
docker-deploy-backend.bat
```
### 2.2 Docker deployment in details (no speedrun xD)
#### 2.2.1 Create network for backend and database containers
```
docker network create nofluffcars-network
```
#### 2.2.2 Create database container (data folder)
```
docker image build -t nofluffcars_db_image .
docker container run -d --network nofluffcars-network --name nofluffcars_db nofluffcars_db_image
docker container exec -it nofluffcars_db bash
mysql -uroot -proot < 202108252300_nfc_db_backup.sql;
```
#### 2.2.3 Create backend container
```
mvnw clean package
docker image build -t nofluffcars_backend_image .
docker container run -p 8081:8081 --network nofluffcars-network --name nofluffcars_backend nofluffcars_backend_image
```



## 4. Usefull commands
```
mvnw clean package
source 202106131900_nfc_db_backup.sql;
docker pull mysql
docker network ls
docker network rm <network>
docker exec -i nofluffcars-db  mysql -uroot -proot nofluffcars < data/202106131900_nfc_db_backup.sql
```

## 5. Todo
- move manually added database creation from sql dump file to
an env param in mysql dockerfile
   
- database persistence in docker

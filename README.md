<pre>
 __    _           ___  _             ___   ___    _____
|  \  | |         / _/ | |           / _/  / _/   / ___/     by Max U
|   \ | |   ___  | |_  | |   _   _  | |_  | |_   | |       ___    ___  _____
| |\ \  |  /   \ | _|  | |  | | | | | _|  | _|   | |      / _ \  |  / |  __/
| | \   | | [] | | |   | |_ | |_| | | |   | |    | |____ | /_\ | | |  |__  |
|_|  \__|  \___/ |_|    \__| \____| |_|   |_|     \____/ |_| |_| |_|  \____|
</pre>

# Nofluffcars - backend & database
One day, Nofluffcars will be a light and fully-functioning car trading service for
car enthusiasts from Poland. Something like otomoto but with few things done better 
(in my opinion) like better price and financing filtering options as well as more 
detailed listing descriptions.

For now, it only serves as a free-time learning project, I don't spent much time on it,
because I have a lot of hobbies other than programming, and I get a fair share of 
programming at work which I, believe it or not, actually enjoy.

I developed this using MySQL database locally.

## 1. Running in IntelliJ IDE
Don't forget to add these VM options to Run configuration, modify values if needed
```
-Ddbhost=localhost -Ddbport=3306
```

## 2. Building and running .jar in terminal
Of course also modify values if needed
```
mvnw clean package
cd target
java -Ddbhost=localhost -Ddbport=3306 -jar nofluffcars-0.0.1-SNAPSHOT.jar
```

## 3. Running with Docker
### 3.1 Docker deployment speedrun xD 
```
cd data
docker-deploy-db.bat
cd ..
docker-deploy-backend.bat
```
### 3.2 Docker deployment in details (no speedrun xD)
#### 3.2.1 Create network for backend and database containers
```
docker network create nofluffcars-network
```
#### 3.2.2 Create database container (data folder)
```
docker image build -t nofluffcars_db_image .
docker container run -d --network nofluffcars-network --name nofluffcars_db nofluffcars_db_image
docker container exec -it nofluffcars_db bash
mysql -uroot -proot < 202108252300_nfc_db_backup.sql;
```
#### 3.2.3 Create backend container
```
mvnw clean package
docker image build -t nofluffcars_backend_image .
docker container run -p 8081:8081 --network nofluffcars-network --name nofluffcars_backend nofluffcars_backend_image
```



## 4. Usefull commands
```
source 202106131900_nfc_db_backup.sql;
docker pull mysql
docker network ls
docker network rm <network>
docker exec -i nofluffcars-db  mysql -uroot -proot nofluffcars < data/202106131900_nfc_db_backup.sql
```

## 5. Todo
Develop the project I guess...
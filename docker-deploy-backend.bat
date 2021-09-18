@echo off
echo "__    _           ___  _             ___   ___    _____"
echo "|  \  | |         / _/ | |           / _/  / _/   / ___/     by Max U"
echo "|   \ | |   ___  | |_  | |   _   _  | |_  | |_   | |       ___    ___  _____"
echo "| |\ \  |  /   \ | _|  | |  | | | | | _|  | _|   | |      / _ \  |  / |  __/"
echo "| | \   | | [] | | |   | |_ | |_| | | |   | |    | |____ | /_\ | | |  |__  |"
echo "|_|  \__|  \___/ |_|    \__| \____| |_|   |_|     \____/ |_| |_| |_|  \____|"
echo
echo === =================================
echo === Building backend
echo === (1/5) cleaning jar
echo === =================================
call mvnw clean


echo === =================================
echo === Building backend
echo === (2/5) building jar
echo === =================================
call mvnw package


echo === =================================
echo === Building backend
echo === (3/5) clearing image and container
echo === =================================
call docker stop nofluffcars_backend
call docker rm nofluffcars_backend
call docker image rm nofluffcars_backend_image


echo === =================================
echo === Building backend
echo === (4/5) building image
echo === =================================
call docker image build -t nofluffcars_backend_image .


echo === =================================
echo === Building backend
echo === (5/5) starting container
echo === =================================
call docker container run -d -p 8081:8081 --network nofluffcars-network --name nofluffcars_backend nofluffcars_backend_image
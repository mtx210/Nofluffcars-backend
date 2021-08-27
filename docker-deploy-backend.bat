@echo off
echo #   #  ####  ####
echo ##  #  #     #
echo # # #  ###   #
echo #  ##  #     #
echo #   #  #     #### by Max U
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
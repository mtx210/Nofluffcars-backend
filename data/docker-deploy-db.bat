@echo off
echo #   #  ####  ####
echo ##  #  #     #
echo # # #  ###   #
echo #  ##  #     #
echo #   #  #     #### by Max U
echo
echo === =================================
echo === Building database
echo === (1/3) clearing image and container
echo === =================================
call docker stop nofluffcars_db
call docker rm nofluffcars_db
call docker image rm nofluffcars_db_image


echo === =================================
echo === Building database
echo === (2/3) building image
echo === =================================
call docker image build -t nofluffcars_db_image .


echo === =================================
echo === Building database
echo === (3/3) starting container
echo === =================================
call docker container run -d --network nofluffcars-network --name nofluffcars_db nofluffcars_db_image
@echo off
echo #   #  ####  ####
echo ##  #  #     #
echo # # #  ###   #
echo #  ##  #     #
echo #   #  #     #### by Max U
echo
echo === =================================
echo === Building database
echo === (1/4) clearing image and container
echo === =================================
call docker stop nofluffcars_db
call docker rm nofluffcars_db
call docker image rm nofluffcars_db_image


echo === =================================
echo === Building database
echo === (2/4) building image
echo === =================================
call docker image build -t nofluffcars_db_image .


echo === =================================
echo === Building database
echo === (3/4) starting container
echo === =================================
call docker container run -d --network nofluffcars-network --name nofluffcars_db nofluffcars_db_image
@echo off
echo Cleaning and installing the project...
call mvnw.cmd clean install

echo.
echo Starting the application using spring-boot:run...
call mvnw.cmd spring-boot:run
@echo off
echo Cleaning and packaging the project...
call mvnw.cmd clean package

echo.
echo Running the packaged JAR...
for /f %%i in ('dir /b target\*.jar') do (
    java -jar target\%%i
    goto :eof
)

echo No JAR file found in target folder.

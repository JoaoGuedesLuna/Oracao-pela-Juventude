@echo off

:: Change to the source directory (one level up from current directory)
cd %cd%
cd ..\src

:: Inform the user that the program is waiting for the compilation to complete
echo -- Aguardando a compilação do programa -- 

:: Delete any existing compiled .class files in the source directory to ensure a clean compilation
del /s *.class

:: Compile the Java application. This step compiles the main Java class.
javac -encoding UTF-8 main\java\dev\guedes\oracaopelajuventude\OracaoPelaJuventudeApplication.java

:start
:: Clear the screen to prepare for user input
cls

:: Prompt user to input participant names separated by commas
echo Por favor, digite os nomes dos participantes separados por vírgula (sem aspas). Aspas duplas serão ignoradas.
echo Nomes repetidos serão considerados apenas uma vez.
echo Exemplo: Alexsandra, Cassiane, Ely, João, Joyce, Lucas, Marcone, Mihay.
echo.

:: Get participant names from user input and store it in the 'participantNames' variable
set /p participantNames="Nome dos participantes: "

:: If user entered names, remove any double quotes
if defined participantNames (
    :: Remove double quotes from the participant names if any were entered
	set participantNames=%participantNames:"=%
)

:: Clear the screen again before running the application
cls

:: Run the Java application with the participant names passed as a command-line argument
java -Dfile.encoding=UTF-8 main.java.dev.guedes.oracaopelajuventude.OracaoPelaJuventudeApplication "%participantNames%"

: Ask the user if they want to run the script again. If "S" or "s" is entered, the script will restart
set /p userChoice="Deseja executar novamente? (S/N): "

:: If the user inputs "S" or "s", restart the script by going back to the 'start' label
if /i "%userChoice%"=="S" (
	set participantNames=
	set userChoice=
	goto start
)
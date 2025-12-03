@echo off
echo ==========================================
echo      Gas Pump Automation - Build & Run
echo ==========================================

if not exist "bin" mkdir bin

echo.
echo Compiling source code...
javac -cp bin -d bin src/abstractFactory/*.java src/abstractFactory/impl/*.java src/data/*.java src/data/impl/*.java src/gasPump/*.java src/mda/*.java src/outputProcessor/*.java src/states/*.java src/states/concreteStates/*.java src/strategy/*.java src/strategy/impl/*.java src/*.java

if %errorlevel% neq 0 (
    echo Compilation Failed!
    pause
    exit /b %errorlevel%
)

echo Compilation Successful!
echo.
echo Select Execution Mode:
echo 1. Run Interactive Demo (App.java)
echo 2. Run Automated Test Cases (TestDriver.java)
echo.
set /p choice="Enter choice (1 or 2): "

if "%choice%"=="1" (
    echo.
    echo Running Interactive App...
    java -cp bin App
) else if "%choice%"=="2" (
    echo.
    echo Running Automated Tests...
    java -cp bin TestDriver
) else (
    echo Invalid choice.
)

pause

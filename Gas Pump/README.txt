CS 586 - Gas Pump Automation Project
Fall 2025

===============================================================================
INSTRUCTIONS TO RUN THE PROGRAM
===============================================================================

PREREQUISITES:
- Java Development Kit (JDK) installed and added to system PATH.
- Windows OS (for run.bat) or any terminal for manual commands.

-------------------------------------------------------------------------------
OPTION 1: AUTOMATED EXECUTION (Windows Only)
-------------------------------------------------------------------------------
1. Double-click the `run.bat` file located in the root directory.
2. The script will automatically compile all source files.
3. You will be prompted to select a mode:
   - Type '1' to run the Interactive Demo (`App.java`).
   - Type '2' to run the Automated Test Cases (`TestDriver.java`).

-------------------------------------------------------------------------------
OPTION 2: MANUAL COMPILATION & EXECUTION (Command Line)
-------------------------------------------------------------------------------
1. Open a terminal/command prompt in the project root directory (where `src` is).
2. Create a `bin` directory if it doesn't exist:
   mkdir bin

3. Compile the source code:
   javac -cp bin -d bin src/abstractFactory/*.java src/abstractFactory/impl/*.java src/data/*.java src/data/impl/*.java src/gasPump/*.java src/mda/*.java src/outputProcessor/*.java src/states/*.java src/states/concreteStates/*.java src/strategy/*.java src/strategy/impl/*.java src/*.java

4. Run the Interactive Demo:
   java -cp bin App

5. Run the Automated Test Cases:
   java -cp bin TestDriver

===============================================================================
FILE STRUCTURE
===============================================================================
src/
  App.java           - Main interactive driver
  TestDriver.java    - Automated test driver for specific scenarios
  gasPump/           - Input Processors (GasPump1, GasPump2)
  mda/               - State Machine (MDAEFSM)
  states/            - State Pattern (State, Concrete States)
  strategy/          - Strategy Pattern (Output Strategies)
  data/              - Data Store (DS1, DS2)
  abstractFactory/   - Abstract Factory Pattern
  outputProcessor/   - Output Processor

===============================================================================
NOTES
===============================================================================
- The `TestDriver` executes the 10 specific test cases outlined in the assignment.
- The `App` allows you to manually trigger events via a menu system.

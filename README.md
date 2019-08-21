# PlivoTestProject
Plivo UI Test Project

PreSetup 
JDK 8 or above
Any IDE preferrably Intellij

Project Structure:
1. A Base class which contain the intial set up of browser and related set up like the OS, browser etc.
2. Pages class which uses page object model to intialize the Webelements of all the pages
3. Properties class where all the test related contants are stored
4. Tests class which consistes of our actual tests
5. Resources file which has the drivers to run the UI tests
6. testng.xml file

To run the tests execute below command from your project location in your terminal:
mvn test -DsuiteFile=testng.xml
 or it can be run directly from IDE as well
 
 NOTE : connector part is still pending. Facing some issues while dragging it and will upload as soon as am done with solution
 
 

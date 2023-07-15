1. Java Dependencies: All the Java files will share the same Java dependencies such as javax.swing for creating JFrame, java.awt for adding components to the JFrame, java.sql for database connectivity, and java.util for using ArrayLists and other utility classes.

2. User Class: The User class will be shared across the LoginScreen.java and App.java files. This class will contain user information such as username and password.

3. Bus Class: The Bus class will be shared across the BusInfoScreen.java and App.java files. This class will contain bus information such as bus number and its route.

4. Route Class: The Route class will be shared across the Bus.java and BusInfoScreen.java files. This class will contain route information such as start point, end point, and stops in between.

5. LoginScreen.fxml: This FXML file will be used in LoginScreen.java for creating the user interface of the login screen. It will contain id names of DOM elements such as "usernameField", "passwordField", and "loginButton".

6. BusInfoScreen.fxml: This FXML file will be used in BusInfoScreen.java for creating the user interface of the bus information screen. It will contain id names of DOM elements such as "busNumberLabel", "routeLabel", and "logoutButton".

7. Database Connection: A shared database connection will be used across all the Java files for storing and retrieving user, bus, and route information.

8. Function Names: Shared function names across the files could include "login", "logout", "displayBusInfo", "getBusInfo", "getRouteInfo", etc.

9. Message Names: Shared message names across the files could include "loginSuccess", "loginFailure", "busInfo", "routeInfo", etc.
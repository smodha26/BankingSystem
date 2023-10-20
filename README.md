# Banking System Platform

## Project configuration and usage

To run the Banking Platform application:

1. Make sure you have Java Development Kit (JDK) installed on your system. 
2. Build the project, choose a SDK and compile the Java source files.
3. Execute the main class (`Main.java`) to start the application.
4. Please use the following login authentication information: `Username: Bob` | `Password: test`

## Project Description

The Banking Platform is a Java-based application that simulates a basic banking system. It allows users to interact with their bank accounts by making deposits and withdrawals.

### Login Authentication & Test Account

To facilitate easy usage and testing of the application, a test account is provided within the project. This account serves as a demonstration of the application's functionality in the absence of a database. The test account details are as follows:

- Username: "Bob"
- Password: "test"

Please use these credentials for a successful login.

## Design Patterns

### Singleton

The project utilizes the Singleton design pattern through the `CurrentUserSingleton` class. This design pattern ensures that there is only one instance of the `CurrentUserSingleton` class throughout the application. The `CurrentUserSingleton` is responsible for managing the current individual's instance, providing a global point of access to the current user's data.

### Model-View-Controller (MVC)

The project follows the Model-View-Controller (MVC) architectural pattern. This separation of concerns helps maintain a clear distinction between different aspects of the application:

- **Model**: Represented by the `Bank` and the `Individual` class, it encapsulates the data and business logic, including user account details and balance.

- **View**: Implemented in the `LoginUI` and the `BankingPlatformUI` class, it provides the user interface for interacting with the application.

- **Controller**: The application logic is separated into controller classes (`LoginController` and `BankingPlatformController`), responsible for handling user authentication, banking operations, and interactions between the model and view.

## Project Structure

The project is organized with a separation of concerns between the user interface (UI) and the application logic:

### User Interface (UI)

- The user interface is implemented in the `LoginUI` and the `BankingPlatformUI` class.
- `BankingPlatformUI` provides a graphical user interface for users to view their current balance, enter deposit or withdrawal amounts, and perform banking operations.
- The UI elements are designed using Java Swing components.

### Application Logic

- The application logic is implemented in separate controller classes.
- The `LoginController` class handles user authentication and login-related functionality.
- The `BankingPlatformController` class manages banking operations, such as deposits and withdrawals.
- The `Individual` class represents individual user data, including username, password, and balance.
- The `CurrentUserSingleton` class manages the current user's instance using the Singleton pattern.

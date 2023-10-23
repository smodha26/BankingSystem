# Banking System Project

## Project configuration and usage

To run the Banking Platform application:

1. Execute the main method from (`AppLauncher.java`) class to start the application.
2. For authentication, you can use the test users provided in `the user_accounts.json` file. Alternatively, you can sign up to create your own account, and your information will be stored in the same file.

Note : Before working with the project, make sure to have JDK installed, setup your SDK, and use 'mvn clean install' to download all necessary dependencies with Maven.

## Project Description

The Banking Platform is a Java-based application that simulates a basic banking system. It allows users to interact with their bank accounts by making deposits and withdrawals while providing a transaction history to track their financial activity and view their current balance. The project utilizes the Jackson library for JSON data processing and employs Maven for efficient dependencies management. Furthermore, the application uses a JSON file as its database to store user account credentials securely. Users also have the option to create an account, ensuring that the chosen username is unique and doesn't already exist in the system.

### Login Authentication & Test Accounts

To facilitate easy usage and testing of the application, test accounts are already provided within the file `user_accounts.json`. 

You can also Signup and create a new account.

## Design Patterns

### Singleton

The project utilizes the Singleton design pattern through the `CurrentUserSingleton` class. This design pattern ensures that there is only one instance of the `CurrentUserSingleton` class throughout the application. The `CurrentUserSingleton` is responsible for managing the current individual's instance, providing a global point of access to the current user's data.

### Model-View-Controller (MVC)

The project follows the Model-View-Controller (MVC) architectural pattern. This separation of concerns helps maintain a clear distinction between different aspects of the application:

- **Model**: Represented by the `User` class, it encapsulates user data, including user account details such as balance, username, and password. The `JsonDataManager` class utilizes the Jackson library to manage the logic for the JSON file database logic.

- **View**: Implemented in the `LoginUI`, `CreateAccountUI` and the `BankingPlatformUI` class, it provides the user interface for interacting with the application.

- **Controller**: The application logic is separated into controller classes (`LoginController`, `CreateAccountController`  and `BankingPlatformController`), responsible for handling user authentication, signup, banking operations, and interactions between the model and view.

### Database

To simplify this project, the application uses a JSON file, `user_accounts.json` as a database to store the usernames and passwords of every user created. This data management is facilitated by the `JsonDataManager` class, which relies on the Jackson library. The Jackson library is configured in the project's pom.xml file using Maven for dependencies management.

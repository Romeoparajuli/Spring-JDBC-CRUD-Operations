

---

# SpringBoot JDBC CRUD Operations

This repository demonstrates how to implement CRUD (Create, Read, Update, Delete) operations using **Spring Boot** and **JDBC Template**. It is designed as a reference project for understanding and implementing database interactions with proper error handling, logging, and reusable code.

## Features

- **CRUD Operations**: Complete implementation of create, read, update, and delete functionality.
- **Spring Boot Integration**: Leveraging Spring Boot’s ecosystem for rapid application development.
- **JDBC Template**: Simplified database interaction with minimal boilerplate.
- **Model-Driven Design**: Encapsulation of data using `User` model.
- **Industry Standards**: Adherence to clean code principles and best practices.
- **Comments & Documentation**: Comprehensive in-line comments for better code readability.

## Technologies Used

- **Spring Boot**: Framework for application setup and management.
- **Spring JDBC**: For efficient database access and query execution.
- **MySQL**: Relational database management system.
- **Java 17**: Recommended JDK for the project.

## Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Maven 3.8 or higher
- MySQL Server
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/spring-jdbc-crud-operations.git
cd spring-jdbc-crud-operations
```

### 2. Configure the Database

Create a MySQL database named `springBootJdbc` and update the credentials in the `application.properties` file located in the `src/main/resources` directory:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springBootJdbc
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### 3. Build the Project

Use Maven to build the project:

```bash
mvn clean install
```

### 4. Run the Application

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.


## Folder Structure

```plaintext
src
├── main
│   ├── java
│   │   └── com.romeocoder.main
│   │       ├── Application.java   # Main entry point
│   │       ├── Model
│   │       │   └── User.java      # User entity
│   │       ├── Dao
│   │       │   └── UserDao.java   # DAO layer for database operations
│   ├── resources
│       ├── application.properties # Application configuration
```

---



## Code Structure

- **`com.romeocoder.main`**: Root package containing the main class.
  - **`Dao`**: Data Access Layer for interacting with the database.
  - **`Model`**: Contains the `User` class representing the database entity.
- **Database Table Schema**:
  ```sql
  CREATE TABLE users (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100),
      age INT,
      address VARCHAR(255),
      gender VARCHAR(10)
  );
  ```

## Usage

### Insert a User

Modify the `Application` class to insert a user:

```java
User user = new User("John Doe", 25, "New York", "Male");
boolean isInserted = userDao.insertUser(user);
```

### Update a User

```java
User user = new User("John Doe", 26, "Los Angeles", "Male");
boolean isUpdated = userDao.updateUsers(user);
```

### Delete a User

```java
boolean isDeleted = userDao.DeletUSer("John Doe");
```

### Fetch a User

```java
User user = userDao.getUserByName("John Doe");
```

## Contributing

Contributions are welcome! Follow these steps to contribute:

1. Fork the repository.
2. Create a new feature branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m "Add feature"`.
4. Push to the branch: `git push origin feature-name`.
5. Submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

---

package com.romeocoder.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.romeocoder.main.Dao.UserDao;
import com.romeocoder.main.Model.User;

/**
 * Main Application class that bootstraps the Spring Boot application.
 * Implements CommandLineRunner to execute specific operations after the application context is loaded.
 * This class demonstrates CRUD operations on the User entity using UserDao.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    // Injecting the UserDao bean for database interaction.
    @Autowired
    private UserDao userDao;

    /**
     * Entry point of the Spring Boot application.
     * Initializes the application and loads the Spring context.
     * 
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Executes after the Spring Boot application context is initialized.
     * Demonstrates CRUD operations using UserDao.
     * 
     * @param args Command-line arguments passed during runtime.
     * @throws Exception if an error occurs during execution.
     */
    @Override
    public void run(String... args) throws Exception {

        // ------------------ Insert Operation ------------------
        // Step 1: Create a new User object with the required data.
        User userToInsert = new User("Milan Parajuli", 41, "Palpa", "Male");

        // Step 2: Call the insertUser method of UserDao to save the user in the database.
        boolean isInserted = userDao.insertUser(userToInsert);

        // Step 3: Log the result of the operation.
        if (isInserted) {
            System.err.println("User inserted successfully!");
        } else {
            System.err.println("User insertion failed.");
        }

        // ------------------ Update Operation ------------------
        // Step 1: Create a new User object with updated details.
        User userToUpdate = new User("Milan Parajuli", 41, "Palpa", "Female");

        // Step 2: Call the updateUsers method of UserDao to update the user in the database.
        boolean isUpdated = userDao.updateUsers(userToUpdate);

        // Step 3: Log the result of the update operation.
        if (isUpdated) {
            System.err.println("User updated successfully.");
        } else {
            System.err.println("User update failed.");
        }

        // ------------------ Update by Fetching User ------------------
        // Step 1: Fetch an existing user by their name using getUserByName method.
        User fetchedUser = userDao.getUserByName("Milan Parajuli");

        // Step 2: Check if the user exists before making updates.
        if (fetchedUser != null) {
            // Step 3: Update the address field of the fetched user.
            fetchedUser.setAddress("Dang");

            // Step 4: Call the updateUsers method to save the changes.
            boolean isFetchedUserUpdated = userDao.updateUsers(fetchedUser);

            // Step 5: Log the result of the update operation.
            if (isFetchedUserUpdated) {
                System.err.println("Fetched user updated successfully.");
            } else {
                System.err.println("Fetched user update failed.");
            }
        } else {
            System.err.println("User not found for fetching.");
        }

        // ------------------ Delete Operation ------------------
        // Step 1: Call the DeletUSer method of UserDao with the user's name to delete them.
        boolean isDeleted = userDao.DeletUSer("Milan Parajuli");

        // Step 2: Log the result of the delete operation.
        if (isDeleted) {
            System.err.println("User deleted successfully.");
        } else {
            System.err.println("User deletion failed.");
        }

        // ------------------ Select Operation ------------------
        // Step 1: Fetch an existing user by their name using getUserByName method.
        User selectedUser = userDao.getUserByName("Milan Parajuli");

        // Step 2: Check if the user exists before accessing their details.
        if (selectedUser != null) {
            // Step 3: Display the details of the fetched user.
            System.err.println("User Details:");
            System.err.println("Name: " + selectedUser.getName());
            System.err.println("Age: " + selectedUser.getAge());
            System.err.println("Address: " + selectedUser.getAddress());
            System.err.println("Gender: " + selectedUser.getGender());
        } else {
            System.err.println("User not found during selection.");
        }
    }
}

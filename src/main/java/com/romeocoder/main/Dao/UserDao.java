package com.romeocoder.main.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.romeocoder.main.Model.User;

/**
 * Data Access Object (DAO) for managing CRUD operations on User entities.
 * This class interacts with the database using Spring's JdbcTemplate.
 */
@Repository
public class UserDao {

    // JdbcTemplate is injected by Spring to handle database operations.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Inserts a new User into the database.
     * 
     * @param user The User object containing data to be inserted.
     * @return true if the user is successfully inserted, false otherwise.
     */
    public boolean insertUser(User user) {
        boolean status = false;

        try {
            // SQL query to insert a new record into the users table.
            String insertString = "INSERT INTO users(name, age, address, gender) VALUES(?, ?, ?, ?)";

            // Execute the query with parameters from the User object.
            int rowsAffected = jdbcTemplate.update(insertString, 
                user.getName(), 
                user.getAge(), 
                user.getAddress(), 
                user.getGender()
            );

            // If rows are affected, insertion was successful.
            status = rowsAffected > 0;

        } catch (Exception e) {
            // Log the exception for debugging purposes.
            status = false;
            e.printStackTrace();
        }

        return status;
    }

    /**
     * Updates an existing User's details in the database.
     * 
     * @param user The User object containing updated data.
     * @return true if the update is successful, false otherwise.
     */
    public boolean updateUsers(User user) {
        boolean status = false;

        try {
            // SQL query to update an existing user based on their name.
            String sqlString = "UPDATE users SET name=?, gender=?, address=?, age=? WHERE name=?";

            // Execute the query with parameters from the User object.
            int rowsAffected = jdbcTemplate.update(sqlString, 
                user.getName(), 
                user.getGender(), 
                user.getAddress(), 
                user.getAge(), 
                user.getName()
            );

            // If rows are affected, update was successful.
            status = rowsAffected > 0;

        } catch (Exception e) {
            // Log the exception for debugging purposes.
            status = false;
            e.printStackTrace();
        }

        return status;
    }

    /**
     * Deletes a User from the database based on their name.
     * 
     * @param name The name of the User to delete.
     * @return true if the user is successfully deleted, false otherwise.
     */
    public boolean DeletUSer(String name) {
        boolean status = false;

        try {
            // SQL query to delete a user by their name.
            String sqlString = "DELETE FROM users WHERE name=?";

            // Execute the delete query.
            int rowsAffected = jdbcTemplate.update(sqlString, name);

            // If rows are affected, deletion was successful.
            status = rowsAffected > 0;

        } catch (Exception e) {
            // Log the exception for debugging purposes.
            status = false;
            e.printStackTrace();
        }

        return status;
    }

    /**
     * Retrieves a User from the database based on their name.
     * 
     * @param name The name of the User to fetch.
     * @return The User object if found, or null if no such user exists.
     */
    public User getUserByName(String name) {
        try {
            // SQL query to select a user by their name.
            String sql = "SELECT * FROM users WHERE name=?";

            // Execute the query and map the result to a User object.
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), name);
        } catch (Exception e) {
            // Return null if an exception occurs (e.g., user not found).
            e.printStackTrace();
            return null;
        }
    }

    /**
     * RowMapper implementation to map database result rows to User objects.
     */
    public static final class UserRowMapper implements RowMapper<User> {

        /**
         * Maps a single row of the ResultSet to a User object.
         * 
         * @param rs     The ResultSet containing user data.
         * @param rowNum The number of the current row being processed.
         * @return A User object populated with data from the current row.
         * @throws SQLException if an error occurs while accessing the ResultSet.
         */
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            // Create a new User object and populate it with data from the ResultSet.
            User user = new User();
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setAddress(rs.getString("address"));
            user.setGender(rs.getString("gender"));

            return user;
        }
    }
}

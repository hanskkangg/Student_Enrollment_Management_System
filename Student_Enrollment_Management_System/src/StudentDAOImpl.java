/**
 * File Name: StudentDAOImple. java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description: this is an implements the StudentDAO interface for performing database operations for students.
 * This class handles the addition of student records to the database.
 * 
 * @author Hans Kang
 * @version 17.0.7
 * @since javaSE-17
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StudentDAOImpl implements StudentDAO {
    private Connection connection;

    /**
     * Constructs a new StudentDAOImpl with a database connection.
     * 
     * @param connection The database connection to use for operations.
     */
    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Adds a new student to the database.
     * 
     * @param student The student to add.
     * @return true if the addition was successful, false otherwise.
     */
    @Override
    public boolean insertStudent (Student student) {
    	
    	// This is a SQL query to insert a new student record
        String sql = "INSERT INTO Student (studentId, firstName, lastName) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	// Setting parameters for the insert operation
            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
           
            // Execute the insert operation and check the result
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
        	//return false if there was a SQL error during insert
            System.err.println("Insert failed: " + e.getMessage());
            return false;
        }
    }
}

/**
 * File Name: StudentCourseDAOImpl. java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description:  This class is an implementation of the StudentCourseDAO interface for database operations related to student-course associations.
 * This class handles adding records of student-course associations to the database
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentCourseDAOImpl implements StudentCourseDAO {
    private Connection connection;

    /**
     * Constructs a new StudentCourseDAOImpl with a database connection.
     * 
     * @param connection The database connection to use for operations.
     */
    public StudentCourseDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * Adds a new student-course association to the database.
     * 
     * @param studentCourse The student-course association to add.
     * @return true if the addition was successful, false otherwise.
     */
    @Override
    public boolean insertStudentCourse(StudentCourse studentCourse) {
    	
    	// this is a SQL query to insert a new student-course record
        String sql = "INSERT INTO StudentCourse (studentId, courseId, term, year) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	//setting parameter for the insert operation
            statement.setInt(1, studentCourse.getStudentId());
            statement.setString(2, studentCourse.getCourseId());
            statement.setInt(3, studentCourse.getTerm());
            statement.setInt(4, studentCourse.getYear());
            
            // Execute the insert operation and check the result
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
            
            // return false if there was a SQL error during insert
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
            return false;
        }
    }
}

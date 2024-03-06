/**
 * File Name: App.java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description: This class manages the process of importing student and course data from a CSV file into a database.
 * @author Hans Kang
 * @version 17.0.7
 * @since javaSE-17
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class App {
	

    public static void main(String[] args) {
        Properties dbProperties = new Properties();
        String dbPropertiesPath = "C:\\CST8116 Homework\\CST Eclipse Workspace\\lab2\\src\\database.properties";
        String csvPath = "C:\\CST8116 Homework\\CST Eclipse Workspace\\lab2\\src\\bulk-import.csv";

        // Load database properties
        try (FileInputStream in = new FileInputStream(dbPropertiesPath)) {
            dbProperties.load(in);
        } catch (IOException e) {
            System.out.println("Failed to load the database properties.");
            e.printStackTrace();
            return;
        }

        // Process CSV file and update database
        try (Connection connection = DbConnection.getConnection(
                dbProperties.getProperty("jdbc.url"),
                dbProperties.getProperty("jdbc.username"),
                dbProperties.getProperty("jdbc.password"));
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvPath)))) {

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (DbValidation.isValidDataLine(line)) {
                    String[] parts = line.split(",");
                    processLine(parts, connection);
                } else {
                    System.out.println("Entry was NOT Successful! Invalid data: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read the CSV file.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("A database error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
    
    /**This method takes a line from a CSV file, extracts information about students and courses, and then adds this information to the database.
     * @param parts Array of strings from the CSV line, with student and course details.
     * @param connection Database connection to use for adding the data.
     */
    private static void processLine(String[] parts, Connection connection) {
        int studentId = Integer.parseInt(parts[0].trim());
        String firstName = parts[1].trim();
        String lastName = parts[2].trim();
        String courseId = parts[3].trim();
        String courseName = parts[4].trim();
        int term = DbValidation.convertTerm(parts[5].trim());
        int year = Integer.parseInt(parts[6].trim());

        Student student = new Student(studentId, firstName, lastName);
        Course course = new Course(courseId, courseName);
        StudentCourse studentCourse = new StudentCourse(studentId, courseId, term, year);

        StudentDAO studentDao = new StudentDAOImpl(connection);
        CourseDAO courseDao = new CourseDAOImpl(connection);
        StudentCourseDAO studentCourseDao = new StudentCourseDAOImpl(connection);

        if (studentDao.insertStudent(student)) {
            System.out.println("Entry Successful! Inserted student: " + studentId);
        }

        if (courseDao.insertCourse(course)) {
            System.out.println("Entry Successful! Inserted course: " + courseId);
        }

        if (studentCourseDao.insertStudentCourse(studentCourse)) {
            System.out.println("Entry Successful!  Inserted student-course association for student: " + studentId + " and course: " + courseId);
        }
    }
}

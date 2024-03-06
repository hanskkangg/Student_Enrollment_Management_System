import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentCourseDAOImplTest {

    private StudentCourseDAOImpl studentCourseDao;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize database
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "", "");
        // Create table for the test
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS StudentCourse (studentId INT, courseId VARCHAR(255), term INT, year INT)");

        // Initialize the DAO with database connection
        studentCourseDao = new StudentCourseDAOImpl(connection);
    }

    @Test
    public void testInsertStudentCourse() throws Exception {
        // Given a student course instance
        StudentCourse studentCourse = new StudentCourse(123456789, "CST8388", 1, 2024);
        
        // When inserting the student course
        boolean result = studentCourseDao.insertStudentCourse(studentCourse);
        
        // Then the insertion is successful
        assertTrue(result, "it should return true when insertion was successful");
    }
}

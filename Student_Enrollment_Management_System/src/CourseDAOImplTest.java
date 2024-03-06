import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseDAOImplTest {

    private Connection connection;
    private CourseDAOImpl courseDao;

    @BeforeEach
    public void setUp() throws Exception {
        // Establish a connection database
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        // Initialize DAO with  connection
        courseDao = new CourseDAOImpl(connection);
        // Create the necessary table for testing
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE Course (" +
                    "courseId VARCHAR(255), " +
                    "courseName VARCHAR(255), " +
                    "PRIMARY KEY (courseId))";
            statement.execute(sql);
        }
    }

    @Test
    public void testInsertCourse() throws SQLException {
        Course course = new Course("CST8288", "Testing");

        boolean result = courseDao.insertCourse(course);

        assertTrue(result);
    }
}

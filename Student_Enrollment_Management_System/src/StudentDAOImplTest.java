import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class StudentDAOImplTest {

    private Connection connection;
    private StudentDAOImpl studentDao;

    @BeforeEach
    void setUp() throws SQLException {
 
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        connection.prepareStatement("CREATE TABLE Student (studentId INT PRIMARY KEY, firstName VARCHAR(255), lastName VARCHAR(255))").executeUpdate();
        studentDao = new StudentDAOImpl(connection);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.prepareStatement("DROP TABLE Student").executeUpdate();
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    void insertStudent() throws SQLException {
        Student student = new Student(1, "john", "smith");
        assertTrue(studentDao.insertStudent(student));
        
        // Verify the student was inserted
        var resultSet = connection.prepareStatement("SELECT * FROM Student WHERE studentId = 1").executeQuery();
        assertTrue(resultSet.next());
        assertEquals("john", resultSet.getString("firstName"));
        assertEquals("smith", resultSet.getString("lastName"));
    }
}

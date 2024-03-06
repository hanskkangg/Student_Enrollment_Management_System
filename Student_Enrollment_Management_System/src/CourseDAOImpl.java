/*
 * Main
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

public class CourseDAOImpl implements CourseDAO {
    private Connection connection;

    public CourseDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCourse(Course course) {
        String sql = "INSERT INTO Course (courseId, courseName) VALUES (?, ?) ON DUPLICATE KEY UPDATE courseName = VALUES(courseName)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
            return false;
        }
    }
}

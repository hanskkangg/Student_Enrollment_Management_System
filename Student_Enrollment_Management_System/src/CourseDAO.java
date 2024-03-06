/**
 * File Name: CourseDAO.java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description: It's an Interface for database operations related to 'Course' objects.
 * It supports adding courses to the database.
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

/**
 * Adds a course to the database.
 * 
 * @param course The course to add.
 * @return true if added successfully, false otherwise.
 */
public interface CourseDAO {
    boolean insertCourse(Course course);
}

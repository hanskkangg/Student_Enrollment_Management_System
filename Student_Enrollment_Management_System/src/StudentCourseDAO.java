/**
 * File Name: StudentCourseDAO. java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description:  This class is an interface for managing database operations for the association between students and courses.
 * It supports adding a student-course association to the database.
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
 * Adds a student-course association to the database.
 * 
 * @param studentCourse The student-course association to add.
 * @return true if the operation was successful, false otherwise.
 */
public interface StudentCourseDAO {
    boolean insertStudentCourse(StudentCourse studentCourse);
}

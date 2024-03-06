/**
 * File Name: StudentDAO. java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description: Interface for database operations related to students.
 * It supports adding students to the database.
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


public interface StudentDAO {
	 /**
     * Adds a student to the database.
     * 
     * @param student The student to add.
     * @return true if the operation was successful, false otherwise.
     */
    boolean insertStudent(Student student);
}


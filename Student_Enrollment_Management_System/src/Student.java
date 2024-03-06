/**
 * File Name: Student. java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description: This class Represents a student with an ID and name. Allows getting and setting these properties.
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

public class Student {
	 /**
     * Creates a new student with given details.
     *
     * @param studentId The student's ID.
     * @param firstName The student's first name.
     * @param lastName The student's last name.
     */
	public Student(int studentId, String firstName, String lastName) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	private int studentId;
    private String firstName;
    private String lastName;

    /**
     * Gets the student's ID.
     *
     * @return The ID of the student.
     */
    public int getStudentId() {
		return studentId;
	}
    /**
     * Sets the student's ID to a new value.
     *
     * @param studentId The new ID for the student.
     */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
    /**
     * Gets the student's first name.
     *
     * @return The first name of the student.
     */
	public String getFirstName() {
		return firstName;
	}
    /**
     * Sets the student's first name to a new value.
     *
     * @param firstName The new first name for the student.
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    /**
     * Gets the student's last name.
     *
     * @return The last name of the student.
     */
	public String getLastName() {
		return lastName;
	}
    /**
     * Sets the student's last name to a new value.
     *
     * @param lastName The new last name for the student.
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

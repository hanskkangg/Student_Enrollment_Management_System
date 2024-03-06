/**
 * File Name: Course.java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description: This class Represents a course with an ID and name. Allows getting and setting these properties.
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

public class Course {

	private String courseId;
    private String courseName;
    
    /**
     * Creates a new Course with the specified ID and name.
     * 
     * @param courseId The ID of the course.
     * @param courseName The name of the course.
     */
    public Course(String courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
	}

    /**
     * Gets the course ID.
     * 
     * @return The ID of the course.
     */
	public String getCourseId() {
		return courseId;
	}
    /**
     * Sets the course ID to the specified value.
     * 
     * @param courseId The new ID of the course.
     */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
    /**
     * Gets the course name.
     * 
     * @return The name of the course.
     */
	public String getCourseName() {
		return courseName;
	}
	   /**
     * Sets the course name to the specified value.
     * 
     * @param courseName The new name of the course.
     */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}

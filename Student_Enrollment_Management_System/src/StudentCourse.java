/**
 * File Name: StudentCourse. java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description:  This class represents the association between a student and a course, including the term and year of the course.
 * Allows getting and setting the student ID, course ID, term, and year.
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

public class StudentCourse {

	    private int studentId;
	    private String courseId;
	    private int term; 
	    private int year;
	    /**
	     * Creates a new association with the specified student ID, course ID, term, and year.
	     *
	     * @param studentId The ID of the student.
	     * @param courseId The ID of the course.
	     * @param term The term of the course (e.g., 1 for Winter).
	     * @param year The year the course is taken.
	     */
		public StudentCourse(int studentId, String courseId, int term, int year) {
			this.studentId = studentId;
			this.courseId = courseId;
			this.term = term;
			this.year = year;
		}
		   /**
	     * Gets the student's ID.
	     *
	     * @return The student's ID.
	     */
		public int getStudentId() {
			return studentId;
		}
	    /**
	     * Sets a new student ID.
	     *
	     * @param studentId The new student ID.
	     */
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

	    /**
	     * Gets the course ID.
	     *
	     * @return The course ID.
	     */
		public String getCourseId() {
			return courseId;
		}

	    /**
	     * Sets a new course ID.
	     *
	     * @param courseId The new course ID.
	     */
		public void setCourseId(String courseId) {
			this.courseId = courseId;
		}
	    /**
	     * Gets the term of the course.
	     *
	     * @return The term of the course.
	     */
		public int getTerm() {
			return term;
		}
		  /**
	     * Sets a new term for the course.
	     *
	     * @param term The new term.
	     */
		public void setTerm(int term) {
			this.term = term;
		}
		 /**
	     * Gets the year of the course.
	     *
	     * @return The year of the course.
	     */
		public int getYear() {
			return year;
		}

	    /**
	     * Sets a new year for the course.
	     *
	     * @param year The new year.
	     */
		public void setYear(int year) {
			this.year = year;
		}
	    
	}

	

/**
 * File Name: DbValidation.java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description:This class provides validation methods for data related to database operations.
 * It includes checks for the correct format of student and course data.
 *
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

public class DbValidation {
    /**
     * Checks if a line of data is valid based on specific criteria.
     * 
     * @param line A string containing data from a CSV line.
     * @return true if the data line is valid, false otherwise.
     */
	public static boolean isValidDataLine(String line) {
	    if (line == null || line.trim().isEmpty()) {
	        return false;
	    }
	    String[] parts = line.split(",");
	    if (parts.length != 7) {
	        return false;
	    }
	    String studentId = parts[0].trim();
	    String courseId = parts[3].trim();
	    String term = parts[5].trim();
	    String year = parts[6].trim();

	    // Validate studentId
	    if (!studentId.matches("\\d{9}")) {
	        return false;
	    }
	    // Validate courseId
	    if (!courseId.matches("[a-zA-Z]{3}\\d{4}")) {
	        return false;
	    }
	    // Validate term
	    if (!term.matches("WINTER|SUMMER|FALL")) {
	        return false;
	    }
	    // Validate year
	    try {
	        int yearInt = Integer.parseInt(year);
	        if (year.length() != 4 || yearInt < 1967 || yearInt > java.time.Year.now().getValue()) {
	            return false;
	        }
	    } catch (NumberFormatException e) {
	        return false;
	    }
	    return true;
	}
	   /**
     * Converts a term name into a numeric code.
     * 
     * @param term The name of the term (e.g., "WINTER", "SUMMER", "FALL").
     * @return An integer representing the term.
     * @throws IllegalArgumentException if the term is not valid.
     */
	public static int convertTerm(String term) {
	    switch (term.toUpperCase()) {
	        case "WINTER":
	            return 1;
	        case "SUMMER":
	            return 2;
	        case "FALL":
	            return 3;
	        default:
	            throw new IllegalArgumentException("Invalid term: " + term);
	    }
	}

}

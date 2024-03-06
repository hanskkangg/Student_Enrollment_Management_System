import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DbValidationTest {

    @Test
    public void testIsValidDataLine() {
        String validLine = "123456789,john,smith,CST8288,Testing,FALL,2024";
        assertTrue(DbValidation.isValidDataLine(validLine));
        
        String invalidLine = "123456789,john,smith,CST8289,Testing,FALL,2024";
        assertFalse(DbValidation.isValidDataLine(invalidLine));
    }
    
    @Test
    public void testConvertTerm() {
        assertEquals(1, DbValidation.convertTerm("WINTER"));
        assertThrows(IllegalArgumentException.class, () -> DbValidation.convertTerm("AUTUMN"));
    }
}

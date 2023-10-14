

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentLoaderTest
{
    @Test
    public void testparseAndLoadLine(){
        StudentLoader s = new StudentLoader();
        s.parseAndLoadLine("Hector Tran,999248624,2023,1");
        assertEquals(s.getStudents().get(0).name, "Hector Tran");
        assertEquals(s.getStudents().get(0).idNum, 999248624);
        assertEquals(s.getStudents().get(0).gradYear, 2023);
        assertEquals(s.getStudents().get(0).drawNumber, 1);
    }
    
    @Test
    public void testparseAndLoadLineAgain(){
        StudentLoader s = new StudentLoader();
        s.parseAndLoadLine("Hector Tran");
        assertEquals(s.getStudents().size(), 0);
    }
    
    
}

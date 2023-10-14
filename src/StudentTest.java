
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    @Test
    
    public void testcompareTo(){
        Student student = new Student("Hector Tran",999248624,2023,1);
        Student student2 = new Student("Chace Sanford", 999248625, 2023, 2);
        Object temp = (Object) student2;
        assertEquals(student.compareTo(student2), 1);
    }
}

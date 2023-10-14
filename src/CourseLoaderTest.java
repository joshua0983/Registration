import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CourseLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CourseLoaderTest
{
    @Test
    public void testparseAndLoadLine(){
        CourseLoader c = new CourseLoader();
        c.parseAndLoadLine("CMPU,145,51,Foundations/Computer Science,1,24,TRF,720,795,75,1200PM-0115PM,SP 309,Gomerschdat Anna");
        assertEquals(c.getCourses().get(0).dept, "CMPU");
        assertEquals(c.getCourses().get(0).courseNum, 145);
        assertEquals(c.getCourses().get(0).section, 51);
        assertEquals(c.getCourses().get(0).title, "Foundations/Computer Science");
        assertEquals(c.getCourses().get(0).credits, 1);
        assertEquals(c.getCourses().get(0).maxEnrollment, 24);
        assertEquals(c.getCourses().get(0).daysOfTheWeek, "TRF");
        assertEquals(c.getCourses().get(0).startTime, 720);
        assertEquals(c.getCourses().get(0).endTime, 795);
        assertEquals(c.getCourses().get(0).duration, 75);
        assertEquals(c.getCourses().get(0).timeString, "1200PM-0115PM");
        assertEquals(c.getCourses().get(0).loc, "SP 309");
        assertEquals(c.getCourses().get(0).instructor, "Gomerschdat Anna");
    
    }
    
    @Test
    public void testparseAndLoadLineAgain(){
        CourseLoader c = new CourseLoader();
        c.parseAndLoadLine("Hector Tran");
        assertEquals(c.getCourses().size(), 0);
    }
}




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CourseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CourseTest
{
    @Test
    public void testCorrectConflictsWith(){
        Course co = new Course("CMPU",145,51,"Foundations/Computer Science",1,24,"TRF",720,795,75,"1200PM-0115PM","SP 309","Gomerschdat Anna");
        Course maybe = new Course("AMST", 160, 51, "Visual Art and Storytelling", 1, 17, "WF", 630, 705, 75, "1030AM-1145AM", "T 328", "Collins Lisa");
        assertEquals(co.conflictsWith(maybe), false);
    }
    
    @Test
    public void testInCorrectConflictsWith(){
        Course course = new Course("ART", 108, 51, "Color", 1, 14, "TR", 585, 705, 120, "0945AM-1145AM", "EH STD2", "Rajendran Padma");
        Course maybe = new Course("ART", 331, 51, "Seminar Northern European Art", 1, 12, "R", 630, 750, 120, "1030AM-1230PM", "T 205", "Lu Haohao");
        assertEquals(course.conflictsWith(maybe), true);
    }
}

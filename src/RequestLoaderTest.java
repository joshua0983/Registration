

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class RequestLoaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RequestLoaderTest
{
    @Test
    public void testparseAndLoadLine(){
    StudentLoader students = new StudentLoader("../data/shortRoster.csv");
    CourseLoader courses = new CourseLoader("../data/course_shortRequests.csv");
    RequestLoader r = new RequestLoader("../data/shortRequests.csv",students.getStudents(),courses.getCourses());
    r.parseAndLoadLine("999248624,CMPU-145-52, PHIL-106-01");
    assertEquals(r.mapStudents.get(999248624).requests.size(), 9);
    
}
}

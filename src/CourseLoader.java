import java.util.List;
import java.util.ArrayList;
public class CourseLoader extends DataLoader
{
    private List<Course> courses = new ArrayList<Course>();

    /**
     * Constructor calls the load(file) method in abstract parent class.
     * 
     * @param file: the path to the file.
     */
    CourseLoader(String file){
        load(file);
    }
    CourseLoader(){
    }

    /**
     * Parse a single line of CSV in the form:
     * dept, courseNum, section, name, credits, maxEnrol, days, startTime, EndTime, Duration, String time, room, professor
     * CMPU,145,51,Foundations/Computer Science,1,24,TRF,720,795,75,1200PM-0115PM,SP 309,Gomerschdat Anna
     * 
     * Method should create a new Course Object and add it to 
     * the students instance variable.
     * 
     * @param data: a single line from the csv file.
     */
    public void parseAndLoadLine(String data){
        try{
        String[] parts = data.split(",");
        String dept = parts[0]; 
        int courseNum = Integer.parseInt(parts[1]);
        int section = Integer.parseInt(parts[2]);
        String title = parts[3];
        double credits = Double.parseDouble(parts[4]);
        int maxEnrollment = Integer.parseInt(parts[5]);
        String daysOfTheWeek = parts[6];
        int startTime = Integer.parseInt(parts[7]);
        int endTime = Integer.parseInt(parts[8]);
        int duration = Integer.parseInt(parts[9]);
        String timeString = parts[10];
        String loc = parts[11];
        String instructor = parts[12];
        courses.add(new Course(dept, courseNum, section, title, credits, maxEnrollment, daysOfTheWeek, startTime, endTime, duration, timeString, loc, instructor));
    }
        catch(IndexOutOfBoundsException e){
        System.out.println("invalid");
    }
    catch(NumberFormatException e){
        System.out.println("invalid");
    }
    }

    /**
     * Easy getter method to return the completed student roster.
     * @return students: the roster in the form of a List<Course>
     */
    public List<Course> getCourses(){
        return courses;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Write a description of class StudentLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentLoader extends DataLoader
{
    private List<Student> students = new ArrayList<Student>();
    /**
     * Constructor calls the load(file) method in abstract parent class.
     * 
     * @param file: the path to the file.
     */
    public StudentLoader(String file){
        load(file);
    }

    public StudentLoader(){
    }

    /**
     * Parse a single line of CSV in the form:
     * Name, idNum, gradYear, drawNummber
     * Hector Tran,999248624,2023,1
     * 
     * Method should create a new Student Object and add it to 
     * the students instance variable.
     * 
     * @param data: a single line from the csv file.
     */
    public void parseAndLoadLine(String data){
        try{
        String[] parts = data.split(",");
        String name = parts[0];
        int idNum = Integer.parseInt(parts[1]);
        int gradYear = Integer.parseInt(parts[2]);
        int drawNumber = Integer.parseInt(parts[3]);
        students.add(new Student(name, idNum, gradYear, drawNumber));
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
     * @return students: the roster in the form of a List<Student>
     */
    public List<Student> getStudents(){
        return students;
    }

}

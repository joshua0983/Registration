import java.util.*;
public class Algorithm
{
    HashMap<Integer,PriorityQueue> map = new HashMap<>(); 
    HashMap<Integer,Stack> maps = new HashMap<>();
    HashMap<Course,Integer> enrollment;
    List<Integer> keys = new ArrayList<Integer>();
    public Algorithm(List<Student> mapStudents,  HashMap<Course,Integer> enrollment){
        for(int i=0; i<mapStudents.size(); i++){
            if(!(map.containsKey(mapStudents.get(i).gradYear))){
                PriorityQueue pq = new PriorityQueue();
                pq.add(mapStudents.get(i));
                map.put(mapStudents.get(i).gradYear,pq);
            }
            else{
                PriorityQueue pq = map.get(mapStudents.get(i).gradYear);
                pq.add(mapStudents.get(i));
                map.put(mapStudents.get(i).gradYear, pq);
            }
        }
        this.enrollment = enrollment;
        keys.addAll(map.keySet());
        Collections.sort(keys);
        maps.put(keys.get(0), new Stack<Student>());
        maps.put(keys.get(1), new Stack<Student>());
        maps.put(keys.get(2), new Stack<Student>());
        maps.put(keys.get(3), new Stack<Student>());
        this.keys = keys;
    }

    public boolean over(Student student){
        if(student.totalRegisteredCredits() >= 4.5){
            return true;
        }
        return false;
    }

    public boolean space(Course course, Student student){
        if(student.tc + course.credits <= 4.5 && enrollment.get(course) < course.maxEnrollment){
            return true;
        }
        return false;
    }

    public void forward(){
        for (Map.Entry<Integer,PriorityQueue> entry : map.entrySet()) {
            PriorityQueue<Student> pq = entry.getValue();
            int size = map.get(entry.getKey()).size();
            for(int i=0; i<size; i++){
                Student s = pq.poll();
                for(int j=0; j<s.requests.size(); j++){
                    Course request = s.requests.get(j);
                    if(over(s) == false && space(request,s) == true && s.isRegisteredFor(request) == false && s.hasAConflict(request) == false){
                        int newVal = enrollment.get(s.requests.get(j))+1;
                        enrollment.put(s.requests.get(j), newVal);
                        s.tc += request.credits;
                        s.schedule.add(s.requests.get(j));
                        s.requests.remove(s.requests.get(j));
                        break;
                    }
                }
                maps.get(s.gradYear).push(s);
            }

        }
    }

    public void backward(){
        for(Map.Entry<Integer,Stack> entry : maps.entrySet()) {
            Stack<Student> st = entry.getValue();
            int size = maps.get(entry.getKey()).size();
            for(int i=0; i<size; i++){
                Student s = st.pop();
                for(int j=0; j<s.requests.size(); j++){
                    Course request = s.requests.get(j);
                    if(over(s) == false && space(request,s) == true && s.isRegisteredFor(request) == false && s.hasAConflict(request) == false){
                        int newVal = enrollment.get(s.requests.get(j))+1;
                        enrollment.put(s.requests.get(j), newVal);
                        s.tc += request.credits;
                        s.schedule.add(s.requests.get(j));
                        s.requests.remove(s.requests.get(j));
                        break;
                    }
                }
                map.get(s.gradYear).offer(s);
            }
        }
    }

    public void run(){

        /* Description of the algorithm from the Registrar's website:
         * 
         * Entry into a section is determined by the combination of your class year, the priority you give each section, and your draw number.
         * Seniors� requests are processed first followed sequentially by juniors�, sophomores�, and first-years requests.
         * Your requests are considered in the order that you list them on the registration screen, with the first item having the highest priority. If one of your requests cannot be filled, then the next item in your list will be considered instead.
         * For your class year, your draw number determines when one of your requests is considered. Your top request is considered immediately after the top requests of all of the students in your class with lower draw numbers. As mentioned above, if your top request cannot be granted you will be enrolled in the first request on your list that can be.
         * 
         * In a second pass through the requests from your class, your top request among your remaining requests will be considered immediately before all of the students in your class with lower draw numbers. That is, the draw numbers work in reverse compared to the first pass. The remaining passes through the requests from your class continue the pattern of the first two passes, switching direction through the draw numbers on each pass.
         * You may list multiple sections of the same course among your requests but you will be enrolled only in the first one on your list that is available. You will not be enrolled in multiple sections of the same course.
         * You may also list sections of different courses that meet at the same time but you will be enrolled only in the first one on your list that is available. You will not be enrolled in sections with time conflicts.
         * 
         */

        forward();
        backward();
        forward();
        backward();
        forward();
        backward();
        forward();
    }

    public void printEnrollment(){
        //Print the toString of the student, followed by their schedule (using course toString).
        /*
         * Hector Tran 2023 1
         * CMPU-145-51 Foundations/Computer Science    1.0    TRF 1200PM-0115PM
         * EDUC-361-51 Sem: Math/Science/Elem Classrm    1.0    R 0310PM-0610PM
         * ECON-235-51 Sports Economics    1.0    TR 1030AM-1145AM
         * PHED-105-51 Foundations of Wellness    0.5    TR 0900AM-1015AM
         * --------------------
         * Chace Sanford 2023 2
         * GNCS-355-51 Childhood/Childrn 19C Britain    1.0    R 0310PM-0510PM
         * ART-318-51 Building the Museum    1.0    T 0100PM-0300PM
         * CHEM-352-51 Phys Chem-Molec Structr    1.0    MW 1030AM-1145AM
         * INTL-109-51 A Lexicon of Forced Migration    1.0    TR 1030AM-1145AM
         * --------------------
         * etc...
         */
        int key0 = maps.keySet().iterator().next();
        int key1 = (int) map.keySet().toArray()[1];
        int key2 = (int) map.keySet().toArray()[2];
        int key3 = (int) map.keySet().toArray()[3];
        
        Stack<Student> st0 = maps.get(key0);
        for(int i=0; i<st0.size();i++){
        System.out.println(st0.get(i));

        for(Course course:st0.get(i).schedule){
        System.out.println(course);
        }
        System.out.println("-----------------------------");
        }
        
        Stack<Student> st1 = maps.get(key1);
        for(int i=0; i<st0.size();i++){
        System.out.println(st1.get(i));

        for(Course course:st0.get(i).schedule){
        System.out.println(course);
        }
        System.out.println("-----------------------------");
        }
        
        Stack<Student> st2 = maps.get(key2);
        for(int i=0; i<st0.size();i++){
        System.out.println(st2.get(i));

        for(Course course:st0.get(i).schedule){
        System.out.println(course);
        }
        System.out.println("-----------------------------");
        }
        
        Stack<Student> st3 = maps.get(key3);
        for(int i=0; i<st0.size();i++){
        System.out.println(st3.get(i));

        for(Course course:st0.get(i).schedule){
        System.out.println(course);
        }
        System.out.println("-----------------------------");
        }
    }
}


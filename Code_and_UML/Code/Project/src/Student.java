import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Serializable {

    private static final long SERIAL_VERSION_UID = 17L;
    private String name;
    private String family;
    private int studentNumber;
    private String nationalCode;
    private String password;
    private int max;
    private ArrayList<Course> passed;
    private ArrayList<Course> selected;
    private Field field;
    private int term;
    private Map<Integer, List<Float>> averages;

    public Student(String name, String family, int studentNumber, String nationalCode, Field field, int term) {
        this.name = name;
        this.family = family;
        this.studentNumber = studentNumber;
        this.nationalCode = nationalCode;
        this.field = field;
        this.term = term;
        this.password = nationalCode;
        this.passed = new ArrayList<>();
        this.selected = new ArrayList<>();
        this.averages = new HashMap<>();
        ArrayList<Float> list = new ArrayList<>();
        list.add(0.0F);
        list.add(0.0F);
        this.addAverage(term,list);
    }
    public int login(ArrayList<Student> students,int username,String password){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getStudentNumber() == username && students.get(i).getPassword().equals(password)){
                return i;
            }
        }
        return -1;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    public String getNationalCode() {
        return nationalCode;
    }
    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<Course> getPassed() {
        return passed;
    }
    public void setPassed(ArrayList<Course> passed) {
        this.passed = passed;
    }
    public ArrayList<Course> getSelected() {
        return selected;
    }
    public void setSelected(ArrayList<Course> selected) {
        this.selected = selected;
    }
    public Field getField() {
        return field;
    }
    public void setField(Field field) {
        this.field = field;
    }
    public int getTerm() {
        return term;
    }
    public void setTerm(int term) {
        if (selected.size() == 0){
            this.term = term;
            ArrayList<Float> list = new ArrayList<>();
            list.add(0.0F);
            list.add(0.0F);
            this.addAverage(term,list);
            System.out.print("Change term successfully");
        }
    }
    public Map<Integer, List<Float>> getAverages() {
        return averages;
    }
    public void setAverages(Map<Integer, List<Float>> averages) {
        this.averages = averages;
    }
    public boolean addCourse(Course course){
        if (course.calculateEmptyCapacity()-1 < 0){
            System.out.println("CapacityProblem!!!!");
            return false;
        }
        if (course.getPrerequisiteCourse() != null && !passed.contains(course.prerequisiteCourse)){
            System.out.println("prerequisiteCourseProblem!!!!");
            return false;
        }
        if (field !=null && field != course.getField()){
            System.out.println("FieldProblem!!!");
            return false;
        }
        if (term/10 != course.getYear()){
            System.out.println("TermProblem!!!");
            return false;
        }
        for (int i = 0; i<this.selected.size() ; i++){
            if (selected.get(i).getCourseTime() == course.getCourseTime()){
                System.out.println("TimeProblem!!!");
                return false;
            }
        }
        return true;
    }
    public void addSelectedCourse(Course course){
        this.selected.add(course);
    }
    public void addAverage(Integer term,List<Float> marks){
        averages.put(term,marks);
    }
    public void setMark(int inddex, float mark){
        Course course = selected.get(inddex);
        int capacity = selected.get(inddex).getWeight();
        selected.remove(inddex);
        passed.add(course);
        List<Float> average = averages.get(term);
        float numberOfCapacity = average.get(1) + capacity;
        System.out.println("numberofcapacity = "+numberOfCapacity);
        System.out.println("average = "+(average.get(0) + average.get(1)));
        float newAverage = ((average.get(0) + average.get(1)) + (mark + capacity) )/ numberOfCapacity;
        List<Float> inforamtion = new ArrayList<>();
        inforamtion.add(newAverage);
        inforamtion.add(numberOfCapacity);
        addAverage(term,inforamtion);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", studentNumber=" + studentNumber +
                ", nationalCode='" + nationalCode + '\'' +
                ", password='" + password + '\'' +
                ", passedCourse list size =" + passed.size() +
                ", selectedCourse list size =" + selected.size() +
                ", field=" + field +
                ", term=" + term +
                ", averages=" + averages +
                '}';
    }

}









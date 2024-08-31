import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

    protected static final long SERIAL_VERSION_UID = 13L;
    protected int id;
    protected String name;
    protected int weight;
    protected int courseTime;
    protected int capacity;
    protected int year;
    protected Field field;
    protected Course prerequisiteCourse;
    protected ArrayList<Student> students;
    protected Professor professor;
    protected int maxCapacity;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        this.maxCapacity = 20;
        this.capacity = 20;
        this.students = new ArrayList<>();
    }
    public Course(int id, String name, int weight, int courseTime, int capacity, int inputYear, Professor professor) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.courseTime = courseTime;
        this.capacity = capacity;
        this.year = inputYear;
        setProfessor(professor);
        this.maxCapacity = 20;
        this.students = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getCourseTime() {
        return courseTime;
    }
    public void setCourseTime(int courseTime) {
        this.courseTime = courseTime;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        if (capacity<=maxCapacity){
            this.capacity = capacity;
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Field getField() {
        return field;
    }
    public void setField(Field field) {
        this.field = field;
    }
    public Course getPrerequisiteCourse() {
        return prerequisiteCourse;
    }
    public void setPrerequisiteCourse(Course prerequisiteCourse) {
        this.prerequisiteCourse = prerequisiteCourse;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
        professor.addToListOfCourse(this);
        professor.addToNumberOfCourse(weight);
    }
    public void IncreaseCapacity(int number){
        if (capacity + number <= maxCapacity){
            capacity += number;
        }
    }
    public void ReduceCapacity(int number){
        if (capacity + number <= maxCapacity){
            capacity += number;
        }
    }
    public int calculateEmptyCapacity(){
        return capacity - students.size();
    }
    public void addStudent(Student student){
        students.add(student);
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", courseTime=" + courseTime +
                ", capacity=" + capacity +
                ", inputYear=" + year +
                ", field=" + field +
                ", prerequisiteCourse =" + prerequisiteCourse +
                ", students list size = " + students.size() +
                ", professor=" + professor +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}





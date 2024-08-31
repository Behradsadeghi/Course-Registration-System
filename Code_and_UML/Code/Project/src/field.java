import java.io.Serializable;
import java.util.ArrayList;

class Field implements Serializable {

    private static final long SERIAL_VERSION_UID = 112L;
    private String name;
    private int currentTerm;
    private double average;
    private String uni;
    private ArrayList<Course> compulsory;
    private ArrayList<Course> voluntary;

    public Field(String name, int currentTerm ,double average,String college) {
        this.name = name;
        this.currentTerm = currentTerm;
        this.average = average;
        this.uni = college;
        this.compulsory = new ArrayList<Course>();
        this.voluntary = new ArrayList<Course>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCurrentTerm() {
        return currentTerm;
    }
    public void setCurrentTerm(int currentTerm) {
        this.currentTerm = currentTerm;
    }
    public double getAverage() {
        return average;
    }
    public void setAverage(double average) {
        this.average = average;
    }
    public String getUni() {
        return uni;
    }
    public void setUni(String uni) {
        this.uni = uni;
    }
    public ArrayList<Course> getCompulsory() {
        return compulsory;
    }
    public void setCompulsory(ArrayList<Course> compulsory) {
        this.compulsory = compulsory;
    }
    public ArrayList<Course> getVoluntary() {
        return voluntary;
    }
    public void setVoluntary(ArrayList<Course> voluntary) {
        this.voluntary = voluntary;
    }
    public void addToVoluntaryCourses(Course course){
        course.setField(this);
        voluntary.add(course);
    }
    public void addToCompulsoryCourses(Course course){
        course.setField(this);
        compulsory.add(course);
    }
    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", currentTerm=" + currentTerm +
                ", average=" + average +
                ", College='" + uni + '\'' +
                ", compulsoryCourses list size =" + compulsory.size() +
                ", voluntaryCourses list size =" + voluntary.size() +
                '}';
    }
}

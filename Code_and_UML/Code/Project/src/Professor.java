import java.io.Serializable;
import java.util.ArrayList;

public class Professor implements Serializable {

    protected static final long SERIAL_VERSION_UID = 11L;
    protected String name;
    protected String family;
    protected int professorCode;
    protected String password;
    protected int numberCourse;
    protected ArrayList<Course> selectedCourse;

    public Professor(String name, String family,int professorCode, String password) {
        this.name = name;
        this.family = family;
        this.password = password;
        this.professorCode = professorCode;
        this.numberCourse = 0;
        this.selectedCourse = new ArrayList<Course>();
    }
    public int getProfessorCode() {
        return professorCode;
    }
    public void setProfessorCode(int professorCode) {
        this.professorCode = professorCode;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<Course> getSelectedCourse() {
        return selectedCourse;
    }
    public void setSelectedCourse(ArrayList<Course> selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
    public int getNumberCourse() {
        return numberCourse;
    }
    public void setNumberCourse(int numberCourse) {
        this.numberCourse = numberCourse;
    }
    public void addToNumberOfCourse(int weight){
        this.numberCourse += weight;
    }
    public void addToListOfCourse(Course course){
        this.selectedCourse.add(course);
    }
}





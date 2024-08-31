import java.io.Serializable;

public class TemporaryProfessor extends Professor implements Serializable {

    private int teachClock;
    protected static final long SERIAL_VERSION_UID = 13L;
    protected int rank;

    public TemporaryProfessor(String name, String family, int professorCode, String password) {
        super(name, family, professorCode, password);
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getTeachClock() {
        return teachClock;
    }
    public void setTeachClock(int teachClock) {
        this.teachClock = teachClock;
    }
    @Override
    public String toString() {
        return "TemporaryProfessor{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", password='" + password + '\'' +
                ", numberOfSelectedCourse=" + numberCourse +
                ", masterRank=" + rank +
                ", selectedCourse list size =" + selectedCourse.size() +
                ", teachingHours=" + teachClock +
                '}';
    }
}
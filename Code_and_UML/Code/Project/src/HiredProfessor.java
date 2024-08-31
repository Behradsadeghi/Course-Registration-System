import java.io.Serializable;

public class HiredProfessor extends Professor implements Serializable {

    private int years;
    protected static final long SERIAL_VERSION_UID = 12L;
    protected int rank;

    public HiredProfessor(String name, String family, int professorCode, String password) {
        super(name, family, professorCode, password);
    }

    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
    @Override
    public String toString() {
        return "HiredProfessor{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", password='" + password + '\'' +
                ", numberOfSelectedCourse=" + numberCourse +
                ", masterRank=" + rank +
                ", selectedCourse list size =" + selectedCourse.size() +
                ", years=" + years +
                '}';
    }
}
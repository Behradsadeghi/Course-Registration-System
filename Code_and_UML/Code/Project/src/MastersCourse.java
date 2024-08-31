import java.io.Serializable;

public class MastersCourse extends Course implements Serializable {

    protected static final long SERIAL_VERSION_UID = 15L;

    public MastersCourse(int id, String name) {
        super(id, name);
    }
    public MastersCourse(int id, String name, int weight, int courseTime, int capacity, int inputYear, Professor professor) {
        super(id, name, weight, courseTime, capacity, inputYear, professor);
    }
    public int getMax() {
        return maxCapacity;
    }
    public void setMax(int max) {
        maxCapacity = max;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
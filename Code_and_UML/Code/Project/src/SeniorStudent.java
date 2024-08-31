import java.io.Serializable;

public class SeniorStudent extends Student implements Serializable {

    protected static final long SERIAL_VERSION_UID = 18L;
    public SeniorStudent(String name, String family, int studentNumber, String nationalCode, Field field, int term) {
        super(name, family, studentNumber, nationalCode, field, term);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
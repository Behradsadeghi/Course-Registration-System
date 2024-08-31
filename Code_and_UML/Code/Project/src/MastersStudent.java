import java.io.Serializable;

public class MastersStudent extends Student implements Serializable {

    protected static final long SERIAL_VERSION_UID = 19L;
    public MastersStudent(String name, String family, int studentNumber, String nationalCode, Field field, int term) {
        super(name, family, studentNumber, nationalCode, field, term);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
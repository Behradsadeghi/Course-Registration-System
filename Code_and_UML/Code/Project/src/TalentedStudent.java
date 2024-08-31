import java.io.Serializable;

public class TalentedStudent extends MastersStudent implements Serializable {

    protected static final long SERIAL_VERSION_UID = 110L;
    private Field field1;
    public TalentedStudent(String name, String family, int studentNumber, String nationalCode, Field field, int term) {
        super(name, family, studentNumber, nationalCode, field, term);
    }
    public Field getField1() {
        return field1;
    }
    public void setField1(Field field1) {
        this.field1 = field1;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
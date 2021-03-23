
public class Physician extends HealthCarePractitioner {

    private String speciality;

    public Physician(int id, String name, String nationality, int year, int month, int day,
            char gender, String phone, String address, boolean onLeave, String speciality) {
        super(id, name, nationality, year, month, day, gender, phone, address, onLeave);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}

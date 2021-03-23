
public class Nurse extends HealthCarePractitioner {

    private int experienceYears;

    public Nurse(int id, String name, String nationality, int year, int month, int day,
            char gender, String phone, String address, boolean onLeave, int experienceYears) {
        super(id, name, nationality, year, month, day, gender, phone, address, onLeave);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}

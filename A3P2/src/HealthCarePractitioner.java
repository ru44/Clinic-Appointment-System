
public class HealthCarePractitioner extends Person {

    private boolean onLeave;

    public HealthCarePractitioner(int id, String name, String nationality, int year, int month,
            int day, char gender, String phone, String address, boolean onLeave) {
        super(id, name, nationality, year, month, day, gender, phone, address);
        this.onLeave = onLeave;
    }

    public boolean isOnLeave() {
        return onLeave;
    }

    public void setOnLeave(boolean onLeave) {
        this.onLeave = onLeave;
    }
}

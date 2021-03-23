
public class Appointment {

    private Clinic clinic;
    private int year;
    private int month;
    private int day;
    private int appointmentTime;
    private boolean available = true;

    public Appointment() {

    }

    public Appointment(Clinic clinic, int year, int month, int day, int appointmentTime) {
        this.clinic = clinic;
        this.year = year;
        this.month = month;
        this.day = day;
        this.appointmentTime = appointmentTime;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(int appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override

    public String toString() {
        return "Clinic: Number " + clinic.getClinicNumber()
                + " Floor: " + clinic.getClinicFloor()
                + " Date: " + getDay() + "/" + getMonth() + "/" + getYear()
                + " Time: " + getAppointmentTime() + ":00";
    }
}

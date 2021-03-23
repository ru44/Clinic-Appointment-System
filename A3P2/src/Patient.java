
public class Patient extends Person {

    private String diagnosis;
    private Appointment[] appointments = new Appointment[2];
    private int numberOfAppointments;
    public static int numberOfPatient;

    public Patient(int id, String name, String nationality, int year, int month,
            int day, char gender, String phone, String address, String diagnosis) {
        super(id, name, nationality, year, month, day, gender, phone, address);
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public Appointment getAppointmentAT(int index) {
        return appointments[index];
    }

    public int getNumberOfAppointments() {
        return numberOfAppointments;
    }

    public void setNumberOfAppointments(int numberOfAppointments) {
        this.numberOfAppointments = numberOfAppointments;
    }

    public void setAppointments(Appointment[] appointments) {
        this.appointments = appointments;
    }

    public static int getNumberOfPatient() {
        return numberOfPatient;
    }

    public static void setNumberOfPatient(int numberOfPatient) {
        Patient.numberOfPatient = numberOfPatient;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Person.idGenerator = idGenerator;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int searchAppointmentAT(int year, int month, int day, int appointmentTime) {
        for (int index = 0; index < appointments.length; index++) {
            if (year == appointments[index].getYear() && month == appointments[index].getMonth()
                    && day == appointments[index].getDay() && appointmentTime == appointments[index].getAppointmentTime()) {
                return index;
            }
        }
        return -1;
    }

    public static Appointment searchAppointment(Clinic clinic, Appointment[] appointments, int year, int month, int day, int startTime) {
        for (Appointment appointment : appointments) {
            if (clinic == appointment.getClinic()) {
                if (year == appointment.getYear() && month == appointment.getMonth()
                        && day == appointment.getDay() && startTime == appointment.getAppointmentTime()) {
                    return appointment;
                }
            }
        }
        return null;
    }

    public boolean addAppointment(Clinic clinic, int year, int month, int day, int appointmentTime) {
        if (numberOfAppointments < appointments.length) {
            appointments[numberOfAppointments] = new Appointment(clinic, year, month, day, appointmentTime);
            numberOfAppointments++;
            return true;
        } else {
            return false;
        }

    }

    public void DellappointmentAT(int pointer) {
        if (pointer == 0) {
            appointments[0] = appointments[1];
        }
        numberOfAppointments--;
    }
}

/*
Telegram: @Ru44_Y
Twitter: @Ru44_Y
 */
import java.util.*;
import java.io.*;

public class A3P2 {

    static String line = "\r\n------------------------------------------------------------------------------------------------------\r\n";
    public static PrintWriter out;
    /*
     Please Don't Copy And Paste The Code You will get ZERO~!
    */
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input.txt");
        File output = new File("print.txt");
        if (!input.exists()) {
            System.out.println("file doesn't exist!");
            System.exit(0);
        }
        out = new PrintWriter(output);
        Scanner in = new Scanner(input);
        //==========================================================
        Physician[] physicians = new Physician[in.nextInt()];
        Nurse[] nurses = new Nurse[in.nextInt()];
        Patient[] patients = new Patient[in.nextInt()];
        Clinic[] clinics = new Clinic[in.nextInt()];
        Appointment[] appointments = new Appointment[in.nextInt()];

        //==========================================================
        out.println("\r\nWelcome to the Clinic Appointment System!\r\n\r\n");
        invoking_Method(in, out, physicians, nurses, patients, clinics, appointments);
        out.println("\r\nThank you for using the clinic appointment System, Good Bye!");
        in.close();
        out.flush();
        out.close();
    }

    public static void invoking_Method(Scanner in, PrintWriter out, Physician[] physicians, Nurse[] nurses,
            Patient[] patients, Clinic[] clinics, Appointment[] appointments) {
        String command = in.next();
        do {
            if (command.equalsIgnoreCase("SET_physician")) {
                SET_physician(in, out, physicians);
            } else if (command.equalsIgnoreCase("SET_nurse")) {
                SET_nurse(in, out, nurses);
            } else if (command.equalsIgnoreCase("SET_patient")) {
                SET_patient(in, out, patients);
            } else if (command.equalsIgnoreCase("SET_Clinic")) {
                SET_Clinic(in, out, clinics);
            } else if (command.equalsIgnoreCase("SET_Appointment")) {
                SET_Appointment(in, out, appointments, clinics);
            } else if (command.equalsIgnoreCase("RSRVAppointment")) {
                RSRVAppointment(out, in, patients, appointments, clinics);
            } else if (command.equalsIgnoreCase("PrintPatientRecord")) {
                PrintPatientRecord(out, in, appointments, patients);
            } else if (command.equalsIgnoreCase("CancelAppointment")) {
                CancelAppointment(out, in, patients, appointments, clinics);
            }
            command = in.next();
        } while (!command.equalsIgnoreCase("Quit"));

    }

    public static void SET_physician(Scanner in, PrintWriter out, Physician[] physicians) {
        out.println("COMMAND: SET PHYSICIANS\r\n");
        for (int i = 0; i < physicians.length; i++) {
            physicians[i] = new Physician(Person.getIdGenerator(), in.next(), in.next(), Integer.parseInt(in.next()),
                    Integer.parseInt(in.next()), Integer.parseInt(in.next()),
                    in.next().charAt(0), in.next(),
                    in.next(), Boolean.parseBoolean(in.next()), in.next());
            out.printf("Name: %-12s%-6s%d\r\n", physicians[i].getName(), " Id:", physicians[i].getId());
            Person.setIdGenerator(Person.getIdGenerator() + 1);
        }
        out.println(line);
    }

    public static void SET_nurse(Scanner in, PrintWriter out, Nurse[] nurses) {
        out.println("COMMAND: SET NURSES\r\n");
        for (int i = 0; i < nurses.length; i++) {
            nurses[i] = new Nurse(Person.getIdGenerator(), in.next(), in.next(), Integer.parseInt(in.next()),
                    Integer.parseInt(in.next()),
                    Integer.parseInt(in.next()), in.next().charAt(0), in.next(), in.next(),
                    Boolean.parseBoolean(in.next()), Integer.parseInt(in.next()));
            out.printf("Name: %-15s%-6s%d\r\n", nurses[i].getName(), " Id:", nurses[i].getId());
            Person.setIdGenerator(Person.getIdGenerator() + 1);
        }
        out.println(line);
    }

    public static void SET_patient(Scanner in, PrintWriter out, Patient[] patients) {
        out.println("COMMAND: SET PATIENTS\r\n");
        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient(Person.getIdGenerator(), in.next(), in.next(), Integer.parseInt(in.next()),
                    Integer.parseInt(in.next()), Integer.parseInt(in.next()), in.next().charAt(0), in.next(), in.next(), in.next());
            out.printf("Name: %-12s%-6s%d\r\n", patients[i].getName(), " Id:", patients[i].getId());
            Person.setIdGenerator(Person.getIdGenerator() + 1);
            Patient.numberOfPatient++;
        }
        out.println(line);
    }

    public static void SET_Clinic(Scanner in, PrintWriter out, Clinic[] clinics) {
        out.println("COMMAND: SET CLINICS\r\n");
        for (int i = 0; i < clinics.length; i++) {
            clinics[i] = new Clinic(Integer.parseInt(in.next()), Integer.parseInt(in.next()));
            out.println("Clinic: Number  " + clinics[i].getClinicNumber() + " Floor: "
                    + clinics[i].getClinicFloor());
        }
        out.println(line);
    }

    public static void SET_Appointment(Scanner in, PrintWriter out, Appointment[] appointments, Clinic[] clinics) {
        out.println("COMMAND: SET APPOINTMENTS\r\n");
        for (int i = 0; i < appointments.length; i++) {
            Clinic clinic = findClinic(Integer.parseInt(in.next()), Integer.parseInt(in.next()), clinics);
            appointments[i] = new Appointment(clinic, Integer.parseInt(in.next()), Integer.parseInt(in.next()),
                    Integer.parseInt(in.next()), Integer.parseInt(in.next()));
            out.println(appointments[i].toString());
        }
        out.println(line);
    }

    public static void RSRVAppointment(PrintWriter out, Scanner in, Patient[] patients, Appointment[] appointments, Clinic[] clinics) {
        out.println("COMMAND: RESERVE APPOINTMENT\r\n");
        String name = in.next();
        Patient patient = findPatient(patients, name);
        if (patient == null) {
            out.println("Patient " + name + " is not registered\r\n");
        } else {
            if (patient.getNumberOfAppointments() <= 2) {
                Clinic clinic = findClinic(Integer.parseInt(in.next()), Integer.parseInt(in.next()), clinics);
                Appointment appointment = patient.searchAppointment(clinic, appointments, Integer.parseInt(in.next()),
                        Integer.parseInt(in.next()), Integer.parseInt(in.next()), Integer.parseInt(in.next()));
                if (appointment == null) {
                    out.println("Appointment not found in the clinic appointment list\r\n");
                } else {
                    if (appointment.isAvailable()) {
                        if (!patient.addAppointment(clinic, appointment.getYear(), appointment.getMonth(),
                                appointment.getDay(), appointment.getAppointmentTime())) {
                            out.println("Appointment for patient " + name + " can not be added as he has 2 appointment registered\r\n");
                        }
                        out.println("Appointment for patient " + name + " is done\r\n");
                        appointment.setAvailable(false);
                    } else {
                        out.println("Appointment is taken by other patient\r\n");
                    }
                }
            }
        }
        out.println(line);
    }

    public static void PrintPatientRecord(PrintWriter out, Scanner in, Appointment[] appointments, Patient[] patients) {
        out.println("COMMAND: PRINT PATIENT APPOINTMENTS RECORD\r\n");
        String name = in.next();
        Patient patient = findPatient(patients, name);
        if (patient == null) {
            out.println("Patient " + name + " is not registered");
        } else {
            out.println("Appointment for " + name + " are:");
            if (patient.getNumberOfAppointments() == 0) {
                out.print("\r\nPatient " + name + " has no appointment");
            } else {
                AppNumber(out, patient);
            }
        }
        out.println("\r\n" + line);
    }

    public static void CancelAppointment(PrintWriter out, Scanner in, Patient[] patients, Appointment[] appointments, Clinic[] clinics) {
        out.println("COMMAND: CANCEL APPOINTMENT\r\n");
        String name = in.next();
        Patient patient = findPatient(patients, name);
        if (patient == null) {
            out.println("Patient " + name + " is not registered\r\n");
        } else {
            findClinic(Integer.parseInt(in.next()), Integer.parseInt(in.next()), clinics);
            int year = Integer.parseInt(in.next()),
                    month = Integer.parseInt(in.next()),
                    day = Integer.parseInt(in.next()),
                    startTime = Integer.parseInt(in.next());
            int index = patient.searchAppointmentAT(year, month, day, startTime);
            if (index != -1) {
                Appointment appointment = patient.searchAppointment(patient.getAppointmentAT(index).getClinic(), appointments, year, month, day, startTime);
                appointment.setAvailable(true);
                patient.DellappointmentAT(index);
                out.println("Appointment for patient " + name + " is Canceled \r\n"
                        + "Appointment is Canceled from the clinic appointment list and available for other patient\r\n");

            } else {
                out.println("Appointment not found in patient " + name + " records\r\n");
            }
        }
        out.println(line);
    }

    //==========================================================================
    public static Patient findPatient(Patient[] patients, String name) {
        for (Patient patient : patients) {
            if (name.equalsIgnoreCase(patient.getName())) {
                return patient;
            }
        }
        return null;
    }

    public static void AppNumber(PrintWriter out, Patient patient) {
        for (int i = 0; i < patient.getNumberOfAppointments(); i++) {
            out.println("\r\nAppointment number: " + (i + 1) + " " + patient.getAppointments()[i].toString());
        }
    }

    public static Clinic findClinic(int clinicNo, int floorNo, Clinic[] clinics) {
        for (Clinic clinic : clinics) {
            if (clinicNo == clinic.getClinicNumber() && floorNo == clinic.getClinicFloor()) {
                return clinic;
            }
        }
        return null;
    }

}

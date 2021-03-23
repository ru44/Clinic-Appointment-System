
public class Person {

    private int id;
    private String name;
    private String nationality;
    private int year;
    private int month;
    private int day;
    private char gender;
    private String phone;
    private String address;
    public static int idGenerator;

    public Person(int id, String name, String nationality, int year, int month,int day, char gender, String phone, String address) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.year = year;
        this.month = month;
        this.day = day;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Person.idGenerator = idGenerator;
    }
}

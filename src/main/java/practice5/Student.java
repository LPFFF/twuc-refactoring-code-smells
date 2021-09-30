package practice5;

public class Student {
    private final String name;
    private final int birthOfYear;
    private final String gender;

    public Student(String name, int birthOfYear, String gender) {
        this.name = name;
        this.birthOfYear = birthOfYear;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getBirthOfYear() {
        return birthOfYear;
    }

    public String getGender() {
        return gender;
    }
}

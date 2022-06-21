package practice5;

import java.util.ArrayList;
import java.util.List;

public class Class {
    List<Student> studentList;

    String adminInputString;

    Integer num;

    String n;

    public Class(String adminInputString, Integer num, String n) {
        this.studentList = new ArrayList<>();
        this.adminInputString = adminInputString;
        this.num = num;
        this.n = n;
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}


package practice5;

import java.util.ArrayList;
import java.util.List;

public class banji {
    List<Student> stuList;

    String theInputStringFromEndUserWhoHasAdminAccess;

    Integer num;

    String n;

    public banji(String theInputStringFromEndUserWhoHasAdminAccess, Integer num, String n) {
        this.stuList = new ArrayList<>();
        this.theInputStringFromEndUserWhoHasAdminAccess = theInputStringFromEndUserWhoHasAdminAccess;
        this.num = num;
        this.n = n;
    }

    public void doSomthing(Student student) {
        this.stuList.add(student);
    }

    public List<Student> getStuList() {
        return stuList;
    }
}


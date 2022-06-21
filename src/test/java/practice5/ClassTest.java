package practice5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {
    @Test
    void should_compile_success() {
        Class clazz = new Class("admin name", 40, "class name");

        assertEquals(0, clazz.getStudentList().size());
    }

    @Test
    void should_add_new_student() {
        Class clazz = new Class("admin name", 40, "class name");

        clazz.addStudent(new Student("Yan Yu", 1990, "Male"));

        assertEquals(1, clazz.getStudentList().size());
        assertEquals("Yan Yu", clazz.getStudentList().get(0).getName());
        assertEquals("Male", clazz.getStudentList().get(0).getGender());
        assertEquals(1990, clazz.getStudentList().get(0).getBirthOfYear());
    }
}

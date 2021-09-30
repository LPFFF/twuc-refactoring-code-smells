package practice5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class banjiTest {
    @Test
    void should_compile_success() {
        banji clazz = new banji("admin name", 40, "class name");

        assertEquals(0, clazz.getStuList().size());
    }

    @Test
    void should_add_new_student() {
        banji clazz = new banji("admin name", 40, "class name");

        clazz.doSomthing(new Student("Yan Yu", 1990, "Male"));

        assertEquals(1, clazz.getStuList().size());
        assertEquals("Yan Yu", clazz.getStuList().get(0).getName());
        assertEquals("Male", clazz.getStuList().get(0).getGender());
        assertEquals(1990, clazz.getStuList().get(0).getBirthOfYear());
    }
}

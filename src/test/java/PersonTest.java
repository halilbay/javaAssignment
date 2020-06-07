import com.java.assignment.Person;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @org.junit.jupiter.api.Test
    void getFullName(){
        Person p1 = new Person(101, "Halil", "Bay");
        assertEquals("Halil Bay", p1.getFullName());
    }

}

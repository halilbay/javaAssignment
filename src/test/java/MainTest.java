import static org.junit.jupiter.api.Assertions.*;

import com.java.assignment.Main;

class MainTest {

    @org.junit.jupiter.api.Test
    void getValue() {

        assertEquals(5, Main.getValue());
    }
}
import com.java.assignment.ReadingFile;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadingFileTest {

    /*
    * using short path instead full path
    * it should be referenced from resources folder.
    * I do not know whether it set in maven or not but it should be fixed.
    * */
    String fileName = "/home/bay/Documents/workSpace/javaAssignment/src/main/resources/employees.txt";
    ReadingFile fileEmployee = new ReadingFile(fileName);

    public ReadingFileTest() throws IOException {
    }

    @org.junit.jupiter.api.Test
    void readlines() throws IOException {
        fileEmployee.readLines();

        for(String[] lines: fileEmployee.getAllLines()){
            for(String line: lines){
                System.out.println(line);
            }
        }
    }
    @org.junit.jupiter.api.Test
    void getLineCount() throws IOException {
        readlines();
        assertEquals(12, fileEmployee.getLineCount());
    }
}

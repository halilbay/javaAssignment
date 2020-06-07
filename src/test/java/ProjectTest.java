import com.java.assignment.ProjectState;
import com.java.assignment.ReadingFile;
import com.java.assignment.Project;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest {

    @org.junit.jupiter.api.Test
    void getProjectsCount() throws IOException {
        String absPath = "/home/bay/Documents/workSpace/javaAssignment/src/main/resources/";

        // Sales part
        String projectFileName = absPath + "projects.txt";
        ReadingFile fileProject = new ReadingFile(projectFileName);
        assertEquals(6, fileProject.getLineCount());
    }

    @org.junit.jupiter.api.Test
    void getProjects() throws IOException {
        String absPath = "/home/bay/Documents/workSpace/javaAssignment/src/main/resources/";

        Set<Project> projectList = new HashSet<>();
        String projectFileName = absPath + "projects.txt";
        ReadingFile fileProject = new ReadingFile(projectFileName);
        List<String[]> allProject = fileProject.getAllLines();
        for(String[] project: allProject){
            // projectName|details|state
            String name = project[0];
            String details = project[1];
            ProjectState state = ProjectState.valueOf(project[2]);

            projectList.add(new Project(name, details, state));
        }
        System.out.println(projectList);
    }

}

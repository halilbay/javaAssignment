package com.java.assignment;

public class Project {
    /*
    * projectName|details|state
    *
    */

    private final String name;
    private String details;
    private ProjectState state;

    public Project (String name){
        this.name = name;
    }
    public Project (String name, String details, ProjectState state){
        this(name);
        this.details = details;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public void setState(ProjectState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", state=" + state +
                '}';
    }
}

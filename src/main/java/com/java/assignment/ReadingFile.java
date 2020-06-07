package com.java.assignment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class ReadingFile {
    private static final String SEPARATOR = "|";
    private final String fileName;
    private int lineCount;
    private List<String[]> allLines;

    public ReadingFile(String fileName) throws IOException {
        this.fileName = fileName;
        readLines();
    }

    public void readLines() throws IOException {
        lineCount = 0;
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            // calling next line function before while loop is ignored header
            s.nextLine();
            allLines = new ArrayList<>();
            while (s.hasNextLine()) {
                String[] lines = s.nextLine().split("[|]");
                //ignore whitespaces in the file
                if (lines.length > 1){
                    lineCounter();
                    allLines.add(lines);
                }
            }
        } catch (IOException e) {
            out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private void lineCounter(){
        lineCount++;
    }
    public int getLineCount(){
        return lineCount;
    }

    public List<String[]> getAllLines() {
        return allLines;
    }
}

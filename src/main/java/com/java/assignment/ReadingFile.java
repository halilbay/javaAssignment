package com.java.assignment;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

import static java.lang.System.*;

public class ReadingFile {
    private final String fileName;
    private Object o;
    private int lineCount;
    public ReadingFile(String fileName){
        this.fileName = fileName;
    }

    public ReadingFile(String fileName, Object o){
        this(fileName);
        this.o = o;
    }

    public void readLines() throws IOException {
        lineCount = 0;
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (s.hasNextLine()) {
                lineCounter();
                out.println(s.nextLine());
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
}

package com.gmail.ghebrial.mark;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class StudentFile {
    private Random random = new Random();
    private File nameFile = null;

    private FileReader reader;

    //Create a BufferedReader object to simplify interaction with the FileReader
    private BufferedReader buffReader;

    private ArrayList students = new ArrayList();
    private ArrayList chosenStudents = new ArrayList();

    StudentFile (String filePath) throws IOException {
        nameFile = new File(filePath); //Open file of student names

        try {
            reader = new FileReader(nameFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        buffReader = new BufferedReader(reader);

        //Add each name to students
        while (buffReader.ready()) { //Repeat until file is completely read
            students.add(buffReader.readLine()); //Add the student's name to the list of names
        }
    }


    public String generateName () {
        if (students.size() == chosenStudents.size()) {
            chosenStudents.clear();
        }

        String chosenStudent;
        do {
            chosenStudent = (String) students.get(random.nextInt(students.size()));
        } while (chosenStudents.contains(chosenStudent));

        chosenStudents.add(chosenStudent);

        System.out.println(chosenStudent);
        return chosenStudent;
    }

    public String toString() {
        return nameFile.getPath();
    }
}

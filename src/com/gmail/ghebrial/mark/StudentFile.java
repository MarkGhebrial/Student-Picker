package com.gmail.ghebrial.mark;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class StudentFile {
    /*
     * This class represents a file of student names
     * It contains a method to randomly choose a name without repeating it
     *  until the list has been exhausted
     */
    private String name;

    private Random random = new Random();
    private File nameFile; //Will represent the file with the names of the students

    private FileReader reader; //Will actually read the file

    //Simplifies interaction with the FileReader
    private BufferedReader buffReader;

    private ArrayList students = new ArrayList(); //Will contain student names
    private ArrayList chosenStudents = new ArrayList();

    StudentFile (String name, String filePath) throws IOException {
        this.name = name;

        nameFile = new File(filePath); //Initialise nameFile at filePath

        //Initialise FileReader
        try {
            reader = new FileReader(nameFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Initialise buffReader
        buffReader = new BufferedReader(reader);

        //Add each name to students
        while (buffReader.ready()) { //Repeat until file is completely read
            students.add(buffReader.readLine()); //Add the student's name to the list of names
        }
    }


    public String generateName () {
        /**
         * Randomly generates a name without repeating it
         *  until the list has been exhausted
         */

        //Clear chosenStudents if all students have been chosen
        if (students.size() == chosenStudents.size()) {
            chosenStudents.clear();
        }

        String chosenStudent;
        do { //Randomly choose names until a unique one is found
            chosenStudent = (String) students.get(random.nextInt(students.size()));
        } while (chosenStudents.contains(chosenStudent));

        //Add the chosen name to chosenStudents so that it is not Repeated
        chosenStudents.add(chosenStudent);

        System.out.println(chosenStudent);
        return chosenStudent;
    }

    public String toString() {
        return name;
    }
}

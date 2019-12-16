package com.gmail.ghebrial.mark;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class InterfacePanel extends JPanel {
    private static final int WIDTH = 300, HEIGHT = 200;

    private static Random random = new Random();
    private static File settings = new File("D://Student Picker//src//com//gmail//ghebrial//mark//students.txt"); //Open file of student names

    private static FileReader reader;
    static {
        try {
            reader = new FileReader(settings);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Create a BufferedReader object to simplify interaction with the FileReader
    private static BufferedReader buffReader = new BufferedReader(reader);

    private static ArrayList students = new ArrayList();
    private static ArrayList chosenStudents = new ArrayList();

    private static String chosenStudent = "Press button to choose a random student";
    private static JLabel studentLabel = new JLabel(chosenStudent);
    private static JButton nextButton = new JButton("Next Student");


    public InterfacePanel() throws IOException {
        //Add each name to students
        while (buffReader.ready()) { //Repeat until file is completely read
            students.add(buffReader.readLine()); //Add the student's name to the list of names
        }


        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chosenStudent = generateName();
                studentLabel.setText(chosenStudent);

            }
        });

        add(nextButton);
        add(studentLabel);
    }

    public static String generateName () {
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
}

package com.gmail.ghebrial.mark;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class InterfacePanel extends JPanel {
    private static final int WIDTH = 300, HEIGHT = 200;

    private static String chosenStudent = null;
    private static JLabel studentLabel = new JLabel("Press button to choose a random student");
    private static JButton nextButton = new JButton("Next Student");

    private static StudentFile period1 = null;
    /*private static StudentFile period2 = null;
    private static StudentFile period3 = null;
    private static StudentFile period4 = null;
    private static StudentFile period5 = null;
    private static StudentFile period6 = null;
    private static StudentFile period7 = null;*/
    static {
        try {
            period1 = new StudentFile("D://Student Picker//src//com//gmail//ghebrial//mark//students.txt");
            /*period2 = new StudentFile("D://Student Picker//src//com//gmail//ghebrial//mark//students.txt");
            period3 = new StudentFile("D://Student Picker//src//com//gmail//ghebrial//mark//students.txt");
            period4 = new StudentFile("D://Student Picker//src//com//gmail//ghebrial//mark//students.txt");
            period5 = new StudentFile("D://Student Picker//src//com//gmail//ghebrial//mark//students.txt");
            period6 = new StudentFile("D://Student Picker//src//com//gmail//ghebrial//mark//students.txt");
            period7 = new StudentFile("D://Student Picker//src//com//gmail//ghebrial//mark//students.txt");*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public InterfacePanel() throws IOException {

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                chosenStudent = period1.generateName();
                studentLabel.setText(chosenStudent);

            }
        });

        add(nextButton);
        add(studentLabel);
    }

}

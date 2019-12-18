package com.gmail.ghebrial.mark;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class InterfacePanel extends JPanel {
    private static final int WIDTH = 300, HEIGHT = 200;

    private static StudentFile[] periodArray = new StudentFile[7];
    private static StudentFile period1 = null;
    private static StudentFile period2 = null;
    private static StudentFile period3 = null;
    private static StudentFile period4 = null;
    private static StudentFile period5 = null;
    private static StudentFile period6 = null;
    private static StudentFile period7 = null;
    static {
        try {
            periodArray[0] = new StudentFile("Period 1","D://Student Picker//NameLists//period1");
            periodArray[1] = new StudentFile("Period 2","D://Student Picker//NameLists//period2");
            periodArray[2] = new StudentFile("Period 3","D://Student Picker//NameLists//period3");
            periodArray[3] = new StudentFile("Period 4","D://Student Picker//NameLists//period4");
            periodArray[4] = new StudentFile("Period 5","D://Student Picker//NameLists//period5");
            periodArray[5] = new StudentFile("Period 6","D://Student Picker//NameLists//period6");
            periodArray[6] = new StudentFile("Period 7","D://Student Picker//NameLists//period7");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JComboBox periodMenu = new JComboBox(periodArray);
    private static JLabel studentLabel = new JLabel("Press button to choose a random student");
    private static JButton nextButton = new JButton("Next Student");

    public InterfacePanel() {

        //periodList.

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                studentLabel.setText(periodArray[periodMenu.getSelectedIndex()].generateName());
            }
        });

        add(periodMenu);
        add(nextButton);
        add(studentLabel);
    }

}

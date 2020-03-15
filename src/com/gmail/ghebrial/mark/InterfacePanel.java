package com.gmail.ghebrial.mark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class InterfacePanel extends JPanel {

    //This array will be in the drop-down menu to select the period
    private StudentFile[] periodArray = new StudentFile[7];

    //IPMORTANT, THE PROGRAM WILL NOT WORK UNLESS YOU CHANGE THIS VARIABLE TO THE FILEPATH WITH THE .txt FILES OF THE NAMES
    //TODO: Make this automatic somehow
    private String rootPath = "D://Student Picker//NameLists";

    //Create the graphic elements for the GUI
    private  JComboBox periodMenu = new JComboBox(periodArray);
    private  JLabel studentLabel = new JLabel("Press button to choose a random student");
    private  JButton nextButton = new JButton("Next Student");

    public InterfacePanel() {

        LoadFiles(rootPath);

        //Run this code when nextButton is pressed
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Display a random name from the selected file
                studentLabel.setText(periodArray[periodMenu.getSelectedIndex()].generateName());
            }
        });

        //Add the graphic elements to the GUI
        add(periodMenu);
        add(nextButton);
        add(studentLabel);
    }

    private void LoadFiles (String rootPath) {
        try {
            periodArray[0] = new StudentFile("Period 1",rootPath + "//period1");
            periodArray[1] = new StudentFile("Period 2",rootPath + "//period2");
            periodArray[2] = new StudentFile("Period 3",rootPath + "//period3");
            periodArray[3] = new StudentFile("Period 4",rootPath + "//period4");
            periodArray[4] = new StudentFile("Period 5",rootPath + "//period5");
            periodArray[5] = new StudentFile("Period 6",rootPath + "//period6");
            periodArray[6] = new StudentFile("Period 7",rootPath + "//period7");
        } catch (IOException e) {
            e.printStackTrace();
        }

        periodMenu = new JComboBox(periodArray);
    }
}

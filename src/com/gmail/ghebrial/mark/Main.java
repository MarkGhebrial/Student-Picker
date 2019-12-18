package com.gmail.ghebrial.mark;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame interfaceFrame = new JFrame("Student Picker"); //Create new window
        interfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add my custom InterfacePanel to the window
        try {
            interfaceFrame.getContentPane().add (new InterfacePanel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        interfaceFrame.pack();
        interfaceFrame.setVisible(true); //Show the window
    }
}

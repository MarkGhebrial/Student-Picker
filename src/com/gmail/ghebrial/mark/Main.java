package com.gmail.ghebrial.mark;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame interfaceFrame = new JFrame("Student Picker");
        interfaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            interfaceFrame.getContentPane().add (new InterfacePanel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        interfaceFrame.pack();
        interfaceFrame.setVisible(true);
    }
}

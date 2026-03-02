package Framejava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SquareNumberGUI {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Square of a Number");

        // Create components
        JLabel label = new JLabel("Enter a number:");
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Find Square");
        JLabel resultLabel = new JLabel("Result: ");

        // Set layout
        frame.setLayout(new FlowLayout());

        // Add components to frame
        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(resultLabel);

        // Button action
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(textField.getText());
                    int square = num * num;
                    resultLabel.setText("Result: " + square);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number");
                }
            }
        });

        // Frame settings
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
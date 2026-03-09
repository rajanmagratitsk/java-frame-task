package Framejava;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculatorGUI {
    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create components
        JLabel label1 = new JLabel("Number 1:");
        JTextField num1Field = new JTextField(10);

        JLabel label2 = new JLabel("Number 2:");
        JTextField num2Field = new JTextField(10);

        JButton addButton = new JButton("Add");
        JButton subButton = new JButton("Subtract");

        JLabel resultLabel = new JLabel("Result: ");

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n1 = Integer.parseInt(num1Field.getText());
                    int n2 = Integer.parseInt(num2Field.getText());
                    int sum = n1 + n2;
                    resultLabel.setText("Result: " + sum);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Enter valid numbers!");
                }
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n1 = Integer.parseInt(num1Field.getText());
                    int n2 = Integer.parseInt(num2Field.getText());
                    int diff = n1 - n2;
                    resultLabel.setText("Result: " + diff);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Enter valid numbers!");
                }
            }
        });

        // Add components to frame
        frame.add(label1);
        frame.add(num1Field);
        frame.add(label2);
        frame.add(num2Field);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(resultLabel);

        // Set frame visible
        frame.setVisible(true);
    }
}
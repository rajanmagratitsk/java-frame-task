package Framejava;
import javax.swing.*;

public class TempConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        JTextField input = new JTextField();
        JButton toF = new JButton("C → F");
        JButton toC = new JButton("F → C");
        JLabel result = new JLabel("");

        frame.setLayout(null);
        input.setBounds(50, 30, 100, 30);
        toF.setBounds(160, 30, 80, 30);
        toC.setBounds(250, 30, 80, 30);
        result.setBounds(50, 70, 200, 30);

        frame.add(input);
        frame.add(toF);
        frame.add(toC);
        frame.add(result);

        toF.addActionListener(e -> {
            double c = Double.parseDouble(input.getText());
            double f = (c * 9/5) + 32;
            result.setText("Fahrenheit: " + f);
        });

        toC.addActionListener(e -> {
            double f = Double.parseDouble(input.getText());
            double c = (f - 32) * 5/9;
            result.setText("Celsius: " + c);
        });

        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
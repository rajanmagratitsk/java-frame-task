package Framejava;

import javax.swing.*;

public class HelloWorldGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
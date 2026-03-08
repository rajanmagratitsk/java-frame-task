package Framejava;

import javax.swing.*;
import java.awt.event.*;

public class CharCounter {
    public static void main(String[] args) {
        JFrame f = new JFrame("Counter");
        JTextArea a = new JTextArea();
        JButton b = new JButton("Count");

        a.setBounds(30,30,200,80);
        b.setBounds(80,120,100,30);

        b.addActionListener(e ->
            JOptionPane.showMessageDialog(f,"Characters: "+a.getText().length())
        );

        f.add(a); f.add(b);
        f.setSize(300,220);
        f.setLayout(null);
        f.setVisible(true);
    }
}
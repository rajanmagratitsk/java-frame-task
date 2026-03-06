package Framejava;


import javax.swing.*;

public class UpperCaseGUI {
    public static void main(String[] args) {
        JFrame f=new JFrame("Uppercase");
        JTextField t=new JTextField();
        JButton b=new JButton("Convert");

        t.setBounds(50,40,150,30);
        b.setBounds(210,40,100,30);

        b.addActionListener(e->t.setText(t.getText().toUpperCase()));

        f.add(t);f.add(b);
        f.setSize(350,150);
        f.setLayout(null);
        f.setVisible(true);
    }
}
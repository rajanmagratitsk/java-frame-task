package Framejava;

import javax.swing.*;

public class TextLength {
    public static void main(String[] args) {
        JFrame f=new JFrame("Length");
        JTextField t=new JTextField();
        JButton b=new JButton("Length");
        JLabel l=new JLabel();

        t.setBounds(50,30,150,30);
        b.setBounds(210,30,80,30);
        l.setBounds(50,80,200,30);

        b.addActionListener(e->l.setText("Length: "+t.getText().length()));

        f.add(t);f.add(b);f.add(l);
        f.setSize(320,180);
        f.setLayout(null);
        f.setVisible(true);
    }
}
package Framejava;

import java.awt.event.*;
import javax.swing.*;

public class AgeChecker extends JFrame implements ActionListener
{
    JTextField t;
    JButton b;
    JLabel l;

    AgeChecker()
    {
        setSize(300,200);
        setLayout(null);

        t = new JTextField();
        t.setBounds(80,30,120,30);

        b = new JButton("Check");
        b.setBounds(100,70,80,30);

        l = new JLabel("");
        l.setBounds(90,110,150,30);

        add(t);
        add(b);
        add(l);

        b.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        int age = Integer.parseInt(t.getText());

        if(age >= 18)
            l.setText("You are Adult");
        else
            l.setText("You are Minor");
    }

    public static void main(String args[])
    {
        new AgeChecker();
    }
}
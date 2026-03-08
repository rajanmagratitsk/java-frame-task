package Framejava;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Greeting extends JFrame implements ActionListener
{
    JButton b1, b2, b3, b4;
    JLabel result;

    Greeting()
    {
        setTitle("Greeting Program");
        setSize(400,200);
        setLayout(new FlowLayout());

        b1 = new JButton("Good Morning");
        b2 = new JButton("Good Afternoon");
        b3 = new JButton("Good Evening");
        b4 = new JButton("Good Night");

        result = new JLabel("Click a greeting button");

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(result);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
            result.setText("Good Morning Rajan!");

        else if(e.getSource() == b2)
            result.setText("Good Afternoon Rajan!");

        else if(e.getSource() == b3)
            result.setText("Good Evening Rajan!");

        else if(e.getSource() == b4)
            result.setText("Good Night Rajan!");
    }

    public static void main(String args[])
    {
        new Greeting();
    }
}
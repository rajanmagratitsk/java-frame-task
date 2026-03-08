package Framejava;

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ComplimentGUI extends JFrame implements ActionListener
{
    JButton b;
    JLabel l;

    String[] msg = {
        "You are awesome!",
        "You are very smart!",
        "You will be a great programmer!",
        "Keep going Rajan!",
        "Success is coming!"
    };

    ComplimentGUI()
    {
        setSize(350,200);
        setLayout(null);

        b = new JButton("Open message");
        b.setBounds(100,50,150,30);

        l = new JLabel("");
        l.setBounds(100,100,200,30);

        add(b);
        add(l);

        b.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        Random r = new Random();
        l.setText(msg[r.nextInt(msg.length)]);
    }

    public static void main(String args[])
    {
        new ComplimentGUI();
    }
}
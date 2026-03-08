package Framejava;

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class DiceGUI extends JFrame implements ActionListener
{
    JButton b;
    JLabel l;

    DiceGUI()
    {
        setSize(300,200);
        setLayout(null);

        b = new JButton("Roll Dice");
        b.setBounds(90,40,120,30);

        l = new JLabel("Result: ");
        l.setBounds(110,100,100,30);

        add(b);
        add(l);

        b.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        Random r = new Random();
        int num = r.nextInt(6)+1;
        l.setText("Result: " + num);
    }

    public static void main(String args[])
    {
        new DiceGUI();
    }
}
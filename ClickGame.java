package Framejava;

import java.awt.event.*;
import javax.swing.*;

public class ClickGame extends JFrame implements ActionListener
{
    JButton b;
    JLabel l;
    int count = 0;

    ClickGame()
    {
        setSize(300,200);
        setLayout(null);

        b = new JButton("Click Me");
        b.setBounds(100,50,100,30);

        l = new JLabel("Clicks: 0");
        l.setBounds(110,100,100,30);

        add(b);
        add(l);

        b.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        count++;
        l.setText("Clicks: " + count);
    }

    public static void main(String args[])
    {
        new ClickGame();
    }
}
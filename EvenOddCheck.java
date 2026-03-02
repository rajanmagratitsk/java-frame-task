package Framejava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EvenOddCheck {
    public static void main(String[] args) {

        JFrame f = new JFrame("Even or Odd");

        JLabel lbl = new JLabel("Enter Number:");
        JTextField txt = new JTextField(10);

        JButton btn = new JButton("Check");
        JLabel result = new JLabel("Result: ");

        f.setLayout(new FlowLayout());

        f.add(lbl);
        f.add(txt);
        f.add(btn);
        f.add(result);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(txt.getText());

                if (num % 2 == 0)
                    result.setText("Result: Even Number");
                else
                    result.setText("Result: Odd Number");
            }
        });

        f.setSize(300, 180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
    }
}

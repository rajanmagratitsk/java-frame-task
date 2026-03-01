package Framejava;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReadDisplay {
    public static void main(String[] args) {

        JFrame f = new JFrame("Read and Display");

        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");

        JTextField t1 = new JTextField(10);
        JTextField t2 = new JTextField(10);

        JButton btn = new JButton("Display");

        f.setLayout(new FlowLayout());

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = t1.getText();
                String b = t2.getText();
                JOptionPane.showMessageDialog(f,
                        "First Number: " + a + "\nSecond Number: " + b);
            }
        });

        f.setSize(350, 180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
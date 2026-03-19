import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddNumbersGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Addition Program");

        // Labels
        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");
        JLabel l3 = new JLabel("Result:");

        // TextFields
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();

        // Button
        JButton b = new JButton("Add");

        // Layout
        f.setLayout(new GridLayout(4, 2, 10, 10));

        // Add components
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(t3);
        f.add(new JLabel("")); f.add(b);

        // Button action
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int sum = a + b;
                t3.setText(String.valueOf(sum));
            }
        });

        // Frame settings
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
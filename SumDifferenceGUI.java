import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumDifferenceGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Sum & Difference");

        // Labels
        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");

        // TextFields
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();

        // Buttons
        JButton add = new JButton("Add");
        JButton sub = new JButton("Subtract");

        // Layout
        f.setLayout(new GridLayout(3, 2, 10, 10));

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(add); f.add(sub);

        // Add button → Sum
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int sum = a + b;

                JOptionPane.showMessageDialog(f, "Sum = " + sum);
            }
        });

        // Subtract button → Difference
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int diff = a - b;

                JOptionPane.showMessageDialog(f, "Difference = " + diff);
            }
        });

        // Frame settings
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
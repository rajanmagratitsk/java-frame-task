import javax.swing.*;
import java.awt.event.*;

public class Simplegui{
    public static void main(String[] args) {
        JFrame f = new JFrame("Simple GUI");
        JLabel lbl1 = new JLabel("First number:");
        JLabel lbl2 = new JLabel("Second number:");
        JTextField txt1 = new JTextField();
        JTextField txt2 = new JTextField();
        JButton btn = new JButton("Add");

        lbl1.setBounds(20, 20, 100, 30);
        lbl2.setBounds(20, 60, 100, 30);
        txt1.setBounds(130, 20, 100, 30);
        txt2.setBounds(130, 60, 100, 30);
        btn.setBounds(80, 110, 80, 30);

        f.add(lbl1);
        f.add(lbl2);
        f.add(txt1);
        f.add(txt2);
        f.add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(txt1.getText());
                int b = Integer.parseInt(txt2.getText());
                int sum = a + b;
                JOptionPane.showMessageDialog(f, "Sum is: " + sum);
            }
        });

        f.setSize(300, 200);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

import java.awt.event.*;
import javax.swing.*;

public class MultiplyDivide {
    MultiplyDivide()
    {
        JFrame f = new JFrame("Multiply and Divide");

        JLabel lblFirstNumber = new JLabel("First Number");
        lblFirstNumber.setBounds(10,20,200,20);
        f.add(lblFirstNumber);

        JTextField txtFirstNumber = new JTextField();
        txtFirstNumber.setBounds(120,20,100,20);
        f.add(txtFirstNumber);

        JLabel lblSecondNumber = new JLabel("Second Number");
        lblSecondNumber.setBounds(10,50,200,20);
        f.add(lblSecondNumber);

        JTextField txtSecondNumber = new JTextField();
        txtSecondNumber.setBounds(120,50,100,20);
        f.add(txtSecondNumber);

        JButton btnMultiply = new JButton("Multiply");
        btnMultiply.setBounds(30,120,90,25);
        f.add(btnMultiply);

        JButton btnDivide = new JButton("Divide");
        btnDivide.setBounds(140,120,90,25);
        f.add(btnDivide);

        f.setSize(400,300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        btnMultiply.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a = Integer.parseInt(txtFirstNumber.getText());
                int b = Integer.parseInt(txtSecondNumber.getText());
                int c = a * b;

                JOptionPane.showMessageDialog(f,"Multiplication: " + c);
            }
        });

        btnDivide.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a = Integer.parseInt(txtFirstNumber.getText());
                int b = Integer.parseInt(txtSecondNumber.getText());
                int c = a / b;

                JOptionPane.showMessageDialog(f,"Division: " + c);
            }
        });
    }

    public static void main(String args[])
    {
        new MultiplyDivide();
    }
}
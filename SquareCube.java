import java.awt.event.*;
import javax.swing.*;

public class SquareCube {
    SquareCube()
    {
        JFrame f = new JFrame("Square and Cube");

        JLabel lblNumber = new JLabel("Enter Number");
        lblNumber.setBounds(10,20,200,20);
        f.add(lblNumber);

        JTextField txtNumber = new JTextField();
        txtNumber.setBounds(120,20,100,20);
        f.add(txtNumber);

        JButton btnSquare = new JButton("Square");
        btnSquare.setBounds(30,80,80,25);
        f.add(btnSquare);

        JButton btnCube = new JButton("Cube");
        btnCube.setBounds(140,80,80,25);
        f.add(btnCube);

        f.setSize(300,200);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        btnSquare.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a = Integer.parseInt(txtNumber.getText());
                int s = a*a;
                JOptionPane.showMessageDialog(f,"Square: "+s);
            }
        });

        btnCube.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a = Integer.parseInt(txtNumber.getText());
                int c = a*a*a;
                JOptionPane.showMessageDialog(f,"Cube: "+c);
            }
        });
    }

    public static void main(String args[])
    {
        new SquareCube();
    }
}
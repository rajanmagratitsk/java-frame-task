package Framejava;
import javax.swing.*;
import java.awt.event.*;
public class Sum {
    Sum()
    {
        JFrame f=new JFrame("Sum Calculator");
        JLabel lblFirstNumber=new JLabel("First Number");
        lblFirstNumber.setBounds(10, 20, 200, 20);
        f.add(lblFirstNumber);
        JTextField txtFirstNumber=new JTextField();
        txtFirstNumber.setBounds(100, 20, 100, 20);
        f.add(txtFirstNumber);
        JLabel lblSecondNumber=new JLabel("Second Number");
        lblSecondNumber.setBounds(10, 50, 200, 20);
        f.add(lblSecondNumber);
        JTextField txtSecondNumber=new JTextField();
        txtSecondNumber.setBounds(100, 50, 100, 20);
        f.add(txtSecondNumber);
        JLabel lblResult=new JLabel("Result");
        lblResult.setBounds(10, 80, 200, 20);
        f.add(lblResult);
        JTextField txtResult=new JTextField();
        txtResult.setBounds(100, 80, 100, 20);
        f.add(txtResult);
        JButton btnSum=new JButton("Sum");
        btnSum.setBounds(30,130,70,20);
        f.add(btnSum);
        JButton btnCancel=new JButton("Cancel");
        btnCancel.setBounds(110,130,100,20);
        f.add(btnCancel);
        f.setSize(400,500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        btnSum.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a=Integer.parseInt(txtFirstNumber.getText());
                int b=Integer.parseInt(txtSecondNumber.getText());
                int c=a+b;
                txtResult.setText(""+c);
            }        
        }
        ); 
        btnCancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
            txtFirstNumber.setText("");
            txtSecondNumber.setText("");
            txtResult.setText("");
            }        
        }
        );
    }
    public static void main(String args[])
    {
        new Sum();
    }        
    
}
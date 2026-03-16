


import java.awt.event.*;
import javax.swing.*;
public class AddSubtract {
    AddSubtract()
    {
       JFrame f=new JFrame("Add and Subtract");
        JLabel lblFirstNumber= new JLabel ("first Number");
        lblFirstNumber.setBounds(10, 20, 200, 20);
        f.add(lblFirstNumber);
        JTextField txtFirstNumber=new JTextField();
        txtFirstNumber.setBounds(100,20, 100, 20);
        f.add(txtFirstNumber);
        JLabel lblSecondNumber=new JLabel("Second Number");
        lblSecondNumber.setBounds(10, 50, 200, 20);
        f.add(lblSecondNumber);
        JTextField txtSecondNumber=new JTextField();
        txtSecondNumber.setBounds(100,50,100, 20);
        f.add(txtSecondNumber);
        
        
        JButton btnSum=new JButton("Sum");
        btnSum.setBounds(30, 130, 70, 20);
        f.add(btnSum);
        JButton btnDifference=new JButton("Difference");
        btnDifference.setBounds(110, 130, 100, 20);
        f.add(btnDifference);
       
        
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
               JOptionPane.showMessageDialog(f,"Sum:"+c);
            }
            
    }
        );
        btnDifference.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a=Integer.parseInt(txtFirstNumber.getText());
                int b=Integer.parseInt(txtSecondNumber.getText());
                int c=a-b;
 
                JOptionPane.showMessageDialog(f,"Difference:"+c);
            }
        }
        );
    }public static void main(String args[]){
        new AddSubtract();
    }
    
}

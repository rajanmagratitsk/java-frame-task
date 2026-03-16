import java.awt.event.*;
import javax.swing.*;

public class MaxNumber {
    MaxNumber()
    {
        JFrame f=new JFrame("Maximum Number");

        JLabel l1=new JLabel("First Number");
        l1.setBounds(10,20,200,20);
        f.add(l1);

        JTextField t1=new JTextField();
        t1.setBounds(120,20,100,20);
        f.add(t1);

        JLabel l2=new JLabel("Second Number");
        l2.setBounds(10,50,200,20);
        f.add(l2);

        JTextField t2=new JTextField();
        t2.setBounds(120,50,100,20);
        f.add(t2);

        JButton btn=new JButton("Find Max");
        btn.setBounds(80,100,100,25);
        f.add(btn);

        f.setSize(300,200);
        f.setLayout(null);
        f.setVisible(true);

        btn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int a=Integer.parseInt(t1.getText());
                int b=Integer.parseInt(t2.getText());

                if(a>b)
                    JOptionPane.showMessageDialog(f,"Maximum:"+a);
                else
                    JOptionPane.showMessageDialog(f,"Maximum:"+b);
            }
        });
    }

    public static void main(String args[])
    {
        new MaxNumber();
    }
}

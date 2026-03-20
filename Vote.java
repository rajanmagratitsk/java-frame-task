import java.awt.event.*;
import javax.swing.*;
public class Vote 
{
 Vote()
 {
 JFrame jframe=new JFrame("Checking for voting");
 jframe.setLayout(null);
 jframe.setSize(400, 200);
 jframe.setVisible(true);
 
 JLabel lblAge=new JLabel("Enter your Age:");
 lblAge.setBounds(20, 30, 150, 20);
 jframe.add(lblAge);
 
 JTextField txtAge = new JTextField();
 txtAge.setBounds(150, 30, 150, 20);
 jframe.add(txtAge);
 
 JButton btnCheck=new JButton("Check");
 btnCheck.setBounds(100, 60, 80, 20);
 jframe.add(btnCheck);
 
 JLabel lblResult=new JLabel("");
 lblResult.setBounds(100, 85, 150, 20);
 jframe.add(lblResult);
 btnCheck.addActionListener(new ActionListener()
 {
 public void actionPerformed(ActionEvent ae)

 {
 int a=Integer.parseInt(txtAge.getText());
 if(a>=18)
 lblResult.setText("You are eligible to vote");
 else
 lblResult.setText("Yor are not eligible to vote");
 }
 }
 );
 }
 public static void main(String args[])
 {
 SwingUtilities.invokeLater(new Runnable()
 {
 public void run()
 {
 new Vote();
 }
 }
 );
 }
}

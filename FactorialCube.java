/*rite a GUI program using components to find factorial and cube of 
number. Use TextField for giving input and Label for output. The 
program should display factorial if user press mouse on result button and 
cube if user release mouse from result button.*/


import java.awt.event.*;
import javax.swing.*;

public class FactorialCube extends MouseAdapter {

    JLabel lblNumber, lblResult;
    JTextField txtNumber;
    JButton btnResult;

    FactorialCube() {
        JFrame f = new JFrame("Factorial and Cube");

      
        lblNumber = new JLabel("Enter Number");
        lblNumber.setBounds(20, 30, 120, 20);
        f.add(lblNumber);

       
        txtNumber = new JTextField();
        txtNumber.setBounds(150, 30, 150, 20);
        f.add(txtNumber);

      
        lblResult = new JLabel("Result");
        lblResult.setBounds(20, 70, 300, 20);
        f.add(lblResult);

      
        btnResult = new JButton("Result");
        btnResult.setBounds(150, 110, 100, 30);
        f.add(btnResult);

     
        btnResult.addMouseListener(this);

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        new FactorialCube();
    }

  
   
    public void mousePressed(MouseEvent e) {
        int n = Integer.parseInt(txtNumber.getText());
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        lblResult.setText("Factorial = " + fact);
    }

   
   
    public void mouseReleased(MouseEvent e) {
        int n = Integer.parseInt(txtNumber.getText());
        int cube = n * n * n;

        lblResult.setText("Cube = " + cube);
    }

   
}
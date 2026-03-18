


import java.awt.event.*;
import javax.swing.*;
public class MouseEventExample implements MouseListener {
    JTextArea txtArea=new JTextArea();
    JLabel lblArea=new JLabel();
    MouseEventExample()
    {
         JFrame f=new JFrame("Mouse Event Example");
        txtArea.setBounds(10, 20, 150, 40);
        f.add(txtArea);
        txtArea.addMouseListener(this);
        lblArea.setBounds(200,20 , 150, 20);
        f.add(lblArea);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
       new MouseEventExample();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    lblArea.setText("Mouse is Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
    lblArea.setText("Mouse is Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    lblArea.setText("Mouse is released");   
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    lblArea.setText("Mouse is Entered");     }

    @Override
    public void mouseExited(MouseEvent e) {
    lblArea.setText("Mouse is Exited");
    }
    
}

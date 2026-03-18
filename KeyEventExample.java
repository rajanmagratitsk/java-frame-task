


import java.awt.event.*;
import javax.swing.*;
public class KeyEventExample implements KeyListener {
    JTextArea txtArea=new JTextArea();
    JLabel lblArea=new JLabel();
    KeyEventExample()
    {  
        JFrame f=new JFrame("Key Event Example");
        txtArea.setBounds(10, 20, 150, 40);
        f.add(txtArea);
        txtArea.addKeyListener(this);
        lblArea.setBounds(200,20 , 150, 20);
        f.add(lblArea);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[])
    {
        new KeyEventExample();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        lblArea.setText("Key is Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
lblArea.setText("Key is Pressed");
        }

    @Override
    public void keyReleased(KeyEvent e) {
lblArea.setText("Key is released");    }
}


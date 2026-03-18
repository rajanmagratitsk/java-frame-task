


import java.awt.event.*;
import javax.swing.*;
public class WindowEventExample implements WindowListener {
    WindowEventExample()
    {
        JFrame f=new JFrame("Window Event Example");
        f.addWindowListener(this);
        
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        new WindowEventExample();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window is opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window is closing"); 
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("window is closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("window is iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("window is deiconified");    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("window is activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("window is deactivated");
        }
    
    
}

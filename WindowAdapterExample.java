
import java.awt.event.*;
import javax.swing.*;
public class WindowAdapterExample extends WindowAdapter 
{
    WindowAdapterExample()
    {
        JFrame f=new JFrame("Window Event Example");
        f.addWindowListener(this);
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    public static void main(String args[]) {
        new WindowAdapterExample();
    }
    public void windowClosing(WindowEvent e) {
        System.out.println("Window is Closing");
    }
}
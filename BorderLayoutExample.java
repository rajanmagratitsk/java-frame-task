package Framejava;




import java.awt.*;
import javax.swing.*;
public class BorderLayoutExample {
    BorderLayoutExample(){
        JFrame f=new JFrame();
        JButton btnNorth=new JButton("NORTH");
        JButton btnSouth=new JButton("SOUTH");
        JButton btnEast=new JButton("EAST");
        JButton btnWest=new JButton("WEST");
        JButton btnCenter=new JButton("CENTER");
        f.add(btnNorth,BorderLayout.NORTH);
        f.add(btnSouth,BorderLayout.SOUTH);
        f.add(btnEast,BorderLayout.EAST);
        f.add(btnWest,BorderLayout.WEST);
        f.add(btnCenter,BorderLayout.CENTER);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public static void main(String[]args){
        new BorderLayoutExample();
    }
        
        
    
}

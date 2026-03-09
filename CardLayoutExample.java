package Framejava;




import java.awt.*;
import javax.swing.*;
public class CardLayoutExample extends Frame{
    static CardLayout c1;
    CardLayoutExample(){
        c1=new CardLayout();
        setLayout(c1);
        JPanel p1=new JPanel();
        p1.setBackground(Color.RED);
        p1.setForeground(Color.BLACK);
        p1.add(new Label("This is Red Panel"));
        add(p1);
        JPanel p2=new JPanel();
        p2.setBackground(Color.GREEN);
        p2.setForeground(Color.BLACK);
        p2.add(new Label("This is Green Panel"));
        add(p2);
        JPanel p3=new JPanel();
        p3.setBackground(Color.YELLOW);
        p3.setForeground(Color.BLACK);
        p3.add(new Label("This is Yellow Label"));
        add(p3);
        setSize(300,200);
        setVisible(true);
        
    }public static void main(String args[]){
        CardLayoutExample first=new CardLayoutExample();
        CardLayoutExample second =new CardLayoutExample();
        c1.next(second);
        CardLayoutExample third =new CardLayoutExample();
        c1.last(third);
    }
    
}

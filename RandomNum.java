package Framejava;

import java.util.Random;
import javax.swing.*;

public class RandomNum {
    public static void main(String[] args) {
        JFrame f=new JFrame("Random");
        JButton b=new JButton("Generate");

        b.addActionListener(e->{
            int r=new Random().nextInt(100);
            JOptionPane.showMessageDialog(f,"Number: "+r);
        });

        f.add(b);
        f.setSize(250,150);
        f.setVisible(true);
    }
}
package Framejava;

import javax.swing.*;

public class ShowPassword {
    public static void main(String[] args) {
        JFrame f=new JFrame("Password");
        JPasswordField p=new JPasswordField();
        JButton b=new JButton("Show");

        p.setBounds(50,30,150,30);
        b.setBounds(80,80,80,30);

        b.addActionListener(e->
            JOptionPane.showMessageDialog(f,new String(p.getPassword()))
        );

        f.add(p); f.add(b);
        f.setSize(250,180);
        f.setLayout(null);
        f.setVisible(true);
    }
}
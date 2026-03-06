package Framejava;
import javax.swing.*;

public class ShowName {
    public static void main(String[] args) {
        JFrame f=new JFrame("Name");
        JTextField t=new JTextField();
        JButton b=new JButton("Show");
        JLabel l=new JLabel();

        t.setBounds(50,30,150,30);
        b.setBounds(210,30,80,30);
        l.setBounds(50,80,200,30);

        b.addActionListener(e->l.setText("Hello "+t.getText()));

        f.add(t);f.add(b);f.add(l);
        f.setSize(350,200);
        f.setLayout(null);
        f.setVisible(true);
    }
}
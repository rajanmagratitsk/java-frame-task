package Framejava;
import javax.swing.*;

public class Doubler {
    public static void main(String[] args) {
        JFrame f = new JFrame("Double Number");
        JTextField t = new JTextField();
        JButton b = new JButton("Double");

        t.setBounds(50,30,200,30);
        b.setBounds(100,80,100,30);

        b.addActionListener(e -> {
            int num = Integer.parseInt(t.getText());
            t.setText(String.valueOf(num*2));
        });

        f.add(t); f.add(b);
        f.setSize(300,200);
        f.setLayout(null);
        f.setVisible(true);
    }
}
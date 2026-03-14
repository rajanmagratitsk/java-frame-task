import javax.swing.*;

public class TextCopy {

    public static void main(String[] args) {

        JFrame f = new JFrame("Text Copier");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();

        JButton copy = new JButton("Copy");

        t1.setBounds(60,50,180,30);
        copy.setBounds(110,100,80,30);
        t2.setBounds(60,150,180,30);

        copy.addActionListener(e -> t2.setText(t1.getText()));

        f.add(t1); f.add(copy); f.add(t2);

        f.setSize(320,250);
        f.setLayout(null);
        f.setVisible(true);
    }
}

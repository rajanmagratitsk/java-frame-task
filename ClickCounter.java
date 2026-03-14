import javax.swing.*;
import java.awt.event.*;

public class ClickCounter {
    static int count = 0;

    public static void main(String[] args) {
        JFrame f = new JFrame("Click Counter");

        JButton btn = new JButton("Click Me");
        JLabel label = new JLabel("Clicks: 0");

        btn.setBounds(100,80,120,30);
        label.setBounds(110,130,100,30);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                count++;
                label.setText("Clicks: " + count);
            }
        });

        f.add(btn);
        f.add(label);

        f.setSize(300,250);
        f.setLayout(null);
        f.setVisible(true);
    }
}
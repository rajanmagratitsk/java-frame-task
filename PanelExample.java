import java.awt.*;
import javax.swing.*;

public class PanelExample {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Panel Example");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));

        // First Panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.CYAN);
        panel1.add(new JLabel("This is Panel 1"));
        panel1.add(new JButton("Button 1"));

        // Second Panel
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.PINK);
        panel2.add(new JLabel("This is Panel 2"));
        panel2.add(new JButton("Button 2"));

        // Add panels to frame
        frame.add(panel1);
        frame.add(panel2);

        frame.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChangeGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Color Changer");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton redBtn = new JButton("Red");
        JButton greenBtn = new JButton("Green");
        JButton blueBtn = new JButton("Blue");

        panel.add(redBtn);
        panel.add(greenBtn);
        panel.add(blueBtn);

        redBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel.setBackground(Color.RED);
            }
        });

        greenBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel.setBackground(Color.GREEN);
            }
        });

        blueBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel.setBackground(Color.BLUE);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
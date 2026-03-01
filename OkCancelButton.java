package Framejava;
import java.awt.*;
import javax.swing.*;

public class OkCancelButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("OK and Cancel");

        JButton okBtn = new JButton("OK");
        JButton cancelBtn = new JButton("Cancel");

        frame.setLayout(new FlowLayout()); // simple layout
        frame.add(okBtn);
        frame.add(cancelBtn);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
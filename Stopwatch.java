package Framejava;
import javax.swing.*;

public class Stopwatch {
    static int seconds = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stopwatch");
        JLabel label = new JLabel("0", SwingConstants.CENTER);
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        Timer timer = new Timer(1000, e -> label.setText("" + (++seconds)));

        frame.setLayout(null);
        label.setBounds(50, 20, 200, 30);
        start.setBounds(50, 60, 80, 30);
        stop.setBounds(140, 60, 80, 30);

        frame.add(label);
        frame.add(start);
        frame.add(stop);

        start.addActionListener(e -> timer.start());
        stop.addActionListener(e -> timer.stop());

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
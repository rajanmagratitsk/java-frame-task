import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGUI extends JFrame {

    JLabel timeLabel;

    TimeGUI() {
        setTitle("Digital Clock");
        setSize(300,150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));

        add(timeLabel);
        setVisible(true);

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(new Date());
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        new TimeGUI();
    }
}
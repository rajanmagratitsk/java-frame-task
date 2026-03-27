import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;

public class TimeFrame extends Frame implements ActionListener {

    Label l1;
    Button b1;

    TimeFrame() {
        setTitle("Current Time");
        setSize(300, 150);
        setLayout(new FlowLayout());

        l1 = new Label("Click button to see time");
        b1 = new Button("Show Time");

        add(l1);
        add(b1);

        b1.addActionListener(this);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        LocalTime time = LocalTime.now();
        l1.setText("Time: " + time.toString());
    }

    public static void main(String[] args) {
        new TimeFrame();
    }
}
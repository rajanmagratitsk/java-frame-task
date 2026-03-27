import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.util.Random;

public class LiveClock extends Frame implements Runnable {

    Label l1;
    Thread t;
    Random r = new Random();

    LiveClock() {
        setTitle("Live Digital Clock");
        setSize(400, 200);
        setLayout(new FlowLayout());

        l1 = new Label();
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        add(l1);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Start thread
        t = new Thread(this);
        t.start();

        setVisible(true);
    }

    public void run() {
        while (true) {
            try {
                // Get current time
                LocalTime time = LocalTime.now();
                l1.setText("Time: " + time.toString());

                // Change background color randomly
                setBackground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

                Thread.sleep(1000); // update every second

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new LiveClock();
    }
}
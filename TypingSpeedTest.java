import java.awt.*;
import java.awt.event.*;

public class TypingSpeedTest extends Frame implements KeyListener, ActionListener {

    Label l1, l2, l3;
    TextField t1;
    Button b1;

    long startTime, endTime;

    TypingSpeedTest() {
        setTitle("Typing Speed Tester");
        setSize(500, 200);
        setLayout(new FlowLayout());

        l1 = new Label("Type this: I love Java programming");
        l2 = new Label("Start typing...");
        l3 = new Label("");

        t1 = new TextField(30);
        b1 = new Button("Reset");

        add(l1);
        add(t1);
        add(l2);
        add(l3);
        add(b1);

        t1.addKeyListener(this);
        b1.addActionListener(this);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        if (t1.getText().length() == 0) {
            startTime = System.currentTimeMillis();
        }
    }

    public void keyReleased(KeyEvent e) {
        String target = "I love Java programming";
        String typed = t1.getText();

        if (typed.equals(target)) {
            endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;

            l2.setText("Completed in " + timeTaken + " seconds");

            double wpm = (typed.length() / 5.0) / (timeTaken / 60.0);
            l3.setText("Typing Speed: " + (int)wpm + " WPM");

            setBackground(Color.GREEN);
        }
    }

    public void actionPerformed(ActionEvent e) {
        t1.setText("");
        l2.setText("Start typing...");
        l3.setText("");
        setBackground(Color.WHITE);
    }

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new TypingSpeedTest();
    }
}
import java.awt.*;
import java.awt.event.*;

class EssayFrame extends Frame implements ActionListener {

    Button b1, b2, b3, clear;
    TextArea ta;

    EssayFrame() {
        setTitle("Essay Viewer - Rajan");
        setSize(600, 400);
        setLayout(null);

        // Buttons
        b1 = new Button("Discipline");
        b1.setBounds(50, 60, 100, 30);
        add(b1);

        b2 = new Button("Health");
        b2.setBounds(170, 60, 100, 30);
        add(b2);

        b3 = new Button("Sports");
        b3.setBounds(290, 60, 100, 30);
        add(b3);

        clear = new Button("Clear");
        clear.setBounds(410, 60, 80, 30);
        add(clear);

        // TextArea
        ta = new TextArea();
        ta.setBounds(50, 120, 500, 200);
        add(ta);

        // Events
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        clear.addActionListener(this);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            ta.setText("Discipline\n\nDiscipline is the key to success in life. "
                    + "It teaches us to follow rules and maintain order. "
                    + "A disciplined person respects time and works sincerely. "
                    + "Students who are disciplined achieve their goals easily. "
                    + "Without discipline, life becomes disorganized and difficult.");
        }

        if (e.getSource() == b2) {
            ta.setText("Health\n\nHealth is wealth. A healthy person can enjoy life fully. "
                    + "Good health depends on proper diet, exercise, and rest. "
                    + "We should eat nutritious food and avoid junk food. "
                    + "Regular exercise keeps our body fit and active. "
                    + "Without good health, we cannot work properly.");
        }

        if (e.getSource() == b3) {
            ta.setText("Sports\n\nSports are important for physical and mental development. "
                    + "They keep us fit and teach teamwork and discipline. "
                    + "Playing sports reduces stress and increases confidence. "
                    + "Students should participate in sports regularly. "
                    + "Sports also promote unity and friendship.");
        }

        if (e.getSource() == clear) {
            ta.setText("");
        }
    }

    public static void main(String[] args) {
        new EssayFrame();
    }
}

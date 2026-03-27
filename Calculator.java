import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {

    TextField t1;
    Button b1, b2, b3, b4, b5;

    Calculator() {
        // Frame setup
        setTitle("Simple Calculator");
        setSize(300, 200);
        setLayout(new FlowLayout());

        // TextField
        t1 = new TextField(20);
        add(t1);

        // Buttons
        b1 = new Button("+");
        b2 = new Button("-");
        b3 = new Button("*");
        b4 = new Button("/");
        b5 = new Button("Clear");

        add(b1); add(b2); add(b3); add(b4); add(b5);

        // Action Listener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String input = t1.getText();

            // Split numbers using operator
            if (input.contains("+")) {
                String[] num = input.split("\\+");
                int result = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
                t1.setText(String.valueOf(result));
            }
            else if (input.contains("-")) {
                String[] num = input.split("-");
                int result = Integer.parseInt(num[0]) - Integer.parseInt(num[1]);
                t1.setText(String.valueOf(result));
            }
            else if (input.contains("*")) {
                String[] num = input.split("\\*");
                int result = Integer.parseInt(num[0]) * Integer.parseInt(num[1]);
                t1.setText(String.valueOf(result));
            }
            else if (input.contains("/")) {
                String[] num = input.split("/");
                int result = Integer.parseInt(num[0]) / Integer.parseInt(num[1]);
                t1.setText(String.valueOf(result));
            }
            else if (e.getSource() == b5) {
                t1.setText("");
            }

        } catch (Exception ex) {
            t1.setText("Error");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
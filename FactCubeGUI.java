package Framejava;

import java.awt.*;
import java.awt.event.*;

public class FactCubeGUI extends Frame implements MouseListener {

    TextField tf;
    Label result;
    Button btn;

    FactCubeGUI() {
        // Create components
        tf = new TextField(10);
        result = new Label("Result: ");
        btn = new Button("Result");

        // Set layout
        setLayout(new FlowLayout());

        // Add components
        add(new Label("Enter Number:"));
        add(tf);
        add(btn);
        add(result);

        // Add mouse listener to button
        btn.addMouseListener(this);

        // Frame settings
        setSize(300, 200);
        setVisible(true);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    // Factorial method
    int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++)
            f *= i;
        return f;
    }

    // Mouse pressed → Factorial
    public void mousePressed(MouseEvent e) {
        int n = Integer.parseInt(tf.getText());
        result.setText("Factorial: " + factorial(n));
    }

    // Mouse released → Cube
    public void mouseReleased(MouseEvent e) {
        int n = Integer.parseInt(tf.getText());
        result.setText("Cube: " + (n * n * n));
    }

    // Unused mouse methods
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new FactCubeGUI();
    }
}

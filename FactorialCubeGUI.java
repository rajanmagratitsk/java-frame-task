import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FactorialCubeGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Factorial & Cube");

        // Components
        JLabel l1 = new JLabel("Enter Number:");
        JTextField t1 = new JTextField();
        JLabel result = new JLabel("Result:");
        JButton b = new JButton("Result");

        // Layout
        f.setLayout(new GridLayout(3, 2, 10, 10));

        f.add(l1); f.add(t1);
        f.add(result); f.add(new JLabel(""));
        f.add(new JLabel("")); f.add(b);

        // Mouse events
        b.addMouseListener(new MouseListener() {

            // When mouse is pressed → Factorial
            public void mousePressed(MouseEvent e) {
                int n = Integer.parseInt(t1.getText());
                int fact = 1;

                for(int i = 1; i <= n; i++) {
                    fact = fact * i;
                }

                result.setText("Factorial: " + fact);
            }

            // When mouse is released → Cube
            public void mouseReleased(MouseEvent e) {
                int n = Integer.parseInt(t1.getText());
                int cube = n * n * n;

                result.setText("Cube: " + cube);
            }

            // Unused methods (must be written)
            public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        // Frame settings
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
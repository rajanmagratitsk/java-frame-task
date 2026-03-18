import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloSwing extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello, Rajan!", 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new HelloSwing());
        frame.setVisible(true);
    }
}
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class ColorFrame extends Frame implements ActionListener {

    Button changeColorBtn, exitBtn;
    Label message;
    Random rand;

    ColorFrame() {
        // Frame settings
        setTitle("Rajan's Color Frame");
        setSize(400, 300);
        setLayout(null);

        rand = new Random();

        // Label
        message = new Label("Click button to change background!");
        message.setBounds(80, 80, 250, 30);
        add(message);

        // Change Color Button
        changeColorBtn = new Button("Change Color");
        changeColorBtn.setBounds(80, 150, 100, 30);
        changeColorBtn.addActionListener(this);
        add(changeColorBtn);

        // Exit Button
        exitBtn = new Button("Exit");
        exitBtn.setBounds(200, 150, 80, 30);
        exitBtn.addActionListener(this);
        add(exitBtn);

        // Window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    // Button click logic
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeColorBtn) {
            // Generate random color
            Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            setBackground(c);
            message.setText("Color changed!");
        }

        if (e.getSource() == exitBtn) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new ColorFrame();
    }
}
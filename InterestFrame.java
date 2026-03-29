import java.awt.event.*;
import javax.swing.*;

public class InterestFrame extends JFrame implements ActionListener {
    JTextField p, r, t, res;
    JButton calc;

    InterestFrame() {
        setSize(300,250);
        setLayout(null);

        p = new JTextField();
        r = new JTextField();
        t = new JTextField();
        res = new JTextField();
        calc = new JButton("Calculate");

        p.setBounds(50,30,150,25);
        r.setBounds(50,70,150,25);
        t.setBounds(50,110,150,25);
        res.setBounds(50,150,150,25);
        calc.setBounds(80,190,100,30);

        add(p); add(r); add(t); add(res); add(calc);

        calc.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double P = Double.parseDouble(p.getText());
        double R = Double.parseDouble(r.getText());
        double T = Double.parseDouble(t.getText());

        double SI = (P * R * T) / 100;
        res.setText("SI = " + SI);
    }

    public static void main(String[] args) {
        new InterestFrame();
    }
}
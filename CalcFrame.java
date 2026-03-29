import java.awt.event.*;
import javax.swing.*;

public class CalcFrame extends JFrame implements ActionListener {
    JTextField t1, t2, result;
    JButton add, sub, mul, div;

    CalcFrame() {
        setSize(300,300);
        setLayout(null);

        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();

        t1.setBounds(50,30,150,25);
        t2.setBounds(50,70,150,25);
        result.setBounds(50,110,150,25);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");

        add.setBounds(30,160,50,30);
        sub.setBounds(90,160,50,30);
        mul.setBounds(150,160,50,30);
        div.setBounds(210,160,50,30);

        add(add); add(sub); add(mul); add(div);
        add(t1); add(t2); add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());

        if(e.getSource()==add) result.setText(""+(a+b));
        if(e.getSource()==sub) result.setText(""+(a-b));
        if(e.getSource()==mul) result.setText(""+(a*b));
        if(e.getSource()==div) result.setText(""+(a/b));
    }

    public static void main(String[] args) {
        new CalcFrame();
    }
}
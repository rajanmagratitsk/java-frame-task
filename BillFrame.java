import java.awt.event.*;
import javax.swing.*;

public class BillFrame extends JFrame implements ActionListener {
    JCheckBox pizza, burger, coke;
    JButton total;
    JLabel result;

    BillFrame() {
        setSize(300,300);
        setLayout(null);

        pizza = new JCheckBox("Pizza 200");
        burger = new JCheckBox("Burger 150");
        coke = new JCheckBox("Coke 50");

        total = new JButton("Total");
        result = new JLabel();

        pizza.setBounds(50,50,150,25);
        burger.setBounds(50,80,150,25);
        coke.setBounds(50,110,150,25);

        total.setBounds(80,150,100,30);
        result.setBounds(50,200,200,25);

        add(pizza); add(burger); add(coke);
        add(total); add(result);

        total.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int sum = 0;

        if(pizza.isSelected()) sum += 200;
        if(burger.isSelected()) sum += 150;
        if(coke.isSelected()) sum += 50;

        result.setText("Total = " + sum);
    }

    public static void main(String[] args) {
        new BillFrame();
    }
}
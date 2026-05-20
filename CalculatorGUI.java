import javax.swing.*;
import java.awt.event.*;

public class CalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator with Logic Ops");
        JLabel lbl1 = new JLabel("First number:");
        JLabel lbl2 = new JLabel("Second number:");
        JTextField txt1 = new JTextField();
        JTextField txt2 = new JTextField();

        String[] operations = {"+", "-", "*", "/", "AND", "OR", "XOR"};
        JComboBox<String> combo = new JComboBox<>(operations);
        JButton btn = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result: ");

        lbl1.setBounds(20, 20, 100, 30);
        lbl2.setBounds(20, 60, 100, 30);
        txt1.setBounds(130, 20, 100, 30);
        txt2.setBounds(130, 60, 100, 30);
        combo.setBounds(20, 100, 100, 30);
        btn.setBounds(130, 100, 100, 30);
        resultLabel.setBounds(20, 150, 250, 30);

        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(txt1);
        frame.add(txt2);
        frame.add(combo);
        frame.add(btn);
        frame.add(resultLabel);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(txt1.getText());
                    int b = Integer.parseInt(txt2.getText());
                    String op = (String) combo.getSelectedItem();
                    int logicResult = 0;
                    double mathResult = 0.0;

                    switch(op) {
                        case "+": mathResult = a + b; resultLabel.setText("Result: " + mathResult); break;
                        case "-": mathResult = a - b; resultLabel.setText("Result: " + mathResult); break;
                        case "*": mathResult = a * b; resultLabel.setText("Result: " + mathResult); break;
                        case "/": 
                            if(b != 0) mathResult = (double)a / b;
                            else { resultLabel.setText("Error: Division by zero"); return; }
                            resultLabel.setText("Result: " + mathResult); break;
                        case "AND": logicResult = a & b; resultLabel.setText("Result: " + logicResult); break;
                        case "OR":  logicResult = a | b; resultLabel.setText("Result: " + logicResult); break;
                        case "XOR": logicResult = a ^ b; resultLabel.setText("Result: " + logicResult); break;
                    }
                } catch(NumberFormatException ex) {
                    resultLabel.setText("Error: Enter valid integers");
                }
            }
        });

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

import javax.swing.*;

public class MultiplyGUI {

    public static void main(String[] args) {

        JFrame f = new JFrame("Multiplication Tool");

        JTextField n1 = new JTextField();
        JTextField n2 = new JTextField();
        JTextField result = new JTextField();

        JButton mul = new JButton("Multiply");

        n1.setBounds(70,40,150,30);
        n2.setBounds(70,80,150,30);
        mul.setBounds(90,120,100,30);
        result.setBounds(70,170,150,30);

        mul.addActionListener(e -> {
            int a = Integer.parseInt(n1.getText());
            int b = Integer.parseInt(n2.getText());
            result.setText(""+(a*b));
        });

        f.add(n1); f.add(n2);
        f.add(mul); f.add(result);

        f.setSize(300,260);
        f.setLayout(null);
        f.setVisible(true);
    }
}
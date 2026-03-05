package Framejava;

import javax.swing.*;

public class SimpleQuiz {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz");
        JLabel question = new JLabel("What is 5 + 3?");
        JButton opt1 = new JButton("6");
        JButton opt2 = new JButton("8");
        JLabel result = new JLabel("");

        frame.setLayout(null);
        question.setBounds(50, 20, 200, 30);
        opt1.setBounds(50, 60, 80, 30);
        opt2.setBounds(140, 60, 80, 30);
        result.setBounds(50, 100, 200, 30);

        frame.add(question);
        frame.add(opt1);
        frame.add(opt2);
        frame.add(result);

        opt1.addActionListener(e -> result.setText("Wrong!"));
        opt2.addActionListener(e -> result.setText("Correct!"));

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
package Framejava;

import java.util.Random;
import javax.swing.*;

public class Magic8Ball {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Magic 8-Ball");
        frame.setSize(300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField questionField = new JTextField(15);
        JButton askButton = new JButton("Ask");
        JLabel answerLabel = new JLabel("Answer: -", JLabel.CENTER);

        String[] answers = {"Yes", "No", "Maybe", "Ask later", "Definitely"};

        askButton.addActionListener(e -> {
            Random rand = new Random();
            answerLabel.setText("Answer: " + answers[rand.nextInt(answers.length)]);
        });

        JPanel panel = new JPanel();
        panel.add(questionField);
        panel.add(askButton);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(panel);
        frame.add(answerLabel);
        frame.setVisible(true);
    }
}
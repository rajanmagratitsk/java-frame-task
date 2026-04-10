import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class GuessGame extends Frame implements ActionListener {

    Label title, msg, attemptsLabel;
    TextField input;
    Button guessBtn, resetBtn;
    
    int number, attempts;
    Random rand;

    GuessGame() {
        setTitle("Guess The Number Game - Rajan");
        setSize(500, 300);
        setLayout(null);

        rand = new Random();
        number = rand.nextInt(100) + 1;
        attempts = 0;

        // Title
        title = new Label("Guess a number (1-100)");
        title.setBounds(150, 60, 200, 30);
        add(title);

        // Input
        input = new TextField();
        input.setBounds(180, 100, 120, 25);
        add(input);

        // Guess Button
        guessBtn = new Button("Guess");
        guessBtn.setBounds(150, 140, 80, 30);
        guessBtn.addActionListener(this);
        add(guessBtn);

        // Reset Button
        resetBtn = new Button("Reset");
        resetBtn.setBounds(250, 140, 80, 30);
        resetBtn.addActionListener(this);
        add(resetBtn);

        // Message
        msg = new Label("");
        msg.setBounds(150, 180, 250, 30);
        add(msg);

        // Attempts
        attemptsLabel = new Label("Attempts: 0");
        attemptsLabel.setBounds(180, 210, 150, 30);
        add(attemptsLabel);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == guessBtn) {
            try {
                int guess = Integer.parseInt(input.getText());
                attempts++;

                if (guess < number) {
                    msg.setText("Too Low! Try again.");
                } else if (guess > number) {
                    msg.setText("Too High! Try again.");
                } else {
                    msg.setText("🎉 Correct! You guessed it!");
                }

                attemptsLabel.setText("Attempts: " + attempts);

            } catch (Exception ex) {
                msg.setText("Enter valid number!");
            }
        }

        if (e.getSource() == resetBtn) {
            number = rand.nextInt(100) + 1;
            attempts = 0;
            msg.setText("");
            attemptsLabel.setText("Attempts: 0");
            input.setText("");
        }
    }

    public static void main(String[] args) {
        new GuessGame();
    }
}

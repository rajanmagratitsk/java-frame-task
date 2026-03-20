import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovieApp {
    public static void main(String[] args) {

        JFrame f = new JFrame("Movie Application");

        // Title
        JLabel title = new JLabel("Movie Library");
        title.setBounds(130, 10, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        // Movie list
        String movies[] = {"Avengers", "Inception", "Interstellar", "Joker", "Titanic"};
        JList<String> movieList = new JList<>(movies);
        JScrollPane sp = new JScrollPane(movieList);
        sp.setBounds(50, 50, 300, 100);

        // Button
        JButton btn = new JButton("Watch");
        btn.setBounds(140, 170, 100, 30);

        // Output label
        JLabel result = new JLabel("");
        result.setBounds(80, 220, 250, 30);

        // Button event
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = movieList.getSelectedValue();
                if (selected != null) {
                    result.setText("Now Playing: " + selected);
                } else {
                    result.setText("Please select a movie");
                }
            }
        });

        // Add components
        f.add(title);
        f.add(sp);
        f.add(btn);
        f.add(result);

        f.setSize(400, 350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
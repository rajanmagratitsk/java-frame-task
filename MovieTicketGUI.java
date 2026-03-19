import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovieTicketGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Movie Ticket Booking");

        // Components
        JLabel l1 = new JLabel("Select Movie:");
        String movies[] = {"KGF", "Leo", "Jawan"};
        JComboBox cb = new JComboBox(movies);

        JLabel l2 = new JLabel("Number of Tickets:");
        JTextField t1 = new JTextField();

        JButton b = new JButton("Book Ticket");

        // Layout
        f.setLayout(new GridLayout(3, 2, 10, 10));

        f.add(l1); f.add(cb);
        f.add(l2); f.add(t1);
        f.add(new JLabel("")); f.add(b);

        // Button action
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String movie = (String) cb.getSelectedItem();
                int tickets = Integer.parseInt(t1.getText());

                int price = 200; // per ticket
                int total = tickets * price;

                JOptionPane.showMessageDialog(f,
                    "Movie: " + movie +
                    "\nTickets: " + tickets +
                    "\nTotal Price: Rs. " + total
                );
            }
        });

        // Frame settings
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
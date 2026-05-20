import javax.swing.*;
import java.awt.event.*;

public class BusTicketSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bus Ticket System");

        JLabel lblName = new JLabel("Passenger Name:");
        JLabel lblDestination = new JLabel("Destination:");
        JLabel lblSeat = new JLabel("Seat Type:");
        JLabel lblTickets = new JLabel("No. of Tickets:");
        JLabel lblResult = new JLabel("Total Fare: ");

        JTextField txtName = new JTextField();
        JTextField txtTickets = new JTextField();

        String[] destinations = {"Kathmandu", "Pokhara", "Chitwan"};
        JComboBox<String> cbDestination = new JComboBox<>(destinations);

        String[] seatTypes = {"Normal", "AC", "Luxury"};
        JComboBox<String> cbSeat = new JComboBox<>(seatTypes);

        JButton btnBook = new JButton("Book Ticket");

        lblName.setBounds(20, 20, 120, 30);
        txtName.setBounds(150, 20, 150, 30);

        lblDestination.setBounds(20, 60, 120, 30);
        cbDestination.setBounds(150, 60, 150, 30);

        lblSeat.setBounds(20, 100, 120, 30);
        cbSeat.setBounds(150, 100, 150, 30);

        lblTickets.setBounds(20, 140, 120, 30);
        txtTickets.setBounds(150, 140, 150, 30);

        btnBook.setBounds(100, 190, 120, 30);
        lblResult.setBounds(20, 230, 300, 30);

        frame.add(lblName);
        frame.add(txtName);
        frame.add(lblDestination);
        frame.add(cbDestination);
        frame.add(lblSeat);
        frame.add(cbSeat);
        frame.add(lblTickets);
        frame.add(txtTickets);
        frame.add(btnBook);
        frame.add(lblResult);

        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = txtName.getText();
                    String destination = (String) cbDestination.getSelectedItem();
                    String seat = (String) cbSeat.getSelectedItem();
                    int tickets = Integer.parseInt(txtTickets.getText());

                    int fare = 0;
                    switch(destination) {
                        case "Kathmandu": fare = 300; break;
                        case "Pokhara": fare = 500; break;
                        case "Chitwan": fare = 400; break;
                    }

                    switch(seat) {
                        case "Normal": fare += 0; break;
                        case "AC": fare += 200; break;
                        case "Luxury": fare += 400; break;
                    }

                    int total = fare * tickets;
                    lblResult.setText("Passenger: " + name + " | Total Fare: Rs. " + total);
                } catch(NumberFormatException ex) {
                    lblResult.setText("Error: Enter valid ticket number");
                }
            }
        });

        frame.setSize(400, 320);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

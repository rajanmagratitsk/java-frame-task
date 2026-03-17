package Framejava;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FlightBookingSystem {
    public static void main(String[] args) {

        JFrame f = new JFrame("Flight Booking System");
        f.setSize(350, 250);
        f.setLayout(new FlowLayout());

        JLabel l1 = new JLabel("Passenger Name:");
        JTextField t1 = new JTextField(15);

        JLabel l2 = new JLabel("Flight Number:");
        JTextField t2 = new JTextField(15);

        JLabel l3 = new JLabel("Seat Preference:");
        String seats[] = {"Window", "Aisle", "Middle"};
        JComboBox<String> cb = new JComboBox<>(seats);

        JCheckBox check = new JCheckBox("I agree to baggage rules");

        JButton btn = new JButton("Confirm Booking");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (check.isSelected()) {
                    try {
                        FileWriter fw = new FileWriter("flight.txt", true);
                        fw.write("Name: " + t1.getText() + "\n");
                        fw.write("Flight No: " + t2.getText() + "\n");
                        fw.write("Seat: " + cb.getSelectedItem() + "\n\n");
                        fw.close();

                        JOptionPane.showMessageDialog(f, "Saved!");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Accept baggage rules first.");
                }
            }
        });

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(l3); f.add(cb);
        f.add(check);
        f.add(btn);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
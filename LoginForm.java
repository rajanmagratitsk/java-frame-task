package Framejava;

import java.awt.*;
import javax.swing.*;

public class LoginForm {
    public static void main(String[] args) {

        JFrame f = new JFrame("Login Form");

        JLabel lblUser = new JLabel("Username:");
        JLabel lblPass = new JLabel("Password:");

        JTextField txtUser = new JTextField(15);
        JPasswordField txtPass = new JPasswordField(15);

        JButton btnLogin = new JButton("Login");
        JButton btnCancel = new JButton("Cancel");

        f.setLayout(new GridLayout(3, 2, 10, 10));

        f.add(lblUser);
        f.add(txtUser);
        f.add(lblPass);
        f.add(txtPass);
        f.add(btnLogin);
        f.add(btnCancel);

        f.setSize(100, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
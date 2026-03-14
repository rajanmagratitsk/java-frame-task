import javax.swing.*;

public class PasswordChecker {

    public static void main(String[] args) {

        JFrame f = new JFrame("Login");

        JPasswordField pass = new JPasswordField();
        JButton login = new JButton("Login");
        JLabel msg = new JLabel();

        pass.setBounds(80,60,150,30);
        login.setBounds(110,110,80,30);
        msg.setBounds(90,160,200,30);

        login.addActionListener(e -> {
            String p = new String(pass.getPassword());

            if(p.equals("java123"))
                msg.setText("Access Granted");
            else
                msg.setText("Wrong Password");
        });

        f.add(pass); f.add(login); f.add(msg);

        f.setSize(320,250);
        f.setLayout(null);
        f.setVisible(true);
    }
}
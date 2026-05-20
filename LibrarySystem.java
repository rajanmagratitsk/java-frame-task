import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibrarySystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Library Management System");

        JLabel lblTitle = new JLabel("Book Title:");
        JLabel lblAuthor = new JLabel("Author:");
        JLabel lblYear = new JLabel("Year:");
        JLabel lblResult = new JLabel("Library Records:");

        JTextField txtTitle = new JTextField();
        JTextField txtAuthor = new JTextField();
        JTextField txtYear = new JTextField();

        JButton btnAdd = new JButton("Add Book");
        JTextArea txtArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtArea);

        ArrayList<String> library = new ArrayList<>();

        lblTitle.setBounds(20, 20, 100, 30);
        txtTitle.setBounds(130, 20, 150, 30);

        lblAuthor.setBounds(20, 60, 100, 30);
        txtAuthor.setBounds(130, 60, 150, 30);

        lblYear.setBounds(20, 100, 100, 30);
        txtYear.setBounds(130, 100, 150, 30);

        btnAdd.setBounds(100, 140, 120, 30);

        lblResult.setBounds(20, 180, 150, 30);
        scroll.setBounds(20, 210, 300, 150);

        frame.add(lblTitle);
        frame.add(txtTitle);
        frame.add(lblAuthor);
        frame.add(txtAuthor);
        frame.add(lblYear);
        frame.add(txtYear);
        frame.add(btnAdd);
        frame.add(lblResult);
        frame.add(scroll);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText();
                String author = txtAuthor.getText();
                String year = txtYear.getText();

                if(title.isEmpty() || author.isEmpty() || year.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!");
                    return;
                }

                String record = "Title: " + title + ", Author: " + author + ", Year: " + year;
                library.add(record);

                txtArea.setText("");
                for(String book : library) {
                    txtArea.append(book + "\n");
                }

                txtTitle.setText("");
                txtAuthor.setText("");
                txtYear.setText("");
            }
        });

        frame.setSize(360, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentFrame extends JFrame implements ActionListener {

    JTextField nameField;
    JComboBox<String> courseBox;
    JRadioButton male, female;
    JCheckBox java, python, web;
    JButton submit;
    JLabel result;

    public StudentFrame() {
        setTitle("Student Utility App");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 150, 25);
        add(nameField);

        // Course Dropdown
        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(30, 70, 100, 25);
        add(courseLabel);

        String courses[] = {"BCA", "BIT", "BIM", "CSIT"};
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(150, 70, 150, 25);
        add(courseBox);

        // Gender Radio Buttons
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 110, 100, 25);
        add(genderLabel);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        male.setBounds(150, 110, 70, 25);
        female.setBounds(220, 110, 80, 25);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        add(male);
        add(female);

        // Skills Checkboxes
        JLabel skillLabel = new JLabel("Skills:");
        skillLabel.setBounds(30, 150, 100, 25);
        add(skillLabel);

        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        web = new JCheckBox("Web");

        java.setBounds(150, 150, 70, 25);
        python.setBounds(220, 150, 80, 25);
        web.setBounds(300, 150, 70, 25);

        add(java);
        add(python);
        add(web);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(150, 200, 100, 30);
        add(submit);

        submit.addActionListener(this);

        // Result Label
        result = new JLabel();
        result.setBounds(30, 250, 350, 50);
        add(result);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String course = (String) courseBox.getSelectedItem();

        String gender = "";
        if (male.isSelected()) gender = "Male";
        else if (female.isSelected()) gender = "Female";

        String skills = "";
        if (java.isSelected()) skills += "Java ";
        if (python.isSelected()) skills += "Python ";
        if (web.isSelected()) skills += "Web ";

        result.setText("Name: " + name + ", Course: " + course +
                ", Gender: " + gender + ", Skills: " + skills);
    }

    public static void main(String[] args) {
        new StudentFrame();
    }
}
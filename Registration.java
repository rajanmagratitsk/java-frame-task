/*Write a program to create the following simple GUI based application. If user press the submit button, your program should 
store the information in a file named "exam.txt" only when he accepts the terms and condition otherwise it should display
the message"please accept the terms and conditions"*/

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
public class Registration {
    Registration()
    {
        JFrame f = new JFrame("Registration Form");
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10,10,100,20);
        f.add(lblName);
        JTextField txtName = new JTextField();
        txtName.setBounds(100,10,200,20);
        f.add(txtName);
        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(10,40,100,20);
        f.add(lblMobile);
        JTextField txtMobile = new JTextField();
        txtMobile.setBounds(100,40,200,20);
        f.add(txtMobile);
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(10,70,100,20);
        f.add(lblGender);
        JRadioButton txtMale = new JRadioButton("Male");
        txtMale.setBounds(100,70,60,20);
        f.add(txtMale);
        JRadioButton txtFemale = new JRadioButton("Female");
        txtFemale.setBounds(170,70,70,20);
        f.add(txtFemale);
        ButtonGroup btn = new ButtonGroup();
        btn.add(txtMale);
        btn.add(txtFemale);
        JLabel lblDob = new JLabel("Date of Birth");
        lblDob.setBounds(10,100,100,20);
        f.add(lblDob);
        JComboBox dayComboBox=new JComboBox();
        for(int i=1;i<=31;i++){
            dayComboBox.addItem(i);
        }
        dayComboBox.setBounds(100, 100, 40, 20);
        
        f.add(dayComboBox);
        JComboBox monthComboBox=new JComboBox();
        String months[]={"January","February","March","April","May","June",
                         "July","August","September","October","November","December"};
        for(String month:months){
            monthComboBox.addItem(month);
        }
        monthComboBox.setBounds(160, 100, 90, 20);
        f.add(monthComboBox);
        JComboBox yearComboBox=new JComboBox();
        for(int i=1950;i<=2026;i++){
            yearComboBox.addItem(i);
        }
        yearComboBox.setBounds(260, 100, 90, 20);
        f.add(yearComboBox);
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(10,140,100,20);
        f.add(lblAddress);
        JTextArea txtAddress = new JTextArea();
        txtAddress.setBounds(100,140,200,20);
        f.add(txtAddress);
        JCheckBox chCondition = new JCheckBox("Please Accept the terms and Conditions");
        chCondition.setBounds(40,180,300,20);
        f.add(chCondition);
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(100,240,100,20);
        f.add(btnSubmit);
        f.setSize(500,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnSubmit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if(chCondition.isSelected()){
                    String name = txtName.getText();
                    String mobile = txtMobile.getText();
                    String gender = txtMale.isSelected()?"Male":"Female";
                    String dob = yearComboBox.getSelectedItem()+":"
                            +monthComboBox.getSelectedItem()+":"
                            +dayComboBox.getSelectedItem();
                    String address = txtAddress.getText();
                    try(FileWriter out=new FileWriter("E:\\exam.txt",true))
                    {
                        out.write("\nName: "+name+"\nMobile: "+mobile+"\nGender: "+gender+"\nDob:"+dob
                                +"\nAddress:"+address);
                    }
                    catch(IOException e)
                    {
                        System.out.println(e);
                    }   
                    JOptionPane.showMessageDialog(f,"Registration Successful");
            }
            else
                    JOptionPane.showMessageDialog(f,"Please accept the terms and condition");
            }        
        });
    } 
    public static void main(String args[])
    {
        new Registration();
    }        
}
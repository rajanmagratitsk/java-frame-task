import java.awt.*;
import java.awt.event.*;

class LaptopShop extends Frame implements ActionListener {

    Checkbox dell, hp, lenovo;
    Checkbox mouse, bag, keyboard;
    Button totalBtn, resetBtn;
    Label result;

    LaptopShop() {
        setTitle("Rajan's Laptop Shop");
        setSize(500, 400);
        setLayout(null);

        // Laptop Section
        Label laptopLabel = new Label("Select Laptop:");
        laptopLabel.setBounds(50, 60, 150, 20);
        add(laptopLabel);

        CheckboxGroup laptops = new CheckboxGroup();

        dell = new Checkbox("Dell - Rs 70000", laptops, false);
        dell.setBounds(50, 90, 200, 20);
        add(dell);

        hp = new Checkbox("HP - Rs 65000", laptops, false);
        hp.setBounds(50, 120, 200, 20);
        add(hp);

        lenovo = new Checkbox("Lenovo - Rs 60000", laptops, false);
        lenovo.setBounds(50, 150, 200, 20);
        add(lenovo);

        // Accessories Section
        Label accLabel = new Label("Accessories:");
        accLabel.setBounds(300, 60, 150, 20);
        add(accLabel);

        mouse = new Checkbox("Mouse - Rs 500");
        mouse.setBounds(300, 90, 150, 20);
        add(mouse);

        bag = new Checkbox("Bag - Rs 1500");
        bag.setBounds(300, 120, 150, 20);
        add(bag);

        keyboard = new Checkbox("Keyboard - Rs 2000");
        keyboard.setBounds(300, 150, 180, 20);
        add(keyboard);

        // Buttons
        totalBtn = new Button("Calculate Total");
        totalBtn.setBounds(100, 220, 130, 30);
        totalBtn.addActionListener(this);
        add(totalBtn);

        resetBtn = new Button("Reset");
        resetBtn.setBounds(260, 220, 80, 30);
        resetBtn.addActionListener(this);
        add(resetBtn);

        // Result Label
        result = new Label("Total: Rs 0");
        result.setBounds(180, 280, 200, 30);
        add(result);

        // Close Window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int total = 0;

        // Laptop price
        if (dell.getState()) total += 70000;
        if (hp.getState()) total += 65000;
        if (lenovo.getState()) total += 60000;

        // Accessories price
        if (mouse.getState()) total += 500;
        if (bag.getState()) total += 1500;
        if (keyboard.getState()) total += 2000;

        if (e.getSource() == totalBtn) {
            result.setText("Total: Rs " + total);
        }

        if (e.getSource() == resetBtn) {
            dell.setState(false);
            hp.setState(false);
            lenovo.setState(false);
            mouse.setState(false);
            bag.setState(false);
            keyboard.setState(false);
            result.setText("Total: Rs 0");
        }
    }

    public static void main(String[] args) {
        new LaptopShop();
    }
}
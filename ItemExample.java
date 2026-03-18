import java.awt.*;
import java.awt.event.*;

public class ItemExample extends Frame implements ItemListener {
    Checkbox cb1, cb2;

    ItemExample() {
        cb1 = new Checkbox("Option 1");
        cb2 = new Checkbox("Option 2");

        cb1.addItemListener(this);
        cb2.addItemListener(this);

        setLayout(new FlowLayout());
        add(cb1);
        add(cb2);

        setSize(300, 100);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        System.out.println(((Checkbox)e.getSource()).getLabel() + 
            " is " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
    }

    public static void main(String[] args) {
        new ItemExample();
    }
}
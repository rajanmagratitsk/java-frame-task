import java.awt.*;
import java.awt.event.*;

public class TextEventExample extends Frame implements TextListener {
    TextField tf;

    TextEventExample() {
        tf = new TextField(20);
        tf.addTextListener(this);
        add(tf);
        setLayout(new FlowLayout());
        setSize(300, 100);
        setVisible(true);
    }

    public void textValueChanged(TextEvent e) {
        System.out.println("Text changed: " + tf.getText());
    }

    public static void main(String[] args) {
        new TextEventExample();
    }
}
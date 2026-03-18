import java.awt.*;
import java.awt.event.*;

public class ScrollExample extends Frame implements AdjustmentListener {
    Scrollbar sb;

    ScrollExample() {
        sb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        sb.addAdjustmentListener(this);
        add(sb);

        setSize(300, 100);
        setVisible(true);
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        System.out.println("Scrollbar value: " + sb.getValue());
    }

    public static void main(String[] args) {
        new ScrollExample();
    }
}
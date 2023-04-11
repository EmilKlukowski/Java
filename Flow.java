import javax.swing.*;
import java.awt.*;

public class Flow {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(1000,1000);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10)); //pierwsze zero horizontal
        // gap ///// drugie zero vertical gap  = odtępy pomiedzy przyciskami

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 250));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout());

        for (int i = 1; i < 10; i++) {
            panel.add(new JButton(String.valueOf(i)));
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}

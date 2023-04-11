package LaunchingNewPage;

import javax.swing.*;
import java.awt.*;

public class NewWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello");

    public NewWindow(){
        label.setBounds(0,0, 100,100);
        label.setFont(new Font(null, Font.BOLD, 25));

        frame.add(label);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}

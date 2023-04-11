import javax.swing.*;
import java.awt.*;

public class Panels {
    public static void main(String[] args) {

        ImageIcon audi = new ImageIcon("C:\\Users\\Emil\\OneDrive\\Pulpit\\GUI\\src\\Labels\\tylAudi.jpg");

        JLabel label = new JLabel();
        label.setText("Lorem ipsum dolor ist amet conecteur...");
        label.setIcon(audi);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel blackPanel = new JPanel();
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setBounds(0, 0, 250, 250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(250, 0, 250, 250);


        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(500, 0, 250, 250);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 250, 500, 250);
        redPanel.setLayout(new BorderLayout());


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.setVisible(true);
        //dodanie panelu do frama
        redPanel.add(label);


        frame.add(blackPanel);
        frame.add(greenPanel);
        frame.add(bluePanel);
        frame.add(redPanel);
    }
}

import javax.swing.*;
import java.awt.*;

public class JLyrdPane {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //3
        frame.setSize(800,800);
        frame.setLayout(null);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0, 800, 800);

            JLabel redLabel = new JLabel();
            redLabel.setOpaque(true);
            redLabel.setBackground(Color.RED);
            redLabel.setBounds(50, 50, 200, 200);

            JLabel blueLabel = new JLabel();
            blueLabel.setOpaque(true);
            blueLabel.setBackground(Color.blue);
            blueLabel.setBounds(100, 100, 100, 100);

            JLabel greenLabel = new JLabel();
            greenLabel.setOpaque(true);
            greenLabel.setBackground(Color.green);
            greenLabel.setBounds(150, 150, 200, 200);


        layeredPane.add(redLabel, Integer.valueOf(0));
        layeredPane.add(blueLabel, Integer.valueOf(1));
        layeredPane.add(greenLabel, Integer.valueOf(2));

        //=======================
        frame.add(layeredPane);
        frame.setVisible(true);
    }
}

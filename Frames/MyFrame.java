package Frames;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyFrame extends JFrame {

    MyFrame(){
        this.setSize(420, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Gui dzien 1");

        Random r = new Random();
        this.getContentPane().setBackground(new Color(
                r.nextInt(256),
                r.nextInt(256),
                r.nextInt(256)
        ));

//        JLabel label = new JLabel("Hello World!");
//        this.add(label);


    }
}

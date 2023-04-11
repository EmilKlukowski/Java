package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener{

    JButton button;
    public int counter;
    public Random r = new Random();

    JLabel label;
    MyFrame(){

        ImageIcon pointer = new ImageIcon("C:\\Users\\Emil\\Downloads\\pointer.png");


        //to do
        label = new JLabel();
        label.setIcon(pointer);
        label.setBounds(0, 0, 50, 50);
        label.setVisible(false);






        button = new JButton();
        button.setBounds(50, 100, 300, 200);
        //button.addActionListener(this);
        button.addActionListener(this);
        button.setText("Press me");
        button.setIcon(pointer);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setFocusable(false);  //usuwa glupi border dookola tekstu
        button.setFont(new Font("Comic Sans", Font.BOLD, 15));
        button.setIconTextGap(-15);
        button.setForeground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        button.setBackground(SystemColor.lightGray);
        button.setBorder(BorderFactory.createLineBorder(Color.RED));
//        button.setEnabled(true);   można wylaczyc przycisk


        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);




    }


     //implements ActionListener:
    @Override
    public void actionPerformed(ActionEvent action) {
        if(action.getSource()==button){
            counter++;
            System.out.println("elo"+ counter);

            if(counter%2==0){
                label.setVisible(true);
                button.setBounds(counter*2, counter*2, 300, 200);
            } else
                label.setVisible(false);



            if(counter>20){
                System.out.println("Nie nudzi Ci sie?");
            }
        }
    }
}

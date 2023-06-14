package ProjektGry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseClass extends JFrame {
    JLabel chooseYourClass;
    JPanel classes;
    JButton warrior;
    JButton mage;
    JButton class3;
    JButton class4;
    double difficultyLevel;
    int level = 1;

    public ChooseClass() throws HeadlessException {
        createWindow();
        createLabel();
        createClasses();
        createChoices();



        this.setVisible(true);
    }

    public void createWindow(){
        this.setSize(800,500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2, 1));

    }

    public void createLabel(){
        chooseYourClass = new JLabel("Choose your character");
        chooseYourClass.setHorizontalAlignment(JLabel.CENTER);
        chooseYourClass.setFont(new Font("Colonna MT", Font.BOLD, 50));
        chooseYourClass.setOpaque(true);
        chooseYourClass.setBackground(new Color(218, 176, 113));

        this.add(chooseYourClass);
    }

    public void createChoices(){
        warrior = new JButton("Warrior");
        mage = new JButton("Mage");
        class3 = new JButton("Dragon");
        class4 = new JButton("Archer");

        warrior.addActionListener(actionEvent -> {
            firstToShop(new Warrior("Warrior", 30, 50, 30, true, false,
                    false, new ImageIcon("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\swordman(1).png")));
        });

        mage.addActionListener(actionEvent -> {
            firstToShop(new Mage("Wizzard", 40, 40, 25, false, false,
                    false, new ImageIcon("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\mage.png")));
        });

        class3.addActionListener(actionEvent -> {
            firstToShop(new Dragon("Bazyliszek", 50, 50, 0, false, true,
                    false, new ImageIcon("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\dragon.png")));
        });

        class4.addActionListener(actionEvent -> {
            firstToShop(new Archer("Robin Hood", 40, 30, 100, true, false,
                    false, new ImageIcon("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\archer(1).png")));
        });

        warrior.setFocusable(false);
        mage.setFocusable(false);
        class3.setFocusable(false);
        class4.setFocusable(false);

        warrior.setFont(new Font("Colonna MT", Font.BOLD, 30));
        mage.setFont(new Font("Colonna MT", Font.BOLD, 30));
        class3.setFont(new Font("Colonna MT", Font.BOLD, 30));
        class4.setFont(new Font("Colonna MT", Font.BOLD, 30));

        warrior.setBackground(new Color(255, 194, 102));
        mage.setBackground(new Color(255, 194, 102));
        class3.setBackground(new Color(255, 194, 102));
        class4.setBackground(new Color(255, 194, 102));

        classes.add(warrior);
        classes.add(mage);
        classes.add(class3);
        classes.add(class4);
    }

    public void createClasses(){
        classes = new JPanel();
        classes.setLayout(new GridLayout(1, 4));
        this.add(classes);
    }

    public void firstToShop(Character character){
        dispose();
        chooseDifficultyLevel();
        new Shop(character, difficultyLevel, level);
    }

    public void chooseDifficultyLevel(){
        String[] options = {"Easy", "Medium", "Hard"};
        int choice = JOptionPane.showOptionDialog(this, "Select difficulty level:", "Difficulty Level",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch (choice) {
            case 0 -> this.difficultyLevel = 0.8;
            case 1 -> this.difficultyLevel = 1;
            case 2 -> this.difficultyLevel = 1.2;
        }
    }
}

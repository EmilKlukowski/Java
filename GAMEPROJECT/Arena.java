package ProjektGry;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Arena extends JFrame {
    ImageIcon arena;
    JProgressBar characterBar;
    JProgressBar enemyBar;
    JLabel characterLab;
    JLabel enemyLab;
    int level;

    int healthReset;
    int attackCounter;
    boolean wasAngry;

    public Arena(Character character, int level, double difficultyLevel) throws HeadlessException {
        arena = new ImageIcon("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\arena.jpg");
        this.setIconImage(arena.getImage());
        healthReset = character.hitPoints;
        this.level = level;
        this.setTitle("Fight");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMaximumSize(new Dimension(1200, 1200));
        this.setMaximumSize(new Dimension(1200, 1200));
        this.setSize(1200, 1200);
        this.setLayout(new BorderLayout());


        JLabel backgroundLabel = new JLabel(arena);
        backgroundLabel.setLayout(new BorderLayout());
        this.setContentPane(backgroundLabel);

        int enemyAttack = 15 + level * 4;
        enemyAttack *= difficultyLevel;
        int enemyHitPoints = 80 + level * 4;
        enemyHitPoints *= difficultyLevel;
        double enemyReward = 20 + (double) level * 2;
        enemyReward *= difficultyLevel;

        characterBar = new JProgressBar();
        enemyBar = new JProgressBar();
        characterBar.setMaximum(character.hitPoints);
        enemyBar.setMaximum(enemyHitPoints);

        characterLab = new JLabel(character.icon);

        Enemy enemy = new Enemy(enemyAttack, enemyHitPoints, enemyReward);
        enemyLab = new JLabel(enemy.enemyIcon);

        JPanel characterPanel = new JPanel();
        characterPanel.setLayout(new BorderLayout());
        characterPanel.setOpaque(false);
        characterPanel.add(characterLab, BorderLayout.SOUTH);
        characterPanel.add(characterBar, BorderLayout.NORTH);

        JPanel enemyPanel = new JPanel();
        enemyPanel.setLayout(new BorderLayout());
        enemyPanel.setOpaque(false);
        enemyPanel.add(enemyLab, BorderLayout.SOUTH);
        enemyPanel.add(enemyBar, BorderLayout.NORTH);

        backgroundLabel.add(characterPanel, BorderLayout.WEST);
        backgroundLabel.add(enemyPanel, BorderLayout.EAST);

        characterBar.setValue(character.hitPoints);
        enemyBar.setValue(enemy.hitPoints);

        // Buttons
        JButton btnAttack = new JButton("Attack");
        btnAttack.setBackground(new Color(255, 194, 102));
        btnAttack.setFont(new Font("Colonna MT", Font.BOLD, 20));
        btnAttack.setFocusable(false);

        JButton btnEscape = new JButton("Escape");
        btnEscape.setBackground(new Color(255, 194, 102));
        btnEscape.setFont(new Font("Colonna MT", Font.BOLD, 20));
        btnEscape.setFocusable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnAttack);
        buttonPanel.add(btnEscape);

        backgroundLabel.add(buttonPanel, BorderLayout.NORTH);

        btnAttack.addActionListener(actionEvent -> {
            btnEscape.setEnabled(false);
            if (character.hitPoints > 0 && enemy.hitPoints > 0) {
                if(character.isAngry){
                    wasAngry=true;
                    character.attack+=10;
                }

                double attackChance = Math.random();
                if(attackChance>0.2) {
                    character.attack(enemy);
                }

                if(wasAngry){
                    character.attack-=10;
                }
                attackCounter++;
                if(attackCounter>2){
                    character.isAngry = true;
                }
                if(attackCounter>3){
                    character.isTired=true;
                }
                playSound("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\ouchSound.wav");
                enemyBar.setValue(enemy.hitPoints);
            }

            if (enemy.hitPoints > 0 && character.hitPoints > 0) {

                double attackChance = Math.random();
                if(attackChance>0.2 || character.isTired) {
                    enemy.attack(character);
                }
                playSound("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\oofSound.wav");
                characterBar.setValue(character.hitPoints);
            }


            if (character.hitPoints > 0 && enemy.hitPoints <= 0) {
                startIconAnimation(enemyLab);
                JOptionPane.showMessageDialog(this, "You won!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                character.hitPoints = healthReset;
                character.money += enemy.reward;
                new Shop(character, difficultyLevel, level + 1);
                dispose();
            } else if (character.hitPoints <= 0 && enemy.hitPoints > 0) {
                startIconAnimation(characterLab);
                JOptionPane.showMessageDialog(this, "You lost!", ";c", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }


        });

        btnEscape.addActionListener(actionEvent -> {
            btnEscape.setEnabled(false);
            if(character.isTired){
                JOptionPane.showMessageDialog(this, "You are too tired to run!", ";C", JOptionPane.INFORMATION_MESSAGE);
                character.isTired=false;
                return;
            }

            double luck = Math.random();
            if (luck > 0.5) {
                dispose();
                if(this.level <= 1){    //zapobiegnięcie cofaniu poziomu
                    new Shop(character, difficultyLevel, level);
                } else{
                    new Shop(character, difficultyLevel, level - 1);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Escape failed", ";C", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.setVisible(true);
    }

    private void playSound(String fileName) {
        try {
            File musicFile = new File(fileName);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    private void startIconAnimation(JLabel fighterLabel) {
        int startX = fighterLabel.getX();
        int startY = fighterLabel.getY();


        int targetX = -fighterLabel.getWidth();
        int targetY = -fighterLabel.getHeight();

        //predkosc animacji
        int animationSpeed = 10;


        Timer timer = new Timer(animationSpeed, new ActionListener() {
            int currentX = startX;
            int currentY = startY;

            @Override
            public void actionPerformed(ActionEvent e) {
                currentX = animationSpeed;
                currentY -= animationSpeed;

                fighterLabel.setLocation(currentX, currentY);


                if (currentX <= targetX || currentY <= targetY) {
                    ((Timer) e.getSource()).stop();
                    fighterLabel.setVisible(false);
                }
            }
        });


        timer.start();
    }
}

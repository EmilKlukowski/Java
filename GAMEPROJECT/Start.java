package ProjektGry;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Start extends JFrame {
    JLabel title;
    JButton startBtn;
    JButton quitBtn;
    Clip clip;

    public Start() throws HeadlessException {
        playMusic("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\Swords-and-Sandals-I-Arena-Champion-Intro-Theme.wav");
        createWindow();
        createTitle();
        createStartBtn();
        createQuitBtn();

        this.setVisible(true);
    }

    public void createWindow(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(3, 1));
        this.getContentPane().setBackground(new Color(218, 176, 113));
    }

    public void createTitle(){
        title = new JLabel("Swords and Sandals 0.5");
        title.setFont(new Font("Colonna MT", Font.BOLD, 45));
        title.setHorizontalAlignment(JLabel.CENTER);


        this.add(title);
    }

    public void createStartBtn(){
        startBtn = new JButton("Play");
        startBtn.setFocusable(false);
        startBtn.setBackground(new Color(255, 194, 102));
        startBtn.setFont(new Font("Colonna MT", Font.PLAIN, 35));

        startBtn.addActionListener(actionEvent -> {
            dispose();
            new ChooseClass();
        });

        this.add(startBtn);
    }

    public void createQuitBtn(){
        quitBtn = new JButton("Quit");
        quitBtn.setFocusable(false);


        quitBtn.setFont(new Font("Colonna MT", Font.PLAIN, 35));
        quitBtn.setBackground(new Color(255, 194, 102));

        quitBtn.addActionListener(actionEvent -> dispose());

        this.add(quitBtn);
    }

    private void playMusic(String fileName) {
        try {
            File musicFile = new File(fileName);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}

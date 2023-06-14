package ProjektGry;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Shop extends JFrame {
    private Clip clip;
    JPanel leftSide;
    JPanel characterInfo;
    JLabel characterName;
    JLabel characterHp;
    JLabel characterAttack;
    JLabel characterMoney;
    JLabel characterItems;
    JPanel itemsPanel;
    JButton item1;
    JButton item2;
    JButton item3;
    JPanel rightSide;
    JLabel levelInfo;
    JButton fight;
    JButton quit;
    Character character;

    Item[] items = {new Item().soulSword(), new Item().infinitySword(), new Item().smallShield(), new Item().bigShield(),
            new Item().frostBlade(), new Item().holyHammer(), new Item().poisonSpear(),
            new Item().shadowDagger(), new Item().thunderShield(), new Item().windSword(),
            new Item().crystalSword(), new Item().divineWand(), new Item().earthHammer(),
            new Item().lifeStaff(),  new Item().shadowBow(), new Item().poisonDagger(),
            new Item().fireShield(), new Item().iceSpear(), new Item().thunderBlade(),
            new Item().windShield(), new Item().epicSword(), new Item().legendaryBow(),
            new Item().divineShield(), new Item().thunderHammer(), new Item().holyStaff(),
            new Item().poisonSword(), new Item().fireDagger(), new Item().iceShield(),
            new Item().stormSpear(), new Item().windBlade(), new Item().enchantedBow(),
            new Item().fireStaff(), new Item().lightningDagger()
    };
    double difficultyLevel;
    int level;
    int howManyBought = 0;

    public Shop(Character c, double difficultyLevel, int level) throws HeadlessException {
        playMusic("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\Romance-of-Rome-PC-Game-Soundtrack-OST-4.-Marketplace.wav");
        this.level = level;
        this.difficultyLevel = difficultyLevel;
        this.character = c;
        createFrame();
        createLeftSide();
        createRightSide();

        this.setVisible(true);
    }

    public void createFrame() {
        this.setSize(1000, 600);
        this.setTitle("Shop");
        this.setMinimumSize(new Dimension(800, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 2));
    }

    public void createLeftSide() {
        leftSide = new JPanel();
        leftSide.setLayout(new GridLayout(2, 1));
        itemsPanel = new JPanel();
        //character info panel
        {
            characterInfo = new JPanel();
            characterInfo.setLayout(new GridLayout(5, 1));

            characterName = new JLabel();
            characterHp = new JLabel();
            characterAttack = new JLabel();
            characterMoney = new JLabel();
            characterItems = new JLabel();

            characterName.setText("Name: " + character.name);
            characterName.setFont(new Font("Colonna MT", Font.BOLD, 20));
            characterName.setOpaque(true);
            characterName.setBackground(new Color(156, 134, 28));

            characterHp.setText("HP: " + character.hitPoints);
            characterHp.setFont(new Font("Colonna MT", Font.BOLD, 20));
            characterHp.setOpaque(true);
            characterHp.setBackground(new Color(156, 134, 28));

            characterAttack.setText("Attack: " + character.attack);
            characterAttack.setFont(new Font("Colonna MT", Font.BOLD, 20));
            characterAttack.setOpaque(true);
            characterAttack.setBackground(new Color(156, 134, 28));


            characterMoney.setText("Money: " + character.money);
            characterMoney.setFont(new Font("Colonna MT", Font.BOLD, 20));
            characterMoney.setOpaque(true);
            characterMoney.setBackground(new Color(156, 134, 28));


            characterItems.setFont(new Font("Colonna MT", Font.BOLD, 20));
            characterItems.setOpaque(true);
            characterItems.setBackground(new Color(156, 134, 28));

            if (character.items[0] == null && character.items[1] == null) {
                characterItems.setText("Items: ");
            } else if (character.items[0] != null) {
                characterItems.setText("Items: " + character.items[0].name);
            } else if (character.items[1] != null) {
                characterItems.setText("Items: " + character.items[1].name);
            } else {
                characterItems.setText("Item 1: " + character.items[0].name + ", Item 2: " + character.items[1].name);
            }

            characterName.setHorizontalAlignment(JLabel.CENTER);
            characterHp.setHorizontalAlignment(JLabel.CENTER);
            characterAttack.setHorizontalAlignment(JLabel.CENTER);
            characterMoney.setHorizontalAlignment(JLabel.CENTER);
            characterItems.setHorizontalAlignment(JLabel.CENTER);

            characterInfo.add(characterName);
            characterInfo.add(characterHp);
            characterInfo.add(characterAttack);
            characterInfo.add(characterMoney);
            characterInfo.add(characterItems);
        }

        //items panel
        {
            for (Item item : items) {
                item.price += (double) level / 4;
                item.price = item.price * difficultyLevel;
                item.health += (double) level / 4;
                item.health = item.health * difficultyLevel;
                item.attack += (double) level / 4;
                item.attack = item.attack * difficultyLevel;
                if(character.isCharismatic){
                    item.price*=0.8;
                }
            }


            itemsPanel = new JPanel();
            itemsPanel.setBackground(Color.LIGHT_GRAY);
            itemsPanel.setLayout(new GridLayout(3, 1));

            Item firstItem = items[(int) (Math.random() * 32)];
            item1 = new JButton(firstItem.name + ": attack: " + Math.round(firstItem.attack * 100) / 100 + ", health: "
                    + Math.round(firstItem.health * 100) / 100 + ", price: " + Math.round(firstItem.price * 100) / 100.0);
            item1.setBackground(new Color(255, 194, 102));
            item1.setFont(new Font("Colonna MT", Font.BOLD, 20));
            item1.setFocusable(false);
            if (firstItem.price > character.money) {
                item1.setEnabled(false);
            }

            Item secondItem = items[(int) (Math.random() * 32)];
            item2 = new JButton(secondItem.name + ": attack: " + Math.round(secondItem.attack * 100) / 100 + ", health: "
                    + Math.round(secondItem.health * 100) / 100 + ", price: " + Math.round(secondItem.price * 100) / 100.0);
            item2.setBackground(new Color(255, 194, 102));
            item2.setFont(new Font("Colonna MT", Font.BOLD, 20));
            item2.setFocusable(false);
            if (secondItem.price > character.money) {
                item2.setEnabled(false);
            }

            Item thirdItem = items[(int) (Math.random() * 32)];
            item3 = new JButton(thirdItem.name + ": attack: " + Math.round(thirdItem.attack * 100) / 100 + ", health: "
                    + Math.round(thirdItem.health * 100) / 100 + ", price: " + Math.round(thirdItem.price * 100) / 100.0);
            item3.setBackground(new Color(255, 194, 102));
            item3.setFont(new Font("Colonna MT", Font.BOLD, 20));
            item3.setFocusable(false);
            if (thirdItem.price > character.money) {
                item3.setEnabled(false);
            }

            //ActionListeners:
            {
                item1.addActionListener(actionEvent -> checkMoney(item1, firstItem));

                item2.addActionListener(actionEvent -> checkMoney(item2, secondItem));

                item3.addActionListener(actionEvent -> checkMoney(item3, thirdItem));
            }
            itemsPanel.add(item1);
            itemsPanel.add(item2);
            itemsPanel.add(item3);
        }


        leftSide.add(characterInfo);
        leftSide.add(itemsPanel);
        this.add(leftSide);
    }

    public void createRightSide() {
        rightSide = new JPanel();
        rightSide.setLayout(new GridLayout(3, 1));
        levelInfo = new JLabel("Level: " + this.level);
        levelInfo.setOpaque(true);
        levelInfo.setBackground(new Color(218, 176, 113));
        levelInfo.setFont(new Font("Colonna MT", Font.BOLD, 40));
        levelInfo.setHorizontalAlignment(JLabel.CENTER);

        quit = new JButton("Quit");
        quit.setFont(new Font("Colonna MT", Font.BOLD, 40));
        quit.setBackground(new Color(255, 194, 102));
        quit.setFocusable(false);

        fight = new JButton("Fight");
        fight.setFont(new Font("Colonna MT", Font.BOLD, 40));
        fight.setBackground(new Color(255, 194, 102));
        fight.setFocusable(false);


        quit.addActionListener(actionEvent -> {
            dispose();
            System.exit(0);
        });

        fight.addActionListener(actionEvent -> {
            dispose();
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            new Arena(character, level, difficultyLevel);
        });

        rightSide.add(levelInfo);
        rightSide.add(fight);
        rightSide.add(quit);

        this.add(rightSide);
    }

    public void checkMoney(JButton itemBtn, Item item) {
        if (character.money >= item.price) {

            if (character.items[0] == null) {
                character.items[0] = item;
            } else if (character.items[1] == null) {
                character.items[1] = item;
            } else {
                character.items[0] = item;
                character.attack -= character.items[0].attack;
                character.hitPoints -= character.items[0].health;
            }

            character.money -= item.price;
            character.attack += item.attack;
            character.hitPoints += item.health;
            characterHp.setText("HP: " + character.hitPoints);
            characterAttack.setText("Attack: " + character.attack);
            characterMoney.setText("Money: " + character.money);
            itemBtn.setEnabled(false);
            howManyBought++;
            if(howManyBought>3){
                character.isCharismatic = true;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Not enough money!", "Swords and Sandals 0.5", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void playMusic(String fileName) {
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

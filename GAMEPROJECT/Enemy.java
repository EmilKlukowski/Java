package ProjektGry;

import javax.swing.*;

public class Enemy {
    int attack;
    int hitPoints;
    double reward;
    public ImageIcon enemyIcon;
    public Enemy(int attack, int hitPoints, double reward) {
        this.attack = attack;
        this.hitPoints = hitPoints;
        this.reward = reward;
        this.enemyIcon = new ImageIcon("D:\\Users\\Emil\\GUI\\src\\ProjektGry\\enemy(1).png");
    }

    public void attack(Character c){
        c.hitPoints -= this.attack;
    }
}

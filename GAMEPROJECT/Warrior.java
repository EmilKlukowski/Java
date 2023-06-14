package ProjektGry;

import javax.swing.*;

public class Warrior extends Character{

    public Warrior(String name, int attack, int hitPoints, int money, boolean isCharismatic, boolean isTired, boolean isAngry, ImageIcon icon) {
        super(name, attack, hitPoints, money, isCharismatic, isTired, isAngry, icon);
    }

    Item[] items = new Item[2];
    @Override
    void attack(Enemy e) {
        e.hitPoints -= this.attack;
    }
}

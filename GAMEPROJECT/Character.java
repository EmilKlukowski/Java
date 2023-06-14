package ProjektGry;

import javax.swing.*;

public abstract class Character {
    String name;
    int attack;
    int hitPoints;
    int money;
    boolean isCharismatic;
    boolean isTired;
    boolean isAngry;


    Item[] items = new Item[2];
    public ImageIcon icon;

    public Character(String name, int attack, int hitPoints, int money, boolean isCharismatic, boolean isTired, boolean isAngry, ImageIcon icon) {
        this.name = name;
        this.attack = attack;
        this.hitPoints = hitPoints;
        this.money = money;
        this.isCharismatic = isCharismatic;
        this.isTired = isTired;
        this.isAngry = isAngry;
        this.icon = icon;
    }

    abstract void attack(Enemy e);
}

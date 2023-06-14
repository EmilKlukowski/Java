package ProjektGry;

import javax.swing.*;

public class Mage extends Character{
    public Mage(String name, int attack, int hitPoints, int money, boolean isCharismatic, boolean isTired, boolean isAngry, ImageIcon icon) {
        super(name, attack, hitPoints, money, isCharismatic, isTired, isAngry, icon);
    }

    @Override
    void attack(Enemy e) {
        e.hitPoints -= this.attack;
    }

}

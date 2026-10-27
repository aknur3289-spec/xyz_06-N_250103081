// Task 6: RPG Game Weapon System - Bridge

interface Weapon {
    void use();
}

class Sword implements Weapon {
    public void use() {
        System.out.println("Slash! Dealing 20 physical damage.");
    }
}

class MagicWand implements Weapon {
    public void use() {
        System.out.println("Zap! Dealing 35 magic damage.");
    }
}

abstract class Hero {
    protected Weapon weapon;
    public Hero(Weapon weapon) {
        this.weapon=weapon;
    } public abstract void attack();
}

class Knight extends Hero {
    public Knight(Weapon weapon) {
        super(weapon);
    } public void attack() {
        weapon.use();
    }
}

class Wizard extends Hero {
    public Wizard(Weapon weapon) {
        super(weapon);
    } public void attack() {
        weapon.use();
    }
}

public class Main {
    public static void main(String[] args) {
        new Knight(new Sword()).attack();
        new Knight(new MagicWand()).attack();
    }
}

package com.travula.abstracts;

public abstract class Monster {
    private final String name;
    private final int damage;
    private int health;
    private final int defHealth;
    private final int money;

    public Monster(String name, int damage, int health, int money) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defHealth = health;
        this.money = money;
    }

    public void monsterInfo(){
        System.out.println("----------------------------------------");
        System.out.println(this.name + "'s stats : " +
                "\n-Damage : " + getDamage() +
                "\n-Health : " + getDefHealth() +
                "\n-Money : " + getMoney()
        );
    }
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getDefHealth() {
        return defHealth;
    }

    public int getMoney() {
        return money;
    }

}

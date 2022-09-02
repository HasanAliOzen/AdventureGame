package com.travula.abstracts;

public abstract class GameChar {
    private final int id;
    private final String charName;
    private final int damage;
    private final int maxHealth;
    private int health;
    private int money;

    public GameChar(int id, String charName, int damage, int health, int money) {
        this.id = id;
        this.charName = charName;
        this.damage = damage;
        this.maxHealth = health;
        this.health = health;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getCharName() {
        return charName;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMoney() {
        return money;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public void setMoney(int money) {
        this.money = Math.max(money, 0);
    }
}

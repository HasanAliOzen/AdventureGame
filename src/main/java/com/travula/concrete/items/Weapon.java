package com.travula.concrete.items;

import com.travula.abstracts.Equipment;

public class Weapon extends Equipment {
    private final int damage;

    public Weapon(int id,String name,int price,int damage) {
        super(id,name,price,"Weapon");
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
}

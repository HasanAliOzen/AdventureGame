package com.travula.concrete.items;

import com.travula.abstracts.Equipment;

public class Armor extends Equipment {
    private final int block;

    public Armor(int id,String name,int price,int block) {
        super(id,name,price, "Armor");
        this.block = block;
    }

    public int getBlock() {
        return block;
    }
}

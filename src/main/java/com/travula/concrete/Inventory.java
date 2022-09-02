package com.travula.concrete;

import com.travula.concrete.items.Award;
import com.travula.concrete.items.Armor;
import com.travula.concrete.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Award> awards = new ArrayList<>();
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon(-1,"You don't have any weapon",0,0);
        this.armor = new Armor(-1,"You don't have any armor",0,0);
    }


    public List<Award> getAwards() {
        return awards;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

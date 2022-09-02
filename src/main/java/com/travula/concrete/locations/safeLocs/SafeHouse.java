package com.travula.concrete.locations.safeLocs;

import com.travula.abstracts.NormalLoc;
import com.travula.concrete.Player;

public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("---You are in Safe House right  now!!!");
        getPlayer().getGameChar().setHealth(getPlayer().getGameChar().getMaxHealth());
        System.out.println("Your heal is full.");
        getPlayer().playerInfo();
        return true;
    }
}
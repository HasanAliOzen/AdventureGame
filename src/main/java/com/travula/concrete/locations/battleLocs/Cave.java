package com.travula.concrete.locations.battleLocs;

import com.travula.abstracts.BattleLoc;
import com.travula.concrete.Player;
import com.travula.concrete.items.Award;
import com.travula.concrete.monsters.Bat;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Cave",new Bat(),new Award("Food","Cave"));

    }

}
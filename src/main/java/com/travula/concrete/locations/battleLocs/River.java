package com.travula.concrete.locations.battleLocs;

import com.travula.abstracts.BattleLoc;
import com.travula.concrete.Player;
import com.travula.concrete.items.Award;
import com.travula.concrete.monsters.Bear;

public class River extends BattleLoc {
    public River(Player player) {
        super(player, "River",new Bear(), new Award("Water", "River"));
    }
}

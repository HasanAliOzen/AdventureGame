package com.travula.concrete.locations.battleLocs;

import com.travula.abstracts.BattleLoc;
import com.travula.concrete.Player;
import com.travula.concrete.items.Award;
import com.travula.concrete.monsters.Wolf;

public class Forest extends BattleLoc {

    public Forest(Player player) {
        super(player, "Forest",new Wolf(), new Award("Wood", "Forest"));
    }
}

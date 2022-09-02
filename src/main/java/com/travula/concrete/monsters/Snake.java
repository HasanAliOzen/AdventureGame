package com.travula.concrete.monsters;

import com.travula.abstracts.Location;
import com.travula.abstracts.Monster;

public class Snake extends Monster {
    public Snake() {
        super("Snake", 3, 12, 0);
    }

    @Override
    public int getDamage() {
        return Location.rand.nextInt(3,7);
    }
}

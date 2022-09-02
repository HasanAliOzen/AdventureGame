package com.travula.abstracts;

import com.travula.concrete.Player;

import java.util.Random;
import java.util.Scanner;

public abstract class Location {
    public static final Random rand = new Random();
    protected static final Scanner input = new Scanner(System.in);

    protected static String selectedString;
    private final Player player;
    private final String locName;
    public Location(Player player, String locName) {
        this.player = player;
        this.locName = locName;
    }

    public Player getPlayer() {
        return player;
    }

    public String getLocName() {
        return locName;
    }

    public abstract boolean onLocation();

}

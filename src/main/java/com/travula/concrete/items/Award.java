package com.travula.concrete.items;

public class Award {
    private final String name;
    private boolean isTaken;
    private final String locationOfAward;

    public Award(String name, boolean isTaken, String locationOfAward) {
        this.name = name;
        this.isTaken = isTaken;
        this.locationOfAward = locationOfAward;
    }

    public Award(String name, String locationOfAward) {
        this.name = name;
        this.isTaken = false;
        this.locationOfAward = locationOfAward;
    }

    public String getName() {
        return name;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String getLocationOfAward() {
        return locationOfAward;
    }
}

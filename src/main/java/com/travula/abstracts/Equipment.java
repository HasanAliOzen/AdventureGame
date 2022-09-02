package com.travula.abstracts;

public abstract class Equipment {
    private final int id;
    private final String name;
    private final int price;
    private final String equipmentClass;

    public Equipment(int id, String name, int price, String equipmentClass) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.equipmentClass = equipmentClass;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getEquipmentClass() {
        return equipmentClass;
    }
}

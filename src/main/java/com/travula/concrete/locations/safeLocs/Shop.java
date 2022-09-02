package com.travula.concrete.locations.safeLocs;

import com.travula.abstracts.Equipment;
import com.travula.abstracts.NormalLoc;
import com.travula.concrete.Player;
import com.travula.concrete.items.armors.LightArmor;
import com.travula.concrete.items.Armor;
import com.travula.concrete.items.Weapon;
import com.travula.concrete.items.armors.HeavyArmor;
import com.travula.concrete.items.armors.MediumArmor;
import com.travula.concrete.items.weapons.Dagger;
import com.travula.concrete.items.weapons.Spear;
import com.travula.concrete.items.weapons.Sword;

public class Shop extends NormalLoc {
    private final Armor[] armors = {new LightArmor(), new MediumArmor(), new HeavyArmor()};
    private final Weapon[] weapons = {new Dagger(), new Sword(), new Spear()};
    private final Equipment[][] equipments = {armors,weapons};

    private int choice = -1;
    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("---You're in Shop right now!!!");
        System.out.println("You have " + this.getPlayer().getGameChar().getMoney() + " coins.");
        for (int i = 0; i < equipments.length; i++) {
            System.out.println((i+1) + "." + equipments[i][0].getEquipmentClass());
        }
        System.out.print("Choose what to buy <0.for nothing>: ");
        this.choice = input.nextInt();
        switch (this.choice) {
            case 1 -> {
                printArmors();
                buyArmor();
            }
            case 2 -> {
                printWeapons();
                buyWeapon();
            }
            default -> System.out.println(this.getPlayer().getName() + " bought nothing.");
        }

        return true;
    }

    public void printArmors(){
        System.out.println("------------------------------------------------------------");
        for (Armor armor : armors) {
            System.out.println(
                    "ID : " + armor.getId() +
                            "\tName : " + armor.getName() +
                            "\t\tPrice : " + armor.getPrice() +
                            "\tBlock : " + armor.getBlock() + "      |"
            );
        }
        System.out.println("------------------------------------------------------------");
    }

    public void buyArmor(){
        System.out.print("Choose Item to buy <0.for nothing>: ");
        this.choice = input.nextInt() - 1;
        if (this.choice >= 0 && this.choice < armors.length) {
            if (getPlayer().getGameChar().getMoney() >= armors[this.choice].getPrice()) {
                getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() - armors[this.choice].getPrice());
                this.getPlayer().getInventory().setArmor(armors[this.choice]);
                System.out.println(
                        this.getPlayer().getName() + " bought " +
                                this.getPlayer().getInventory().getArmor().getName() +
                                "\n You have " + getPlayer().getGameChar().getMoney() + " coins left."
                );
            } else {
                System.out.println(this.getPlayer().getName() + " not have enough money.");
            }

        } else {
            System.out.println(this.getPlayer().getName() + " bought nothing.");
        }
    }

    public void printWeapons(){
        System.out.println("------------------------------------------------------------");
        for (Weapon weapon : weapons) {
            System.out.println(
                    "ID : " + weapon.getId() +
                            "\tName : " + weapon.getName() +
                            "\t\tPrice : " + weapon.getPrice() +
                            "\tDamage : " + weapon.getDamage() + "      |"
            );
        }
        System.out.println("------------------------------------------------------------");
    }
    public void buyWeapon(){
        System.out.print("Choose Item to buy <0.for nothing>: ");
        this.choice = input.nextInt() - 1;
        if (this.choice >= 0 && this.choice < weapons.length) {
            if (getPlayer().getGameChar().getMoney() >= weapons[this.choice].getPrice()) {
                getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() - weapons[this.choice].getPrice());
                this.getPlayer().getInventory().setWeapon(weapons[this.choice]);
                System.out.println(
                        this.getPlayer().getName() + " bought " +
                                this.getPlayer().getInventory().getWeapon().getName() +
                                "\n You have " + getPlayer().getGameChar().getMoney() + " coins left."
                );
            } else {
                System.out.println(this.getPlayer().getName() + " not have enough money.");
            }
        } else {
            System.out.println(this.getPlayer().getName() + " bought nothing.");
        }
    }


}

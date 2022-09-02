package com.travula.concrete;

import com.travula.abstracts.GameChar;
import com.travula.concrete.gameChars.Knight;
import com.travula.concrete.gameChars.SwordMan;
import com.travula.concrete.gameChars.Sage;
import com.travula.concrete.items.Award;

import java.util.Scanner;

public class Player {
    private final Scanner input = new Scanner(System.in);
    private final String name;
    private GameChar gameChar;

    private boolean isAlive;
    private final Inventory inventory;

    public Player(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
        this.isAlive = true;
    }
    public void selectChar(){
        GameChar[] gameChars ={ new SwordMan(), new Knight(), new Sage()};

        System.out.println("--------------------------------------------------------------------------------");
        for (GameChar gameChar: gameChars){
            System.out.println(
                    "Id : " + gameChar.getId() +
                    "\t Character : " + gameChar.getCharName() +
                    "\t\t Damage : " + gameChar.getDamage() +
                    "\t Health : " + gameChar.getHealth() +
                    "\t Money : " +gameChar.getMoney()
            );
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Select your character: ");
        int choosenChar = -1;
        while (!(choosenChar > 0 && choosenChar <= gameChars.length)) {
            choosenChar = input.nextInt();
            if (choosenChar > 0 && choosenChar <= gameChars.length) {
                this.gameChar = gameChars[choosenChar - 1];
            } else {
                System.out.print("Select a valid character!!! :");
            }
        }

    }

    public void playerInfo(){
        System.out.println("----------------------------------------");
        System.out.println(this.name + "'s stats : " +
                "\nYour character: " + gameChar.getCharName() +
                "\n-Weapon : " + inventory.getWeapon().getName() +
                "\n-Armor : " + inventory.getArmor().getName() +
                "\n-Damage : " + getTotalDamage() +
                "\n-Block : " + getTotalBlock() +
                "\n-Health : " + getTotalHealth() +
                "\n-Money : " + getTotalMoney()
        );
    }

    public int getTotalDamage(){
        return gameChar.getDamage()+inventory.getWeapon().getDamage();
    }
    public int getTotalBlock(){
        return inventory.getArmor().getBlock();
    }
    public int getTotalHealth(){
        return gameChar.getHealth();
    }
    public int getTotalMoney(){
        return gameChar.getMoney();
    }
    public boolean inflictDamage(int takenDamage){
        //return false if player dies;
        if (takenDamage > 0){
            this.getGameChar().setHealth(getTotalHealth()-takenDamage);
        }
        return getTotalHealth() != 0;
    }
    public boolean inflictDamageWithBlock(int takenDamage){
        //return full health;
        takenDamage -= getTotalBlock();
        if (takenDamage > 0){
            this.getGameChar().setHealth(getTotalHealth()-takenDamage);
        }
        return getTotalHealth() != 0;
    }

    public void getAwards(){
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("#############AWARDS#############\n<Get all the awards to win<Except Random Item>>");
        for (Award award : getInventory().getAwards()) {
            System.out.println("#" + award.getName() +
                    "\n--Location : "+ award.getLocationOfAward() +
                    "\n--Do you have it : " + award.isTaken()
            );
        }
    }
    public boolean isWon(){
        for (Award award : getInventory().getAwards()) {
            if(!award.isTaken()){
                return false;
            }
        }
        return true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public String getName() {
        return name;
    }

    public GameChar getGameChar() {
        return gameChar;
    }

    public Inventory getInventory() {
        return inventory;
    }
}

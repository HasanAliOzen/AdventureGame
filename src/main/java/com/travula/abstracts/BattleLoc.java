package com.travula.abstracts;

import com.travula.concrete.Player;
import com.travula.concrete.items.Award;

public abstract class BattleLoc extends Location {

    private final Monster monster;
    private int numberOfMonster;
    private final Award award;

    public BattleLoc(Player player, String locName,Monster monster, Award award) {
        super(player, locName);
        this.monster = monster;
        this.numberOfMonster = 1;
        this.award = award;
        getPlayer().getInventory().getAwards().add(award);
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("---You are in " + this.getLocName() + " right  now!!!");

        if (isLocFinished()){
            return true;
        }
        resetNumberOfMonsters();

        for (int i = getNumberOfMonster()-1; i >= 0;i--) {
            System.out.println("There are " + getNumberOfMonster() + " " + this.getMonster().getName()
                    + "s in " + this.getLocName() + ".");
            getMonster().setHealth(getMonster().getDefHealth());


            System.out.print("<F>ight or <R>un!!!\n:");
            selectedString = input.nextLine().toUpperCase();
            if (selectedString.equals("F")) {
                getPlayer().playerInfo();
                getMonster().monsterInfo();
                if(!combat()){
                    return false;
                }

            }else{
                break;
            }

        }

        if (getNumberOfMonster() == 0 ){
            System.out.println("Congrats!!! " + getPlayer().getName() + " killed all enemies!!!");
            winAward();
        }
        return true;
    }

    public boolean combat() {
        int randNumber = rand.nextInt(2) % 2;

        while (true) {
            System.out.println("-------------------------");
            if (randNumber == 1 ){
                //Monster attack
                if(monsterAttack()){
                    return false;
                }
                //Monster attack ends

            }
            //Player's turn
            System.out.print("<H>it or <E>scape!!!\n:");
            selectedString = input.nextLine().toUpperCase();
            if (selectedString.equals("H")) {
                if (playerAttack()){
                    //Monster died
                    return true;
                }
            } else {
                int monsterDamage = getMonster().getDamage();
                System.out.println(getPlayer().getName() + " tried to escape and took "+ monsterDamage + " damage!!!");
                if(!getPlayer().inflictDamage(monsterDamage)){
                    //played dies
                    return false;
                }
                System.out.println(getPlayer().getName() + " has " + getPlayer().getTotalHealth() + "hp health!!!");
                //player outs from combat
                return true;
            }
            //Player turn ends
            System.out.println();

            if (randNumber == 0 ){

                //Monster attack
                if(monsterAttack()){
                    return false;
                }
                System.out.println("-------------------------");
                //Monster attack ends
            }
        }
    }

    public boolean playerAttack(){
        //returns true if monster dies
        System.out.println(getPlayer().getName() + " attacks!!!");
        getMonster().setHealth(getMonster().getHealth() - getPlayer().getTotalDamage());
        System.out.println(getPlayer().getName() + " hits " + getPlayer().getTotalDamage() + " damage!!!");

        if (getMonster().getHealth()==0){
            //player attacks monster dies
            System.out.println(getPlayer().getName() + " killed a " + getMonster().getName() + "!!!");
            setNumberOfMonster(getNumberOfMonster()-1);

            System.out.println(getPlayer().getName() + " gets " + getMonster().getMoney() + "coins.");
            getPlayer().getGameChar().setMoney(getPlayer().getTotalMoney() + getMonster().getMoney());

            System.out.println();
            return true;
        }
        System.out.println(getMonster().getName() + " has " + getMonster().getHealth() + "hp health!!!");
        //player attacks monster lives
        return false;
    }

    public boolean monsterAttack(){
        //returns true when player dies
        System.out.println(getMonster().getName() + " attacks!!!");

        int monsterDamage = getMonster().getDamage();
        System.out.println(getMonster().getName() + " hits " +
                monsterDamage + " damage!!!");
        System.out.println(getPlayer().getName() + " blocked with " + getPlayer().getTotalBlock() + "!!!");
        if(!getPlayer().inflictDamageWithBlock(monsterDamage)){
            return true;
        }
        System.out.println(getPlayer().getName() + " has " + getPlayer().getTotalHealth() + "hp health!!!");
        return false;
    }

    public boolean isLocFinished(){
        if (award.isTaken() ){
            System.out.println("There's nothing here!!! Go away somewhere else!!!");
            return true;
        }
        return false;
    }
    public void winAward(){
        System.out.println("You get " + getAward().getName() + " and 5 coins!!!");
        getPlayer().getGameChar().setMoney(getPlayer().getTotalMoney() + 5);
        getAward().setTaken(true);
    }

    public Monster getMonster() {
        return monster;
    }

    public Award getAward() {
        return award;
    }


    public void resetNumberOfMonsters(){
        setNumberOfMonster(rand.nextInt(1, 4));
    }
    public int getNumberOfMonster() {
        return numberOfMonster;
    }

    public void setNumberOfMonster(int numberOfMonster) {
        this.numberOfMonster = numberOfMonster;
    }
}

package com.travula;

import com.travula.abstracts.Location;
import com.travula.concrete.Inventory;
import com.travula.concrete.locations.battleLocs.Cave;
import com.travula.concrete.locations.battleLocs.Forest;
import com.travula.concrete.locations.battleLocs.Mine;
import com.travula.concrete.locations.battleLocs.River;
import com.travula.concrete.locations.safeLocs.SafeHouse;
import com.travula.concrete.locations.safeLocs.Shop;
import com.travula.concrete.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);
    private int choosenValue;

    //Fields
    private final Player player;
    private final List<Location> locations = new ArrayList<>();
    private final List<String> mainMenuSelections = new ArrayList<>();

    public Game() {
        System.out.print("Enter your name, please: ");
        this.player = new Player(input.nextLine(), new Inventory());
    }

    public void start(){
        System.out.println("Welcome to monster island " + getPlayer().getName());
        getPlayer().selectChar();

        //Main menus
        getMainMenu().add("Locations <Change your location>");
        getMainMenu().add( getPlayer().getName() + " stat's <See your stat's>");
        getMainMenu().add("Progress <See awards you get>");
        getMainMenu().add("Quit <Exit from game. Your progress will lose!!!>");

        //Locations
        getLocations().add(new SafeHouse(getPlayer()));
        getLocations().add(new Shop(getPlayer()));
        getLocations().add(new Cave(getPlayer()));
        getLocations().add(new Forest(getPlayer()));
        getLocations().add(new River(getPlayer()));
        getLocations().add(new Mine(getPlayer()));


        mainMenu();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("A game By Hasan Ali Özen");
    }

    public void mainMenu(){
        while(getPlayer().isAlive()){
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("#############Main Menu#############");
            for (int i = 0; i < mainMenuSelections.size(); i++) {
                System.out.println( (i+1) + "." +  getMainMenu().get(i));
            }
            System.out.print("Choose what you do : ");
            choosenValue = input.nextInt();
            if(choosenValue > 0 && choosenValue <= getMainMenu().size()){
                switch (choosenValue) {
                    case 1 -> locationMenu();
                    case 2 -> getPlayer().playerInfo();
                    case 3 -> getPlayer().getAwards();
                    case 4 -> {
                        System.out.println("You are quiting game!!! BYE BYE");
                        getPlayer().setAlive(false);
                    }
                    default -> System.out.println("Not a valid request!!!");
                }
            }
        }
    }


    public void locationMenu(){
        while(true){
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println( 0 + ".Go back Main Menu");
            System.out.println("#############Locations#############");
            for (int i = 0; i < getLocations().size(); i++) {
                System.out.println( (i+1) + "." +  getLocations().get(i).getLocName());
            }
            System.out.print("Choose place to go : ");

            choosenValue = input.nextInt()-1;
            if (choosenValue == -1){
                break;
            }
            if(choosenValue >= 0 && choosenValue < getLocations().size() ){
                getPlayer().setAlive(getLocations().get(choosenValue).onLocation());
                if(!getPlayer().isAlive()){
                    System.out.println("YOU DIED!!!\nGAME OVER!!!");
                    break;
                }

                if(getPlayer().isWon()){
                    System.out.println("\n\nCongrats!!! " + getPlayer().getName() + " collected all the awards!!!");
                    System.out.println("YOU WON!!!\n");
                    getPlayer().setAlive(false);
                    break;
                }

                System.out.println("You left " + getLocations().get(choosenValue).getLocName());
            }else {
                System.out.println("Not a valid place!!!");
            }
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<String> getMainMenu() {
        return mainMenuSelections;
    }
}

package com.travula.concrete.locations.battleLocs;

import com.travula.abstracts.BattleLoc;
import com.travula.concrete.Player;
import com.travula.concrete.items.Award;
import com.travula.concrete.items.armors.HeavyArmor;
import com.travula.concrete.items.armors.LightArmor;
import com.travula.concrete.items.armors.MediumArmor;
import com.travula.concrete.items.weapons.Dagger;
import com.travula.concrete.items.weapons.Spear;
import com.travula.concrete.items.weapons.Sword;
import com.travula.concrete.monsters.Snake;

public class Mine extends BattleLoc {
    public Mine(Player player) {
        super(player, "Mine <Bonus Place>", new Snake(), new Award("Random Item",true,"Mine"));
    }

    @Override
    public void winAward() {
        int randomPrize = rand.nextInt(1000);
        if (randomPrize < 450){
            System.out.println("Sorry! You won nothing");
        }
        if (randomPrize >= 450 && randomPrize <600){
            if (randomPrize >= 450 && randomPrize <480){
                getPlayer().getInventory().setWeapon(new Dagger());
            }
            if (randomPrize >= 480 && randomPrize < 525){
                getPlayer().getInventory().setWeapon(new Sword());

            }
            if (randomPrize >= 525 && randomPrize <600){
                getPlayer().getInventory().setWeapon(new Spear());
            }
            System.out.println(
                    this.getPlayer().getName() + " won " +
                            this.getPlayer().getInventory().getWeapon().getName()
            );
        }
        if (randomPrize >= 600 && randomPrize <750) {
            if (randomPrize >= 600 && randomPrize <630){
                getPlayer().getInventory().setArmor(new LightArmor());
            }
            if (randomPrize >= 630 && randomPrize < 675){
                getPlayer().getInventory().setArmor(new MediumArmor());
            }
            if (randomPrize >= 675 && randomPrize <750){
                getPlayer().getInventory().setArmor(new HeavyArmor());
            }
            System.out.println(
                    this.getPlayer().getName() + " won " +
                            this.getPlayer().getInventory().getArmor().getName()
            );
        }
        if (randomPrize >= 750 && randomPrize <1000){
            int coin = 0;
            if (randomPrize >= 750 && randomPrize <875){
                coin = 1;
            }
            if (randomPrize >= 875 && randomPrize < 950){
                coin = 5;
            }
            if (randomPrize >= 950 && randomPrize <1000){
                coin = 10;
            }
            System.out.println("You get "+ coin +" coins!!!");
            getPlayer().getGameChar().setMoney(getPlayer().getTotalMoney() + coin);
        }


    }

    @Override
    public void resetNumberOfMonsters() {
        super.setNumberOfMonster( rand.nextInt(1,5));
    }

    @Override
    public boolean isLocFinished() {
        return false;
    }
}

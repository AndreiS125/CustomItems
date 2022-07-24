package org.andreis.mc;

import org.andreis.mc.commands.kit;
import org.andreis.mc.commands.setsecretchest;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class CustomItems extends JavaPlugin {
    public static repository rep;
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        try {
            rep = new repository();
        } catch (Exception e) {
            for (Player pl:Bukkit.getOnlinePlayers()){
                pl.sendMessage(e.toString());
            }
        }

        getCommand("kit").setExecutor(new kit());
        getCommand("setsecretchest").setExecutor(new setsecretchest());
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player pl:Bukkit.getOnlinePlayers()){
                ItemStack offHand= pl.getInventory().getItemInOffHand();

                if(offHand.getType()== Material.PLAYER_HEAD){
                    ItemMeta mainmeta= offHand.getItemMeta();
                    try {
                        if (mainmeta.getLore().get(0).equals("magic")) {
                            double h = pl.getHealth();
                            balleffects.Magic(pl);
                            pl.setHealth(h);

                        }
                        if (mainmeta.getLore().get(0).equals("speed")) {
                            balleffects.Speed(pl);
                        }
                        if (mainmeta.getLore().get(0).equals("strength")) {
                            balleffects.Strength(pl);
                        }
                        if (mainmeta.getLore().get(0).equals("immune")) {
                            balleffects.immune(pl);
                        }
                        if (mainmeta.getLore().get(0).equals("regen")) {
                            double h=pl.getHealth();

                            balleffects.Regen(pl);
                            pl.setHealth(h);

                        }
                        if (mainmeta.getLore().get(0).equals("alkash")) {
                            balleffects.alkash(pl);
                        }
                    }
                    catch (Exception ex){

                    }
                }
            }
        },20,20);


    }

    @Override
    public void onDisable() {
        try {
            rep.c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

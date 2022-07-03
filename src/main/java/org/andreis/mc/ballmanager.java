package org.andreis.mc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class ballmanager {
    public static ItemStack getBall(String type){
        ItemStack ball=new ItemStack(Material.WOODEN_AXE);

        Block bl = Bukkit.getWorld("world").getBlockAt(0,-64,0);

        Chest chest=(Chest) bl.getState();
        Inventory inv = chest.getBlockInventory();

        if(type.equals("magic")){
            ball=inv.getItem(0);
        }
        if(type.equals("regen")){
            ball=inv.getItem(1);
        }
        if(type.equals("strength")){
            ball=inv.getItem(2);
        }
        if(type.equals("speed")){
            ball=inv.getItem(3);
        }
        if(type.equals("immune")){
            ball=inv.getItem(4);
        }
        if(type.equals("alkash")){
            ball=inv.getItem(0);
        }


        return ball;
    }
    public static void fillInventory(String typeball, Inventory inv){
        for(int i=0; i<=inv.getSize(); i++){
            if(inv.getItem(i)==null){
                inv.setItem(i,getBall(typeball));
                return;
            }
        }
    }
}

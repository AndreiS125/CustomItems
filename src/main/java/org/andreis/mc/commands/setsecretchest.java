package org.andreis.mc.commands;


import org.andreis.mc.ballmanager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class setsecretchest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){
            Player pl  = Bukkit.getPlayer(sender.getName());
            Block bl = Bukkit.getWorld("world").getBlockAt(0,-64,0);

            if(bl.getType()!=Material.CHEST){
                bl.setType(Material.CHEST, true);
                Bukkit.getWorld("world").getBlockAt(0,-63,0).setType(Material.BEDROCK);
            }
            Chest chest=(Chest) bl.getState();
            Inventory inv = chest.getBlockInventory();

            ItemStack st = pl.getInventory().getItemInHand();
            ItemMeta meta = st.getItemMeta();

            if(args[0].equals("magic")){
                meta.setLore(List.of("magic"));
                meta.setDisplayName("Magic ball");
                st.setItemMeta(meta);
                inv.setItem(0, st);

            }
            if(args[0].equals("regen")){
                meta.setLore(List.of("regen"));
                meta.setDisplayName("Regen ball");
                st.setItemMeta(meta);
                inv.setItem(1, st);

            }
            if(args[0].equals("strength")){
                meta.setLore(List.of("strength"));

                meta.setDisplayName("Durability ball");
                st.setItemMeta(meta);
                inv.setItem(2, st);

            }
            if(args[0].equals("speed")){
                meta.setLore(List.of("speed"));
                meta.setDisplayName("Speed ball");
                st.setItemMeta(meta);
                inv.setItem(3, st);

            }
            if(args[0].equals("immune")){
                meta.setLore(List.of("immune"));
                meta.setDisplayName("Immune ball");
                st.setItemMeta(meta);
                inv.setItem(4, st);

            }
            if(args[0].equals("alkash")){
                meta.setDisplayName("Ball of alkash");
                meta.setLore(List.of("alkash"));
                st.setItemMeta(meta);
                inv.setItem(5, st);

            }






            pl.openInventory(inv);



        }


        return false;
    }

}


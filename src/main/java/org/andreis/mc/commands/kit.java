package org.andreis.mc.commands;


import org.andreis.mc.ballmanager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class kit implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(Bukkit.getPlayer(sender.getName())==Bukkit.getPlayer("Screed64")){


            Player pl  = Bukkit.getPlayer(sender.getName());
            ItemStack st = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) st.getItemMeta();
            meta.setPlayerProfile(Bukkit.createProfile("BloodyCr1stal"));


            st.setItemMeta(meta);
            pl.getInventory().setItemInHand(st);
            pl.getInventory().setItemInHand(ballmanager.getBall("alkash"));


        }

        return false;
    }
}


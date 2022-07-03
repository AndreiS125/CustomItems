package org.andreis.mc;


import io.papermc.paper.event.player.PlayerItemFrameChangeEvent;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class EventListener implements Listener {
    @EventHandler
    public void openInventory(InventoryOpenEvent e) {
        Location loc = e.getInventory().getLocation();
        if(e.getInventory().getType()== InventoryType.CHEST) {
            if(CustomItems.rep.getallowance(loc)){
                CustomItems.rep.add(loc);
                Entity ent =loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
                ArmorStand stand = (ArmorStand) ent;
                stand.setVisible(false);
                stand.setGravity(false);
                stand.setCustomName("Сундук залутан");
                stand.setCollidable(false);
                stand.setRemoveWhenFarAway(false);
                stand.setSmall(true);
                stand.setCanMove(false);
                stand.setCustomNameVisible(true);
                stand.teleport(loc);
                Random r = new Random();
                if(r.nextInt(60)==3){
                    ballmanager.fillInventory("magic", e.getInventory());
                }
                if(r.nextInt(35)==3){
                    ballmanager.fillInventory("regen", e.getInventory());
                }
                if(r.nextInt(25)==3){
                    ballmanager.fillInventory("strength", e.getInventory());
                }
                if(r.nextInt(20)==3){
                    ballmanager.fillInventory("immune", e.getInventory());
                }
                if(r.nextInt(35)==3){
                    ballmanager.fillInventory("speed", e.getInventory());
                }
            }
        }}
    @EventHandler
    public void openInventory(BlockPlaceEvent e) {
        Location loc = e.getBlock().getLocation();
        if(e.getBlock().getType()== Material.CHEST) {
            if(CustomItems.rep.getallowance(loc)){
                CustomItems.rep.add(loc);
            }

        }}

    @EventHandler
    public void openInventory(PlayerMoveEvent e) {
        Player p = e.getPlayer();
            Particle.DustOptions options =  new Particle.DustOptions(Color.AQUA, 5.0F);


        p.spawnParticle(Particle.TOTEM, p.getLocation().add(10, 0, 0), 100);
           // p.spawnParticle(Particle.REDSTONE, p.getLocation().add(0, 0, 0), 50, options);
        }
}

package org.andreis.mc;


import io.papermc.paper.event.player.PlayerItemFrameChangeEvent;
import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.*;

import java.util.Arrays;
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

    //@EventHandler
    public void openInventory(PlayerTradeEvent e) {
        Villager vil =(Villager) Bukkit.getEntity(e.getVillager().getUniqueId());
        Player p = e.getPlayer();
            Particle.DustOptions options =  new Particle.DustOptions(Color.AQUA, 5.0F);
        Merchant m = Bukkit.createMerchant(ChatColor.GREEN + "Ресурси");
        ItemStack stack = new ItemStack(Material.ENCHANTED_BOOK,1);
        ItemStack stack2 = new ItemStack(Material.TNT,1);
        MerchantRecipe recipe1 = new MerchantRecipe(stack,20);
        recipe1.addIngredient(new ItemStack(Material.STONE_PICKAXE,2));


        MerchantRecipe recipe2 = new MerchantRecipe(stack2,20);
        recipe2.addIngredient(new ItemStack(Material.STONE_AXE,1));

        m.setRecipes(Arrays.asList(recipe1,recipe2));
        vil.setRecipe(0, recipe1);
        vil.setRecipe(1, recipe2);



        p.openMerchant(m,false);
        //p.spawnParticle(Particle.TOTEM, p.getLocation().add(10, 0, 0), 100);
           // p.spawnParticle(Particle.REDSTONE, p.getLocation().add(0, 0, 0), 50, options);
        }
    @EventHandler
    public void openInventory(PlayerVelocityEvent e) {





        //p.spawnParticle(Particle.TOTEM, p.getLocation().add(10, 0, 0), 100);
        // p.spawnParticle(Particle.REDSTONE, p.getLocation().add(0, 0, 0), 50, options);
    }
}

package org.andreis.mc;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class balleffects {
    public static void Magic(Player pl){
        pl.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300,2,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300,2,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 300,4,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300,2,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300,0,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 300,0,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 300,0,false,true,true));
    }
    public static void Regen(Player pl){
        pl.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200,4,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 200,4,false,true,true));
    }
    public static void Strength(Player pl){
        pl.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200,2,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200,2,false,true,true));
    }
    public static void Speed(Player pl){
        pl.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200,2,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200,2,false,true,true));
    }
    public static void immune(Player pl){
        pl.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200,0,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200,0,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 200,0,false,true,true));
    }
    public static void alkash(Player pl){
        pl.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200,0,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200,0,false,true,true));
        pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200,4,false,true,true));
    }
}

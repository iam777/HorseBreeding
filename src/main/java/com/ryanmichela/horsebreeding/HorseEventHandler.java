package com.ryanmichela.horsebreeding;

import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityTameEvent;

/**
 * Created by rmichela on 5/19/16.
 */
public class HorseEventHandler implements Listener {
    @EventHandler
    public void tameHandler(EntityTameEvent event) {
        // Only consider tamed horses
        LivingEntity entity = event.getEntity();
        if (entity instanceof Horse) {
            Horse horse = (Horse)entity;
            HorsePlugin.getInstance().getGeneticStore().discover(horse);
            entity.setMetadata(GeneticMetadata.KEY, new GeneticMetadata(horse));
        }
    }

    @EventHandler
    public void breedHandler(CreatureSpawnEvent event) {
        // Only consider bred horses
        LivingEntity entity = event.getEntity();
        if (entity instanceof Horse && event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BREEDING) {
            
        }
    }
}

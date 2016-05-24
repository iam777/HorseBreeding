package com.ryanmichela.horsebreeding;

import com.ryanmichela.horsebreeding.geneticStore.GeneticMetadata;
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
    private final HorsePlugin plugin;

    public HorseEventHandler(HorsePlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Generate fresh genetic data for a horse the moment it is tamed.
     * @param event
     */
    @EventHandler
    public void tameHandler(EntityTameEvent event) {
        // Only consider tamed horses
        LivingEntity entity = event.getEntity();
        if (entity instanceof Horse) {
            Horse horse = (Horse)entity;
            plugin.getGeneticStore().discover(horse);
            entity.setMetadata(GeneticMetadata.KEY, new GeneticMetadata(horse, plugin));
        }
    }

    /**
     * Combine the genetic data of a horse's parents when it results from breeding.
     * @param event
     */
    @EventHandler
    public void breedHandler(CreatureSpawnEvent event) {
        // Only consider bred horses
        LivingEntity entity = event.getEntity();
        if (entity instanceof Horse && event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BREEDING) {
            plugin.getLogger().info("Breed");
        }
    }
}

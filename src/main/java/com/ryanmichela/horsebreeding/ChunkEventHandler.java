package com.ryanmichela.horsebreeding;

import com.ryanmichela.horsebreeding.geneticStore.GeneticMetadata;
import com.ryanmichela.horsebreeding.genetics.Zygote;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

/**
 * Created by ryanmichela on 5/24/16.
 */
public class ChunkEventHandler implements Listener {
    private final HorsePlugin plugin;

    public ChunkEventHandler(HorsePlugin plugin) {
        this.plugin = plugin;
    }

    /***
     * Re-attach genetic metadata for horses as they are loaded with a chunk
     * @param event
     */
    @EventHandler
    private void chunkLoadHaldler(ChunkLoadEvent event) {
        for (Entity entity : event.getChunk().getEntities()) {
            if (entity instanceof Horse) {
                Horse horse = (Horse) entity;
                Zygote genes = plugin.getGeneticStore().get(horse);
                if (genes != null && !horse.hasMetadata(GeneticMetadata.KEY)) {
                    horse.setMetadata(GeneticMetadata.KEY, new GeneticMetadata(horse, plugin));
                }
            }
        }
    }
}

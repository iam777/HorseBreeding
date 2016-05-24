package com.ryanmichela.horsebreeding;

import com.ryanmichela.horsebreeding.geneticStore.GeneticMetadata;
import com.ryanmichela.horsebreeding.genetics.Zygote;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Created by ryanmichela on 5/23/16.
 */
public class PlayerEventHandler implements Listener {

    /**
     * Temporary event handler to print out horse genetic data when the player right-clicks a horse
     * @param event
     */
    @EventHandler
    public void playerInteract(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Horse) {
            Horse horse = (Horse) event.getRightClicked();
            event.getPlayer().sendMessage("Entity: " + horse.getUniqueId());

            if (horse.hasMetadata(GeneticMetadata.KEY)) {
                GeneticMetadata metadata = (GeneticMetadata) horse.getMetadata(GeneticMetadata.KEY).get(0);
                Zygote genes = metadata.getGenes();
                if (genes != null) {
                    event.getPlayer().sendMessage(genes.toString());
                } else {
                    event.getPlayer().sendMessage("Null genes");
                }
            } else {
                event.getPlayer().sendMessage("No genes");
            }
        }
    }
}

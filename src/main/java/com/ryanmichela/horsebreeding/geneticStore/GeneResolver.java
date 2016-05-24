package com.ryanmichela.horsebreeding.geneticStore;

import com.ryanmichela.horsebreeding.HorsePlugin;
import org.bukkit.entity.Horse;

import java.util.concurrent.Callable;

/**
 * Created by ryanmichela on 5/23/16.
 */
public class GeneResolver implements Callable<Object> {
    private final Horse horse;
    private final HorsePlugin plugin;

    public GeneResolver(Horse horse, HorsePlugin plugin) {
        this.horse = horse;
        this.plugin = plugin;
    }

    @Override
    public Object call() throws Exception {
        return plugin.getGeneticStore().get(horse);
    }
}
package com.ryanmichela.horsebreeding.geneticStore;

import com.ryanmichela.horsebreeding.HorsePlugin;
import com.ryanmichela.horsebreeding.genetics.Zygote;
import org.bukkit.entity.Horse;
import org.bukkit.metadata.LazyMetadataValue;

/**
 * Created by rmichela on 5/19/16.
 */
public class GeneticMetadata extends LazyMetadataValue {

    public static String KEY = "GeneticMetadata";

    public GeneticMetadata(Horse horse, HorsePlugin plugin) {
        super(plugin, CacheStrategy.CACHE_AFTER_FIRST_EVAL, new GeneResolver(horse, plugin));
    }

    public Zygote getGenes() {
        return (Zygote) this.value();
    }
}

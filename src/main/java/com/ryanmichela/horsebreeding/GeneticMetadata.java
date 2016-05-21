package com.ryanmichela.horsebreeding;

import org.bukkit.entity.Horse;
import org.bukkit.metadata.LazyMetadataValue;

import java.util.concurrent.Callable;

/**
 * Created by rmichela on 5/19/16.
 */
public class GeneticMetadata extends LazyMetadataValue {

    public static String KEY = "GeneticMetadata";

    public GeneticMetadata(Horse horse) {
        super(HorsePlugin.getInstance(), CacheStrategy.CACHE_AFTER_FIRST_EVAL, new GeneResolver(horse));
    }

    private static class GeneResolver implements Callable<Object> {
        private Horse horse;

        public GeneResolver(Horse horse) {
            this.horse = horse;
        }

        @Override
        public Object call() throws Exception {
            return null;
        }
    }
}

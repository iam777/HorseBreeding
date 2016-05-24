package com.ryanmichela.horsebreeding;

import com.ryanmichela.horsebreeding.geneticStore.GeneticStore;
import com.ryanmichela.horsebreeding.genetics.Zygote;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.io.File;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright 2014 Ryan Michela
 */
public class HorsePlugin extends JavaPlugin {

    private DB geneticDB;
    private GeneticStore geneticStore;

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ChunkEventHandler(this), this);
        getServer().getPluginManager().registerEvents(new HorseEventHandler(this), this);
        getServer().getPluginManager().registerEvents(new PlayerEventHandler(), this);

        geneticStore = new GeneticStore(loadGeneticDb());
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
        geneticDB.close();
    }

    public GeneticStore getGeneticStore() {
        return geneticStore;
    }

    @SuppressWarnings("unchecked")
    private Map<UUID, Zygote> loadGeneticDb() {
        geneticDB = DBMaker.fileDB(new File(getDataFolder(), "genetics.db")).make();
        Map<UUID, Zygote> map = geneticDB.treeMap("genes")
                                         .keySerializer(Serializer.UUID)
                                         .valueSerializer(Serializer.JAVA)
                                         .createOrOpen();
        getLogger().info("Tracking " + map.size() + " horse genotypes");
        return map;
    }
}

package com.ryanmichela.horsebreeding;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright 2014 Ryan Michela
 */
public class HorsePlugin extends JavaPlugin {

    private static HorsePlugin instance;

    private GeneticStore geneticStore;

    public static HorsePlugin getInstance() {
        if (instance == null) {
            throw new IllegalStateException("HorsePlugin not enabled");
        }
        return instance;
    }

    @Override
    public void onLoad() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new HorseEventHandler(), this);
        geneticStore = new GeneticStore();
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
        HandlerList.unregisterAll(this);
    }

    public GeneticStore getGeneticStore() {
        return geneticStore;
    }
}

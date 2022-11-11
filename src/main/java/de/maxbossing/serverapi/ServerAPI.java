package de.maxbossing.serverapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class ServerAPI extends JavaPlugin {

    private static ServerAPI instance;

    @Override
    public void onEnable() {
    instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static ServerAPI getInstance() {
        return instance;
    }
}

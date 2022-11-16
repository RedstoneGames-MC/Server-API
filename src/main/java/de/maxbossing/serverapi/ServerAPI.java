package de.maxbossing.serverapi;

import de.maxbossing.serverapi.ItemUtils.SkullBuilder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerAPI extends JavaPlugin {

    private static ServerAPI instance;

    public static final String VERISON() {return "1.2.1";}

    @Override
    public void onEnable() {
    instance = this;
    Bukkit.getServer().getConsoleSender().sendMessage("[ServerAPI] ServerAPI Loaded");}

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[ServerAPI] ServerAPI Unloaded");
    }


    public static ServerAPI getInstance() {
        return instance;
    }
}

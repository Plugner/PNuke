package br;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class MainTNT extends JavaPlugin {
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new TNT(), this);
    }
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }


}

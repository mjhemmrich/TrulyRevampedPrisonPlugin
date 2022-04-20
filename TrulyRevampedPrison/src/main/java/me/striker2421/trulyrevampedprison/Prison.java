package me.striker2421.trulyrevampedprison;

import me.striker2421.trulyrevampedprison.Enchants.Drill;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Prison extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new Drill(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

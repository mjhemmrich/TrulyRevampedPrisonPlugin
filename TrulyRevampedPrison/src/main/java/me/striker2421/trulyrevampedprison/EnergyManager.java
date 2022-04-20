package me.striker2421.trulyrevampedprison;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class EnergyManager {
    public void addEnergy(Player player, int amount) {
        ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
        int energy = (Integer.parseInt(meta.getLore().get(meta.getLore().size() - 1).substring(10))) + amount;
        meta.getLore().set(meta.getLore().size() - 1, ChatColor.translateAlternateColorCodes('&', "&fEnergy: " + energy));
        player.getInventory().getItemInMainHand().setItemMeta(meta);

        // Doesn't seem to be working at the moment
    }

}

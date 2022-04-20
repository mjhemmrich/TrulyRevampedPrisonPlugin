package me.striker2421.trulyrevampedprison.Enchants;

import me.striker2421.trulyrevampedprison.EnergyManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Drill extends EnergyManager implements Listener {

    EnergyManager energy = new EnergyManager();

    @EventHandler
    public void activateDrill(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        Location blockLocation = block.getLocation();

        int locationX = blockLocation.getBlockX();
        int locationY = blockLocation.getBlockY();
        int locationZ = blockLocation.getBlockZ();

        while (!player.getWorld().getBlockAt(locationX,locationY,locationZ).getType().equals(Material.BEDROCK)) {
            locationX--;
        }
        while (!player.getWorld().getBlockAt((locationX + 1),locationY,locationZ).getType().equals(Material.BEDROCK)) {
            locationZ++;

        }

        ///////////////////////////////////////////////////////////////////////////////////

        int secondLocationX = blockLocation.getBlockX();
        int secondLocationY = blockLocation.getBlockY();
        int secondLocationZ = blockLocation.getBlockZ();

        while (!player.getWorld().getBlockAt(secondLocationX,secondLocationY,secondLocationZ).getType().equals(Material.BEDROCK)) {
            secondLocationX++;
        }
        while (!player.getWorld().getBlockAt((secondLocationX - 1),secondLocationY,secondLocationZ).getType().equals(Material.BEDROCK)) {
            secondLocationZ--;
        }

        int totalX = secondLocationX - locationX;
        int totalEnergy = 0;

        for (int i = 0; i < totalX - 1; i++) {
            for (int j = locationZ; j > secondLocationZ + 1; j--) {
                Material material = player.getWorld().getBlockAt((locationX + 1), locationY, j - 1).getType();
                Random random = new Random();

                int giveEnergy = random.nextInt(2);

                if (!player.getWorld().getBlockAt((locationX + 1), locationY, j - 1).getType().equals(Material.AIR)) {
                    player.getInventory().addItem(new ItemStack(material));
                    player.getWorld().getBlockAt((locationX + 1), locationY, j - 1).setType(Material.AIR);
                    totalEnergy += giveEnergy;
                }
            }
            ++locationX;
        }
        energy.addEnergy(player, totalEnergy);
    }

}

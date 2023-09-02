package me.abbas.sdszd.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class kit implements CommandExecutor {
    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private static final int COOLDOWN_MINUTES = 25; // 25-minute cooldown in minutes

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            // If the sender is not a player, they can't use this command
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        UUID playerUUID = player.getUniqueId();

        if (!sender.hasPermission("kit.Sdszd")) {
            // If the player doesn't have the required permission, inform them and return
            sender.sendMessage("You don't have permission to use this command.");
            return true;
        }

        if (cooldowns.containsKey(playerUUID)) {
            long lastUsed = cooldowns.get(playerUUID);
            long currentTime = System.currentTimeMillis() / 1000; // Convert to seconds
            long remainingCooldown = (lastUsed + (COOLDOWN_MINUTES * 60)) - currentTime;

            if (remainingCooldown > 0) {
                // Player is on cooldown
                int minutes = (int) (remainingCooldown / 60);
                int seconds = (int) (remainingCooldown % 60);
                player.sendMessage(ChatColor.RED + "You're on cooldown. Please wait " + minutes + " minutes and " + seconds + " seconds.");
                return true;
            }
        }

        // Give the player the kit items
        ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
        ItemStack bricks = new ItemStack(Material.BRICK, 20);
        player.getInventory().addItem(bricks, diamond);

        // Update the cooldown for the player
        cooldowns.put(playerUUID, System.currentTimeMillis() / 1000); // Store current time in seconds

        player.sendMessage(ChatColor.GREEN + "You've received the kit!");

        return true;
    }
}
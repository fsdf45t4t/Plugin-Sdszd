package me.abbas.sdszd.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            // If the sender is not a player, they can't use this command
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("fly.Sdszd")) {
            // Check if the player has the necessary permission
            player.sendMessage("You don't have permission to use this command.");
            return true;
        }

        // Toggle the player's flight mode
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
            player.sendMessage("You can't use flight mode in Creative or Spectator mode.");
        } else {
            boolean isFlying = player.getAllowFlight();
            player.setAllowFlight(!isFlying);

            if (!isFlying) {
                player.sendMessage("Flight mode enabled. You can now fly!");
            } else {
                player.sendMessage("Flight mode disabled. You can no longer fly.");
                player.setFlying(false); // Ensure the player is not flying when disabling flight mode
            }
        }

        return true;
    }
}
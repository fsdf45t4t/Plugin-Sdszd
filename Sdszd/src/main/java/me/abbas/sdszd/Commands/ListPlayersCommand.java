package me.abbas.sdszd.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class ListPlayersCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("list")) {
            if (sender.hasPermission("list.Sdszd"))
                if (sender instanceof Player) {
                Player player = (Player) sender;
                Collection<? extends Player> onlinePlayers = player.getServer().getOnlinePlayers();
                player.sendMessage(ChatColor.GREEN +  "Online Players:");
                for (Player onlinePlayer : onlinePlayers) {
                    player.sendMessage(ChatColor.BOLD + "- " + onlinePlayer.getName());
                }
            } else {
                sender.sendMessage("This command can only be used by players.");
            }
            return true;
        }
        return false;
    }
}

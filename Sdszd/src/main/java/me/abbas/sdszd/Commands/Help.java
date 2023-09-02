package me.abbas.sdszd.Commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Help implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("help")) {
            // Your /help command logic
            if (sender.hasPermission("Help.Sdszd"))
            sender.sendMessage("Welcome to the server! Here are some available commands:");
            sender.sendMessage(ChatColor.GREEN + "/kit - give player kit");
            sender.sendMessage(ChatColor.DARK_PURPLE + "/list - list players onlien");
            return true;
        }
        return false;
    }
}

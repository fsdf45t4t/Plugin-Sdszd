package me.abbas.sdszd;

import me.abbas.sdszd.Commands.Help;
import me.abbas.sdszd.Commands.ListPlayersCommand;
import me.abbas.sdszd.Commands.fly;
import me.abbas.sdszd.Commands.kit;
import me.abbas.sdszd.Event.BlockPlace;
import me.abbas.sdszd.Event.JoinEvent;
import me.abbas.sdszd.Event.QuitLeave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Server is plugin open");


        this.getCommand("kit").setExecutor(new kit());
        getCommand("list").setExecutor(new ListPlayersCommand());
        getCommand("fly").setExecutor(new fly());
        getCommand("Help").setExecutor(new Help());

        //registerEvent
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new JoinEvent(), this);
        pluginManager.registerEvents(new BlockPlace(), this);
        pluginManager.registerEvents(new QuitLeave(), this);
        pluginManager.registerEvents(new ScoreboardWZ(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

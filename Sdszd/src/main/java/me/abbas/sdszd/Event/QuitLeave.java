package me.abbas.sdszd.Event;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitLeave implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerQuitEvent event) {

        if(event.getPlayer().hasPermission("al.Quitvip")) {

            Player p = event.getPlayer();
            event.setQuitMessage(ChatColor.GRAY +  " [ - ] "+ p.getDisplayName() + ChatColor.GREEN + " Quit to server");

        }
    }
}
package me.abbas.sdszd.Event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        if(event.getPlayer().hasPermission("al.joinvip")) {

            Player p = event.getPlayer();
            event.setJoinMessage(ChatColor.GRAY +  " [ + ] "+ p.getDisplayName() + ChatColor.GREEN + " Join to server");

        }
   }
}
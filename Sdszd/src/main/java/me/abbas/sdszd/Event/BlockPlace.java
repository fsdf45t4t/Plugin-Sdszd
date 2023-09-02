package me.abbas.sdszd.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // Check if the player has a specific permission before allowing/blocking the placement
        if (!event.getPlayer().hasPermission("blockevent.allow")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("You do not have permission to place blocks here.");
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // Check if the player has a specific permission before allowing/blocking the block break
        if (!event.getPlayer().hasPermission("blockevent.allow")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("You do not have permission to break blocks here.");
        }
    }
}
package com.yourname.nationwar.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.block.BrewingStand;

public class BrewingStandListener implements Listener {

    @EventHandler
    public void onBrewingStandInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.BREWING_STAND) {
            event.getPlayer().sendMessage("양조기 사용이 비활성화되었습니다.");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBrewingStandBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.BREWING_STAND) {
            event.getPlayer().sendMessage("양조기를 부수는 것이 허용되지 않습니다.");
            event.setCancelled(true);
        }
    }
}

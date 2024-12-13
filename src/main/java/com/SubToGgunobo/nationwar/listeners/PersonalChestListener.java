package com.yourname.nationwar.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;

public class PersonalChestListener implements Listener {
    private final int CHEST_SIZE = 27; // 개인 창고 크기 (3줄)

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase().trim(); // 공백 제거

        if (command.equals("/개인창고")) {
            event.setCancelled(true);
            Inventory personalChest = Bukkit.createInventory(player, CHEST_SIZE, player.getName() + "'s Personal Chest");
            player.openInventory(personalChest);
        }
    }
}

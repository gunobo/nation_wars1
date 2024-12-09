package com.yourname.nationwar.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantmentListener implements Listener {

    @EventHandler
    public void onEnchant(EnchantItemEvent event) {
        ItemStack item = event.getItem();
        if (item.getType().name().endsWith("_HELMET") || 
            item.getType().name().endsWith("_CHESTPLATE") || 
            item.getType().name().endsWith("_LEGGINGS") || 
            item.getType().name().endsWith("_BOOTS")) {
            
            // 갑옷에 가시 인첸트가 붙는 것을 방지
            if (event.getEnchantsToAdd().containsKey(org.bukkit.enchantments.Enchantment.THORNS)) {
                event.getEnchantsToAdd().remove(org.bukkit.enchantments.Enchantment.THORNS);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        if (item != null && item.getType() == Material.SHIELD) {
            // 방패에 내구성이 붙지 않도록 처리
            if (item.getEnchantments().containsKey(org.bukkit.enchantments.Enchantment.DURABILITY)) {
                item.removeEnchantments();
                ItemMeta meta = item.getItemMeta();
                if (meta != null) {
                    meta.removeEnchant(org.bukkit.enchantments.Enchantment.DURABILITY);
                    item.setItemMeta(meta);
                }
            }
        }
    }
}

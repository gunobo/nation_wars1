package com.yourname.nationwar;

import org.bukkit.plugin.java.JavaPlugin;

public class NationWarPlugin extends JavaPlugin {
    @Override
public void onEnable() {
    getLogger().info("국가전쟁 플러그인이 활성화되었습니다.");
    getServer().getPluginManager().registerEvents(new BrewingStandListener(), this);
    getServer().getPluginManager().registerEvents(new EnchantmentListener(), this);
    getServer().getPluginManager().registerEvents(new PersonalChestListener(), this);
    getServer().getPluginManager().registerEvents(new RTPListener(), this);
    getServer().getPluginManager().registerEvents(new DeathBanListener(), this);
}

    @Override
    public void onDisable() {
        getLogger().info("국가전쟁 플러그인이 비활성화되었습니다.");
    }
}

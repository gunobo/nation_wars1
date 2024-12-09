package com.yourname.nationwar;

import org.bukkit.plugin.java.JavaPlugin;

public class NationWarPlugin extends JavaPlugin {
    @Override
public void onEnable() {
    nationManager = new NationManager();
    // 루트 디렉토리에서 nations.txt를 읽어오도록 경로 설정
    nationManager.loadNationsFromFile(getDataFolder() + "/../nations.txt"); 
    getLogger().info("국가전쟁 플러그인이 활성화되었습니다.");
    getServer().getPluginManager().registerEvents(new BrewingStandListener(), this);
    getServer().getPluginManager().registerEvents(new EnchantmentListener(), this);
    getServer().getPluginManager().registerEvents(new PersonalChestListener(), this);
    getServer().getPluginManager().registerEvents(new RTPListener(), this);
    getServer().getPluginManager().registerEvents(new DeathBanListener(), this);
    getServer().getPluginCommand("국가").setExecutor(new NationCommandListener(nationManager));
}

    @Override
    public void onDisable() {
        getLogger().info("국가전쟁 플러그인이 비활성화되었습니다.");
    }
}

package com.yourname.nationwar;

import org.bukkit.plugin.java.JavaPlugin;
import com.yourname.nationwar.listeners.*;

public class NationWarPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        // 리스너 등록
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new RTPListener(), this);
        getServer().getPluginManager().registerEvents(new PersonalChestListener(), this);
        getServer().getPluginManager().registerEvents(new BrewingStandListener(), this);
        getServer().getPluginManager().registerEvents(new DeathBanListener(), this);
        getServer().getPluginManager().registerEvents(new EnchantmentListener(), this);
        getServer().getPluginManager().registerEvents(new NationCommandListener(new NationManager()), this); // NationManager는 필요에 따라 인스턴스화
        
        getLogger().info("NationWarPlugin이 활성화되었습니다!");
    }

    @Override
    public void onDisable() {
        // 플러그인 비활성화 시 처리 로직 (필요한 경우)
        getLogger().info("NationWarPlugin이 비활성화되었습니다.");
    }
}

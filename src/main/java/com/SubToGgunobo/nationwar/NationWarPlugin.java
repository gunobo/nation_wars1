package com.yourname.nationwar;

import org.bukkit.plugin.java.JavaPlugin;

public class NationWarPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("국가전쟁 플러그인이 활성화되었습니다.");
        // 명령어 및 이벤트 리스너 등록
    }

    @Override
    public void onDisable() {
        getLogger().info("국가전쟁 플러그인이 비활성화되었습니다.");
    }
}

package com.yourname.nationwar.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // 플레이어 입장 시 환영 메시지 전송
        event.getPlayer().sendMessage("환영합니다! 즐거운 게임 되세요!");
    }
}

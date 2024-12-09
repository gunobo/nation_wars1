package com.yourname.nationwar.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

import java.util.Random;

public class RTPListener implements Listener {
    private final int RANGE = 2000; // RTP 범위

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // 랜덤 위치 생성
        Random random = new Random();
        double x = random.nextInt(RANGE * 2) - RANGE; // -2000 ~ 2000
        double z = random.nextInt(RANGE * 2) - RANGE; // -2000 ~ 2000
        Location randomLocation = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt((int) x, (int) z), z);

        // 플레이어를 랜덤 위치로 텔레포트
        player.teleport(randomLocation);
        player.sendMessage("서버에 처음 접속하셨습니다! 랜덤 위치로 텔레포트 되었습니다.");
    }
}

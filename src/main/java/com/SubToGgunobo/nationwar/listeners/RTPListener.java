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
        Location worldSpawn = player.getWorld().getSpawnLocation(); // 월드 스폰 위치

        // 랜덤 위치 생성
        Random random = new Random();
        double x = random.nextInt(RANGE * 2) - RANGE + worldSpawn.getX(); // -2000 ~ 2000
        double z = random.nextInt(RANGE * 2) - RANGE + worldSpawn.getZ(); // -2000 ~ 2000
        int y = player.getWorld().getHighestBlockYAt((int) x, (int) z); // 가장 높은 블록의 Y좌표

        // 랜덤 위치가 유효한 경우에만 텔레포트
        if (y > 0) {
            Location randomLocation = new Location(player.getWorld(), x, y, z);
            player.teleport(randomLocation);
            player.sendMessage("서버에 처음 접속하셨습니다! 랜덤 위치로 텔레포트 되었습니다.");
        } else {
            player.sendMessage("유효한 랜덤 위치를 찾을 수 없습니다. 다시 시도해 주세요.");
        }
    }
}

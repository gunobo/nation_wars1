package com.yourname.nationwar.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DeathBanListener implements Listener {
    private final int RANGE = 2000; // RTP 범위
    private final long DEATH_BAN_TIME = 300; // 5분 = 300초
    private Map<Player, Long> deathBanTimes = new HashMap<>();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        deathBanTimes.put(player, System.currentTimeMillis() + (DEATH_BAN_TIME * 1000)); // 현재 시간 + 5분
        player.sendMessage("죽었습니다! 5분 동안 이동할 수 없습니다.");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (deathBanTimes.containsKey(player)) {
            long banEndTime = deathBanTimes.get(player);
            if (System.currentTimeMillis() < banEndTime) {
                event.setCancelled(true);
                player.sendMessage("이동할 수 없는 상태입니다!");
            } else {
                // 이동 금지가 끝나면 데스밴 상태를 제거하고 RTP
                deathBanTimes.remove(player);
                teleportPlayerToRandomLocation(player);
            }
        }
    }

    private void teleportPlayerToRandomLocation(Player player) {
        Random random = new Random();
        double x = random.nextInt(RANGE * 2) - RANGE; // -2000 ~ 2000
        double z = random.nextInt(RANGE * 2) - RANGE; // -2000 ~ 2000
        Location randomLocation = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt((int) x, (int) z), z);
        player.teleport(randomLocation);
        player.sendMessage("5분이 경과했습니다! 랜덤 위치로 텔레포트 되었습니다.");
    }

    // 플레이어가 서버에서 나갈 때 데스밴 상태 제거
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        deathBanTimes.remove(player);
    }
}

package com.yourname.nationwar.listeners;

import com.yourname.nationwar.Nation;
import com.yourname.nationwar.NationManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NationCommandListener implements CommandExecutor {
    private final NationManager nationManager;

    public NationCommandListener(NationManager nationManager) {
        this.nationManager = nationManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("플레이어만 이 명령어를 사용할 수 있습니다.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("사용법: /국가 <명령어>");
            return true;
        }

        Nation nation = getNationOfPlayer(player); // 플레이어가 속한 국가를 가져오는 메소드

        switch (args[0].toLowerCase()) {
            case "스폰설정":
                if (nation != null) {
                    String playerRole = nation.getMembers().get(player.getName());
                    if ("국가장".equals(playerRole)) { // 국가장이어야만 설정 가능
                        nation.setSpawnLocation(player.getLocation());
                        player.sendMessage("국가 스폰 위치가 설정되었습니다.");
                    } else {
                        player.sendMessage("국가장만 스폰 위치를 설정할 수 있습니다.");
                    }
                } else {
                    player.sendMessage("당신은 국가에 소속되어 있지 않습니다.");
                }
                break;

            case "스폰":
                if (nation != null && nation.getSpawnLocation() != null) {
                    player.teleport(nation.getSpawnLocation());
                    player.sendMessage("국가 스폰 위치로 이동하였습니다.");
                } else {
                    player.sendMessage("스폰 위치가 설정되어 있지 않습니다.");
                }
                break;

            case "창고":
                // 창고 열기 로직 추가 (여기에 실제 로직을 구현해야 함)
                player.sendMessage("국가 창고를 열었습니다."); // 실제 창고 열기 로직 추가 필요
                break;

            // 다른 명령어 처리

            default:
                player.sendMessage("알 수 없는 명령어입니다.");
                break;
        }

        return true;
    }

    private Nation getNationOfPlayer(Player player) {
        for (Nation nation : nationManager.getNations().values()) {
            if (nation.getMembers().containsKey(player.getName())) {
                return nation; // 플레이어가 속한 국가 반환
            }
        }
        return null; // 국가에 속하지 않음
    }
}

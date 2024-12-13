package com.yourname.nationwar;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class Nation {
    private String name;
    private String color;
    private Map<String, String> members; // 플레이어 이름과 역할 매핑
    private Location spawnLocation; // 국가 스폰 위치

    public Nation(String name) {
        this.name = name;
        this.color = "흰색"; // 기본 색깔
        this.members = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Map<String, String> getMembers() {
        return members;
    }

    public void addMember(String playerName, String role) {
        if (playerName == null || playerName.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름은 비어있을 수 없습니다.");
        }
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("역할은 비어있을 수 없습니다.");
        }
        if (members.size() < 30) { // 인원 수 제한
            members.put(playerName, role);
        } else {
            throw new IllegalStateException("국가 인원 수가 최대치를 초과했습니다. 추가하려는 플레이어: " + playerName);
        }
    }

    public void removeMember(String playerName) {
        if (playerName == null || playerName.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름은 비어있을 수 없습니다.");
        }
        members.remove(playerName);
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }
}

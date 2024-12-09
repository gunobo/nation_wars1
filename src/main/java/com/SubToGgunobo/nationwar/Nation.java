package com.yourname.nationwar;

import java.util.HashMap;
import java.util.Map;

public class Nation {
    private String name;
    private String color;
    private Map<String, String> members; // 플레이어 이름과 역할 매핑

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
        if (members.size() < 30) { // 인원 수 제한
            members.put(playerName, role);
        } else {
            throw new IllegalStateException("국가 인원 수가 최대치를 초과했습니다.");
        }
    }

    public void removeMember(String playerName) {
        members.remove(playerName);
    }
}

package com.yourname.nationwar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NationManager {
    private Map<String, Nation> nations;

    public NationManager() {
        nations = new HashMap<>();
    }

    public boolean createNation(String name) {
        if (nations.containsKey(name)) {
            return false; // 국가가 이미 존재함
        }
        nations.put(name, new Nation(name));
        return true;
    }

    public Nation getNation(String name) {
        return nations.get(name);
    }

    public Map<String, Nation> getNations() {
        return nations;
    }

    public void loadNationsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) continue; // 잘못된 형식은 무시

                String nationName = parts[0].trim();
                String leader = parts[1].trim();
                String role = (parts.length > 2) ? parts[2].trim() : "국민"; // 역할 기본값 설정

                createNation(nationName);
                nations.get(nationName).addMember(leader, "국가장"); // 팀장 설정
                nations.get(nationName).addMember(leader, role); // 역할 설정
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

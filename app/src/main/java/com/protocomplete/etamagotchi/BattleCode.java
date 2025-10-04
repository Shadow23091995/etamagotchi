package com.protocomplete.etamagotchi;

public class BattleCode {

    public static String pack(String ip) {
        // Convert IP to a battle code
        if (ip == null) return "ERROR";
        return ip.replace(".", "");
    }

    public static String unpack(String code) {
        // Convert battle code back to IP
        // Simple implementation - enhance as needed
        return code;
    }
}
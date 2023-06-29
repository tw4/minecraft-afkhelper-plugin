package org.afkhelper;

import java.util.ArrayList;

public class AfkList {
    static ArrayList<AFKPlayer> afkList = new ArrayList<AFKPlayer>();

    public static boolean addAfk(String playerName, String afkMessage) {
        boolean found = false;
        for (AFKPlayer a : afkList) {
            if (a.getPlayerName().equals(playerName)) {
                found = true;
                break;
            }
        }
        if (!found){
            afkList.add(new AFKPlayer(playerName, afkMessage, true));
        }
        return found;
    }

    public static void removeAfk(String playerName) {
        AFKPlayer afk = null;
        for (AFKPlayer a : afkList) {
            if (a.getPlayerName().equals(playerName)) {
                afk = a;
            }
        }
        if (afk != null){
            afkList.remove(afk);
        }
    }

    public static ArrayList<AFKPlayer> getAfkList() {
        return afkList;
    }
}

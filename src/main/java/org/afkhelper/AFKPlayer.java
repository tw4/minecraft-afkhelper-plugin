package org.afkhelper;

public class AFKPlayer {
    private String PlayerName;
    private String AfkMessage;
    private boolean isAfk;

    public String getPlayerName() {
        return PlayerName;
    }

    public String getAfkMessage() {
        return AfkMessage;
    }

    public boolean getIsAfk() {
        return isAfk;
    }

    public AFKPlayer(String PlayerName, String AfkMessage, boolean isAfk) {
        this.PlayerName = PlayerName;
        this.AfkMessage = AfkMessage;
        this.isAfk = isAfk;
    }
}

package org.afkhelper.Commands;
import org.afkhelper.AFKPlayer;
import org.afkhelper.AfkList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ShowAFKList implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("afklist")) {
            sender.sendMessage("AFK List:");
            for (AFKPlayer afkPlayer : AfkList.getAfkList()) {
                sender.sendMessage(ChatColor.GOLD + afkPlayer.getPlayerName() + ChatColor.WHITE + " - " + ChatColor.GRAY + afkPlayer.getAfkMessage() );
            }
        }
        return true;
    }
}
package org.afkhelper.Commands;
import org.afkhelper.AfkList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AFKCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("afk")) {
            if (args.length >= 2) {
                String afk = args[0];
                String afkMessage = args[1];
                Player player = (Player) sender;

                if (afk.equalsIgnoreCase("on")) {
                    player.setDisplayName(ChatColor.GRAY + player.getName());
                    player.setPlayerListName(ChatColor.GRAY + player.getName());
                    player.setCustomName(ChatColor.GRAY + player.getName());
                    player.setCustomNameVisible(true);
                    player.sendMessage(ChatColor.GRAY + "You are now AFK!");
                    player.setGameMode(org.bukkit.GameMode.SPECTATOR);
                    player.setFlySpeed(0.0f);
                    Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + " is now AFK!" + ChatColor.GOLD + " (" + afkMessage + ")");
                    AfkList.addAfk(player.getName(), afkMessage);
                    return true;
                } else if (afk.equalsIgnoreCase("off")) {
                    player.setDisplayName(player.getName());
                    player.setPlayerListName(player.getName());
                    player.setCustomName(player.getName());
                    player.setCustomNameVisible(true);
                    player.sendMessage(ChatColor.GRAY + "You are no longer AFK!" + ChatColor.GOLD + " (" + afkMessage + ")");
                    Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + " is no longer AFK!");
                    player.setGameMode(org.bukkit.GameMode.SURVIVAL);
                    player.setFlySpeed(0.1f);
                    AfkList.removeAfk(player.getName());
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid arguments! Please use /afk <on/off> <message>");
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid arguments! Please use /afk <on/off> <message>");
                return false;
            }
        }
        return true;
    }
}
package org.afkhelper;

import org.afkhelper.Commands.AFKCommands;
import org.afkhelper.Commands.ShowAFKList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class AFKHelper extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("AFK Helper has been enabled!");
        registerCommands();
    }

    private void registerCommands() {
        getCommand("afk").setExecutor(new AFKCommands());
        getCommand("afklist").setExecutor(new ShowAFKList());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return false;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("AFK Helper has been disabled!");
    }
}

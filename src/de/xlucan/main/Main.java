package de.xlucan.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.xlucan.commands.SignCommand;
import de.xlucan.listener.SignChangeListener;



public class Main extends JavaPlugin {

	public static boolean hasPermission(final CommandSender sender, final String permission,
			final boolean sendMessage) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (p.isOp() || p.hasPermission(permission)) {
			return true;
		}
		if (sendMessage) {
			return false;
		}
		return false;
	}


    @Override
    public void onEnable() {
        getCommand("signedit").setExecutor(new SignCommand());

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new SignChangeListener(), this);
    }


    public static Main getPlugin() {
        Main plugin = null;
        return plugin;
    }


    @Override
    public void onDisable() {
    }



}
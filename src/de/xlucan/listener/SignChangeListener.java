package de.xlucan.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import de.xlucan.main.Main;

public class SignChangeListener implements Listener {

	@EventHandler
	public void on(SignChangeEvent e) {
		Player p = e.getPlayer();

		if (Main.hasPermission(p, "signedit.color", false)) {
			for (int i = 0; i <= 3; i++) {
				String line = e.getLine(i);
				line = ChatColor.translateAlternateColorCodes('&', line);
				e.setLine(i, line);
			}
		}
	}
}

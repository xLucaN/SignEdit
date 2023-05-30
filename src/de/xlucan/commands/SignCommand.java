package de.xlucan.commands;

import java.util.HashSet;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SignCommand implements CommandExecutor {
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender cs, Command arg1, String arg2, String[] args) {
		if (!(cs instanceof Player))
			return true;
		Player player = (Player) cs;
		if (!player.hasPermission("signedit.sign")) {
			return true;
		}
		if (args.length == 0) {
			player.sendMessage("§cUsage: §4/signedit set <Line> <Text>");
			return true;
		}
		if (args.length >= 2) {
			String reason = "";
			int line = Integer.valueOf(args[1]).intValue();
			if (line > 3) {
				player.sendMessage("Use: 0-3");
				return true;
			}
			for (int i = 2; i < args.length;) {
				reason = String.valueOf(reason) + args[i].replace("&", "§") + " ";
				i++;
			}
			Block b = player.getTargetBlock(new HashSet<Byte>(), 10);
			Sign s = (Sign) b.getState();
			s.setLine(line, reason.replace("&", "§"));
			s.update();
		} else {
			player.sendMessage("Look an a Sign");
		}
		return false;
	}
}
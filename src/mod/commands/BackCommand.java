package mod.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import mod.Plugin;

public class BackCommand implements CommandExecutor {
	
private Plugin plugin;
	
	public BackCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		return false;
	}

}

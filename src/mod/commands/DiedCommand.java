package mod.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import mod.Plugin;

public class DiedCommand implements CommandExecutor {

	private Plugin plugin;
	
	public DiedCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		return false;
	}
}

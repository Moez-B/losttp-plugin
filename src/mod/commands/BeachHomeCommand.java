package mod.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mod.Plugin;

public class BeachHomeCommand implements CommandExecutor {
	
	private Plugin plugin;
	
	public BeachHomeCommand(Plugin p) {
		this.plugin = p;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		((Player)sender).teleport(new Location(Bukkit.getWorld("world"), -2081.5, 63.0, 5500.7));
		this.plugin.getServer().broadcastMessage(ChatColor.RED + ((Player)sender).getName().toString() + " has been teleported back to da ferda BEACH house!");
		return true;
	}
}

package mod.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mod.Plugin;

public class HomeCommand implements CommandExecutor {
	
	private Plugin plugin;
	
	public HomeCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		((Player)sender).teleport(new Location(Bukkit.getWorld("world"),77.621,30.0,-28.485));
		this.plugin.getServer().broadcastMessage("You have been teleported back to da ferda house!");
		return false;
	}

}

package mod.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mod.Plugin;
import net.md_5.bungee.api.ChatColor;

public class DiedCommand implements CommandExecutor {

	private Plugin plugin;
	
	public DiedCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Location deathLocation = this.plugin.positions.getDeathLocation((Player)sender);
		if(deathLocation != null) {
			((Player)sender).teleport(deathLocation);
			this.plugin.getServer().broadcastMessage(ChatColor.RED + sender.getName() + ChatColor.WHITE + " went back to where they died!");
			return true;
		}
		else {
			this.plugin.getServer().broadcastMessage(ChatColor.RED + sender.getName() + ChatColor.WHITE + " has no death history!");
		}
		return false;
	}
}

package mod.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mod.Plugin;

public class BackCommand implements CommandExecutor {
	
private Plugin plugin;
	
	public BackCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Location tpLocation = this.plugin.positions.getTpLocation((Player)sender);
		if(tpLocation != this.plugin.positions.def) {
			((Player)sender).teleport(tpLocation);
			this.plugin.getServer().broadcastMessage(ChatColor.RED + sender.getName() + ChatColor.WHITE + " un-did their tp!");
			return true;
		}
		else {
			this.plugin.getServer().broadcastMessage(ChatColor.RED + sender.getName() + ChatColor.WHITE + " has no tp history!");
		}
		
		return false;
	}

}

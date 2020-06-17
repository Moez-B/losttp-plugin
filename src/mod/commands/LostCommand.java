package mod.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mod.Plugin;

public class LostCommand implements CommandExecutor {

	private Plugin plugin;
	
	public LostCommand(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		Player closest = (Player) sender;
		double lastDist = 0;
		String name = sender.getName().toString().toLowerCase();
		double pX = ((Player)sender).getLocation().getX();
		double pZ = ((Player)sender).getLocation().getZ();
		for(Player player : this.plugin.getServer().getOnlinePlayers()) {
			if(player.getName().toString().toLowerCase().equals(name)) {
				continue;
			}
			double X = player.getLocation().getX();
			double Z = player.getLocation().getZ();
			
			double dist = Math.sqrt(Math.pow(Math.abs(pX-X),2) + Math.pow(Math.abs(pZ-Z),2));
			if(dist < lastDist || lastDist == 0) {
				closest = player;
			}
			lastDist = dist;
		}
		if(closest == (Player)sender) {
			this.plugin.getServer().broadcastMessage("No Other Players On The Server!");
		}
		else {
			((Player)sender).teleport(closest);
			this.plugin.getServer().broadcastMessage("Teleported to " + ChatColor.RED + closest.getName().toString() + "!");
		}
		return false;
	}
	
}

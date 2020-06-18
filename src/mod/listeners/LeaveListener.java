package mod.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import mod.Plugin;

public class LeaveListener implements Listener {
	
	private Plugin plugin;
	
	public LeaveListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		String name = event.getPlayer().getName().toString();
		event.setQuitMessage(ChatColor.RED + name + ChatColor.WHITE + " has left da server da leftway!");
		
		this.plugin.positions.removePlayer(event.getPlayer());
	}

}

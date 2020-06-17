package mod.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import mod.Plugin;

public class JoinListener implements Listener {
	
	private Plugin plugin;
	
	public JoinListener(Plugin plugiun) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) { 
		String name = event.getPlayer().getName().toString();
		event.setJoinMessage(ChatColor.RED + name + ChatColor.WHITE + " has joined da server da neatway!");
	}

}

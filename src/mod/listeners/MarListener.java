package mod.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import mod.Plugin;

public class MarListener implements Listener {
	
	private Plugin plugin;
	
	public MarListener(Plugin plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBadEvent(PlayerChatEvent event) {
		String[] message = event.getMessage().toString().split(" ");
		for(String word : message) {
			if(word.toLowerCase().equals("omar")) {
				event.getPlayer().kickPlayer("Can't say that word here bud. Hold the L.");
			}
		}
	}
}

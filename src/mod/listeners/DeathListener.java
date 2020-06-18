package mod.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import mod.Plugin;

public class DeathListener implements Listener {
	
	private Plugin plugin;
	
	public DeathListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		this.plugin.positions.updatePlayerDeathLocation((Player)event.getEntity(), ((Player)event.getEntity()).getLocation());
	}
}

package mod.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import mod.Plugin;

public class TeleportListener implements Listener {
	
	private Plugin plugin;
	
	public TeleportListener(Plugin plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}
	
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		this.plugin.positions.updatePlayerTpLocation(event.getPlayer(), event.getPlayer().getLocation());
	}

}

package mod.commands.position;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Positions {
	
	private HashMap<String, Location> dead = new HashMap<String, Location>();
	private HashMap<String, Location> tp = new HashMap<String, Location>();
	
	public Positions(Player[] players) {
		for(Player player : players) {
			this.dead.put(player.getName().toLowerCase(), null);
			this.tp.put(player.getName().toLowerCase(), null);
		}
	}
	
	public void removePlayer(Player player) {
		this.dead.remove(player.getName().toLowerCase());
		this.tp.remove(player.getName().toLowerCase());
	}
	
	public void addPlayer(Player player) {
		this.dead.put(player.getName().toLowerCase(), null);
		this.tp.put(player.getName().toLowerCase(), null);
	}
	
	public void updatePlayerTpLocation(Player player, Location location) {
		this.tp.replace(player.getName().toLowerCase(), location);
	}
	
	public void updatePlayerDeathLocation(Player player, Location location) {
		this.dead.replace(player.getName().toLowerCase(), location);
	}
	
	public Location getTpLocation(Player player) {
		return this.tp.get(player.getName().toLowerCase());
	}
	
	public Location getDeathLocation(Player player) {
		return this.dead.get(player.getName().toLowerCase());
	}
	
}

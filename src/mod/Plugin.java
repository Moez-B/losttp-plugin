package mod;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import mod.commands.BackCommand;
import mod.commands.DiedCommand;
import mod.commands.HomeCommand;
import mod.commands.LostCommand;
import mod.commands.position.Positions;
import mod.listeners.DeathListener;
import mod.listeners.JoinListener;
import mod.listeners.LeaveListener;
import mod.listeners.MarListener;
import mod.listeners.TeleportListener;

public class Plugin extends JavaPlugin {
	
	public Positions positions;
	
	@Override
	public void onEnable() {
		new JoinListener(this);
		new MarListener(this);
		new LeaveListener(this);
		new TeleportListener(this);
		new DeathListener(this);
		this.getCommand("lost").setExecutor(new LostCommand(this));
		this.getCommand("home").setExecutor(new HomeCommand(this));
		this.getCommand("back").setExecutor(new BackCommand(this));
		this.getCommand("died").setExecutor(new DiedCommand(this));
		this.positions = new Positions((Player[])this.getServer().getOnlinePlayers().toArray());
	}
	
	@Override
	public void onDisable() {
		
	}
	
}

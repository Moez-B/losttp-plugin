package mod;

import org.bukkit.plugin.java.JavaPlugin;

import mod.commands.HomeCommand;
import mod.commands.LostCommand;
import mod.listeners.JoinListener;
import mod.listeners.MarListener;

public class Plugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new JoinListener(this);
		new MarListener(this);
		this.getCommand("lost").setExecutor(new LostCommand(this));
		this.getCommand("home").setExecutor(new HomeCommand(this));
	}
	
	@Override
	public void onDisable() {
		
	}
	
}

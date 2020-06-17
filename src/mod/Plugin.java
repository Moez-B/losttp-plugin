package mod;

import org.bukkit.plugin.java.JavaPlugin;

import mod.commands.HomeCommand;
import mod.commands.LostCommand;

public class Plugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("lost").setExecutor(new LostCommand(this));
		this.getCommand("home").setExecutor(new HomeCommand(this));
	}
}

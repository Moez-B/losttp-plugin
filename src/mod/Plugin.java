package mod;

import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.parser.JSONParser;

import mod.commands.BackCommand;
import mod.commands.BeachHomeCommand;
import mod.commands.DiedCommand;
import mod.commands.HomeCommand;
import mod.commands.LostCommand;
import mod.commands.locationlibrary.AddLocationSaveCommand;
import mod.commands.position.Positions;
import mod.listeners.DeathListener;
import mod.listeners.JoinListener;
import mod.listeners.LeaveListener;
import mod.listeners.MarListener;
import mod.listeners.TeleportListener;

public class Plugin extends JavaPlugin {
	
	public Positions positions;
	
	public JSONParser parser;
	
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
		this.getCommand("bh").setExecutor(new BeachHomeCommand(this));
		this.getCommand("addlocation").setExecutor(new AddLocationSaveCommand(this));

		this.positions = new Positions(this.getServer().getOnlinePlayers());
	}
	
	@Override
	public void onDisable() {}
	
}

package mod.commands.locationlibrary;

import java.io.FileReader;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import mod.Plugin;

public class GoToCommand implements CommandExecutor {
	
	Plugin plugin;
	
	public GoToCommand(Plugin p) {
		this.plugin = p;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		Gson gson = new Gson();
		try {			
			JSONArray locations = (JSONArray)this.plugin.parser.parse(new FileReader(this.plugin.locationSaves));
			for(Object location : locations) {
				NamedLocation nl = gson.fromJson(((JSONObject)location).toJSONString(), NamedLocation.class);
				if(nl.name.equalsIgnoreCase(args[0])) {
					((Player)sender).teleport(new Location(Bukkit.getWorld(nl.worldName), nl.x, nl.y, nl.z));
					((Player)sender).sendMessage("Teleported to " + ChatColor.RED + nl.name + ChatColor.WHITE + "!");
					return true;
				}
			}
			((Player)sender).sendMessage(ChatColor.RED + args[0] + ChatColor.WHITE + " is not a registered location!");
		}
		catch(IOException e) {return false;}
		catch(ParseException e) {return false;}
		
		return false;
	}
}

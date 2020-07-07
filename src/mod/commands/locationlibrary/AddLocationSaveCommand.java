package mod.commands.locationlibrary;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import com.google.gson.GsonBuilder;

import mod.Plugin;

public class AddLocationSaveCommand implements CommandExecutor {
	
	Plugin plugin;
	
	public AddLocationSaveCommand(Plugin p) {
		this.plugin = p;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		JSONArray locations;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try {
			locations = (JSONArray)this.plugin.parser.parse(new FileReader(this.plugin.locationSaves));
			Location cl = ((Player)sender).getLocation();
			
			JSONObject namedLocation = (JSONObject)this.plugin.parser.parse(gson.toJson(new NamedLocation(args[0], cl.getWorld(), cl.getX(), cl.getY(), cl.getZ())));		
			locations.add(namedLocation);
			FileWriter addLocation = new FileWriter(this.plugin.locationSaves);
			
			addLocation.write(locations.toString());
			addLocation.flush();
			addLocation.close();
		}
		catch(ParseException e) {return false;}
		catch(IOException e) {return false;}
		
		Bukkit.getServer().broadcastMessage(
				ChatColor.RED + sender.getName() + ChatColor.WHITE + " just registered a location named " + ChatColor.RED + args[0]
				+ ChatColor.WHITE + "!"
		);
		return true;
	}
	
}

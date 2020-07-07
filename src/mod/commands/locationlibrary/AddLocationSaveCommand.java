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

import mod.Plugin;

public class AddLocationSaveCommand implements CommandExecutor {
	
	Plugin plugin;
	File locationSaves;
	
	public AddLocationSaveCommand(Plugin p) {
		this.plugin = p;
		this.locationSaves = new File("global-location-saves-losttp.json");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		JSONArray locations;
		try {
			locations = (JSONArray)this.plugin.parser.parse(new FileReader(this.locationSaves));
			Location cl = ((Player)sender).getLocation();
			locations.add((JSONObject)this.plugin.parser.parse(new Gson().toJson(
					new NamedLocation(args[0], cl.getWorld(), cl.getX(), cl.getY(), cl.getZ())
					)));
			FileWriter addLocation = new FileWriter(this.locationSaves);
			addLocation.write(locations.toJSONString());
			addLocation.flush();
			addLocation.close();
		}
		catch(ParseException e) {return false;}
		catch(IOException e) {return false;}
		
		Bukkit.getServer().broadcastMessage(
				ChatColor.RED + sender.getName() + ChatColor.WHITE + " just registered a location named " + ChatColor.RED + args[0]
		);
		return true;
	}
	
}

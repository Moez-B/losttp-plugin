package mod.commands.locationlibrary;

import org.bukkit.Location;
import org.bukkit.World;

public class NamedLocation extends Location {

	public String name;
	
	public NamedLocation(String name, World world, double x, double y, double z) {
		super(world, x, y, z);
		this.name = name;
	}
	
	
}

package mod.commands.locationlibrary;

import org.bukkit.World;

public class NamedLocation {

	public String name;
	public String worldName;
	public double x,y,z;
	
	public NamedLocation(String name, World world, double x, double y, double z) {
		this.name = name;
		this.worldName = world.getName();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
}

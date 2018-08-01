import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.UUID;


public class Arena {

	private static ArrayList<Arena> arenas = new ArrayList<>();
	
	UUID id;
	String name;
	Location one, two;
	boolean inuse;
	
	public Arena(UUID id, String name, Location one, Location two,boolean inuse){
		this.id = id;
		this.name = name;
		this.one = one;
		this.two = two;
		this.inuse = inuse;
		arenas.add(this);
	}

	public Arena(String name) {
		  this.id = UUID.randomUUID();
		  this.name = name;
		  this.one = null;
		  this.two = null;
		  this.inuse = false;
		  arenas.add(this);
		}
	
	public static Arena getRandomUnusedArena() {
		for(Arena arena:getArenas()) {
			if(!arena.inuse) {
				return arena;
			}
		}
		return null;
	}
	
	
    private static String locationToString(Location location) {
        return location.getWorld().getName() + " " + (int) location.getX() + " " + (int) location.getY() + " "
                + (int) location.getZ();
    }

    private static Location stringToLocation(String location) {
        String[] string = location.split(" ");
        return new Location(Bukkit.getWorld(string[0]), Integer.valueOf(string[1]), Integer.valueOf(string[2]),
                Integer.valueOf(string[3]));
    }
	
    public static Arena fromName(String name) {
    	for(Arena arena : getArenas()) {
    		if(arena.getName().equalsIgnoreCase(name)) {
    			return arena;
    		}
    	}
    	return null;
    }
    
    public static Arena fromId(UUID id) {
    	for(Arena arena : getArenas()) {
    		if(arena.getId().equals(id)) {
    			return arena;
    		}
    	}
    	return null;
    }
    
	public static ArrayList<Arena> getArenas() {
		return arenas;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getOne() {
		return one;
	}

	public void setOne(Location one) {
		this.one = one;
	}

	public Location getTwo() {
		return two;
	}

	public void setTwo(Location two) {
		this.two = two;
	}

	public boolean isInuse() {
		return inuse;
	}

	public void setInuse(boolean inuse) {
		this.inuse = inuse;
	}
	
}
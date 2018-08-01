import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Duel {

	private static ArrayList<Duel> duels = new ArrayList<>();
	
	UUID id;
	Arena arena;
	Team[] teams;
	
	public Duel(UUID id, Arena arena, Team... teams) {
		this.id = id;
		this.arena = arena;
		this.teams = teams;
		duels.add(this);
	}
	
	public static ArrayList<Duel> getDuels(){
		return duels;
	}
	
	public static Duel fromPlayer(Player p) {
		for(Duel duels : getDuels()) 
			for(Team team : duels.getTeams()) 
				if(Arrays.asList(team.getPlayers()).contains(p)) 
					return duels;
				
		return null;
	}
	
	public void teleportPlayers() {
		int position = 0;
		for(Team team:getTeams()) {
			for(Player p:team.getPlayers()) {
				arena.getOne().getWorld().loadChunk((position == 0 ? arena.getOne() : arena.getTwo()).getChunk());
				p.teleport((position == 0 ? arena.getOne() : arena.getTwo()));
			}
			position++;
		}
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public Team[] getTeams() {
		return teams;
	}
	
	
}
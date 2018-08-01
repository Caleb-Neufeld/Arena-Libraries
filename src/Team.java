import org.bukkit.entity.Player;

public class Team {

    Player[] players;
    
    public Team(Player... players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    
}
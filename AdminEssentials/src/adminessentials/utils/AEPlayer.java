package adminessentials.utils;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.entity.Player;

/**
	 * 
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class AEPlayer {
	
	private static Set<AEPlayer> instances = new HashSet<AEPlayer>();
	
	public static Set<AEPlayer> getInstances() {
		return instances;
	}
	
	private Player player;
	
	private boolean frozen;
	private boolean vanished;
	
	public AEPlayer(Player player) {
		this.player = player;
		instances.add(this);
	}
	
    public static AEPlayer getInstance(Player player) {

        for (AEPlayer users : instances) {

            if (users.getPlayer().getName().equals(player.getName())) {
                return users;
            }

        }
        return new AEPlayer(player);
    }
    
	public Player getPlayer() {
		return player;
	}
	
	public boolean isFrozen() {
		return frozen;
	}
	
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}
	
	public boolean isVanished() {
		return vanished;
	}
	
	public void setVanished(boolean vanished) {
		this.vanished = vanished;
	}
	
}

package adminessentials.utils;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
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
	
	private boolean frozen = false;
	private boolean adminMode = false;
	private boolean staffChat = false;
	
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
	
	public void setStaffChat(boolean staffChat) {
		this.staffChat = staffChat;
	}
	
	public boolean inStaffChat() {
		return staffChat;
	}
	
	public boolean inAdminMode() {
		return adminMode;
	}
	
	public void setAdminMode(boolean adminMode) {
		
		this.adminMode = adminMode;
		
		for (Player online : Bukkit.getOnlinePlayers()) {
			
			if (AEPlayer.getInstance(online).inAdminMode() && this.getPlayer().hasPermission("adminessentials.seeadmins")) continue;
			
			online.hidePlayer(this.getPlayer());
			
		}
		
		Chat.getInstance().messagePlayer(this.getPlayer(), adminMode ? Settings.get().ADMIN_MODE_ENABLED : Settings.get().ADMIN_MODE_DISABLED);
		
	}
	
}

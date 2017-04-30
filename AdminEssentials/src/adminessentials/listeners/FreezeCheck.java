package adminessentials.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import adminessentials.utils.AEPlayer;

/**
	 * 
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class FreezeCheck implements Listener {
	
	// Rather inefficient, maybe check it less often or store players instead of looking them up every tick?
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
		Player player = e.getPlayer();
		AEPlayer aePlayer = AEPlayer.getInstance(player);
		
		if (!aePlayer.isFrozen()) return;
		
		double fromX = e.getFrom().getX();
		double fromY = e.getFrom().getY();
		double fromZ = e.getFrom().getZ();
		
		double toX = e.getTo().getX();
		double toY = e.getTo().getY();
		double toZ = e.getTo().getZ();
		
		if (fromX != toX || fromY != toY || fromZ != toZ) {
			player.teleport(new Location(player.getWorld(), fromX, fromY, fromZ, e.getTo().getYaw(), e.getTo().getPitch()));
		}
		
	}

}

package adminessentials.listeners;

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
		
		int fromX = e.getFrom().getBlockX();
		int fromY = e.getFrom().getBlockY();
		int fromZ = e.getFrom().getBlockZ();
		
		int toX = e.getTo().getBlockX();
		int toY = e.getTo().getBlockY();
		int toZ = e.getTo().getBlockZ();
		
		if (fromX != toX || fromY != toY || fromZ != toZ) {
			e.setCancelled(true);
		}
		
	}

}

package adminessentials.listeners.adminmode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import adminessentials.utils.AEPlayer;

/**
	 * 
	 * Created on Jul 11, 2017 by Jeremy Gooch.
	 * 
	 */

public class AdminBreakBlock implements Listener {
	
	@EventHandler
	public void onBreakBlock(BlockBreakEvent event) {
		
		AEPlayer player = AEPlayer.getInstance(event.getPlayer());
		
		if (!player.inAdminMode()) return;
		
		event.setCancelled(true);
		
	}

}

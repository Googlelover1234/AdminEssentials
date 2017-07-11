package adminessentials.listeners.adminmode;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import adminessentials.utils.AEPlayer;

/**
	 * 
	 * Created on Jul 11, 2017 by Jeremy Gooch.
	 * 
	 */

public class AdminDamageEntity implements Listener {
	
	@EventHandler
	public void onDamageEntity(EntityDamageByEntityEvent event) {
		
		if (!(event.getDamager() instanceof Player)) return;
		
		AEPlayer player = AEPlayer.getInstance((Player) event.getDamager());
		
		if (!player.inAdminMode()) return;
		
		event.setCancelled(true);
		
	}

}

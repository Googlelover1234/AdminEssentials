package adminessentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import adminessentials.main.AdminEssentials;
import adminessentials.utils.Chat;
import adminessentials.utils.Updater.UpdateAvailability;

/**
	 * 
	 * Created on Jul 12, 2017 by Jeremy Gooch.
	 * 
	 */

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if (!player.isOp()) return;
		
		if (AdminEssentials.get().getUpdateChecker().checkForUpdates() != UpdateAvailability.UPDATE_AVAILABLE) return;
		
		Chat.getInstance().messagePlayer(player, "&aAdminEssentials &6[" + AdminEssentials.get().getDescription().getVersion() + "] &bis out of date! "
				+ "Version &6" + AdminEssentials.get().getUpdateChecker().getLatest() + " &bcan be found here: &ahttps://dev.bukkit.org/projects/adminessentials/files");
		
	}

}

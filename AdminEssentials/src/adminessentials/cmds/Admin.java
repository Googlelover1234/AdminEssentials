package adminessentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import adminessentials.utils.AEPlayer;
import adminessentials.utils.Chat;
import adminessentials.utils.Settings;
import adminessentials.utils.command.Command;
import adminessentials.utils.command.CommandArgs;

/**
	 * 
	 * Created on Jul 11, 2017 by Jeremy Gooch.
	 * 
	 */

public class Admin {
	
	@Command(name = "admin", usage = "/admin", description = "Puts the user into admin mode, keeping them hidden from users but visible to other staff members.", permission = "adminessentials.admin", inGameOnly = true)
	public void adminCommandExecute(CommandArgs args) {
		
		Player player = args.getPlayer();
		
		if (args.length() == 0) {
			
			AEPlayer aePlayer = AEPlayer.getInstance(player);
			
			aePlayer.setAdminMode(!aePlayer.inAdminMode()); // sets to the opposite state
			
		}
		
		if (args.length() == 1) {
			
			Player target = Bukkit.getPlayer(args.getArgs(0));
			
			if (target == null) {
				
				Chat.getInstance().messagePlayer(player, "&cPlayer '" + args.getArgs(0) + "' is not online");
				
				return;
			}
			
			AEPlayer aeTarget = AEPlayer.getInstance(target);
			
			aeTarget.setAdminMode(!aeTarget.inAdminMode());
			
			if (aeTarget.inAdminMode()) {
				
				Chat.getInstance().messagePlayer(player, Settings.get().ADMIN_MODE_ENABLE_OTHERS.replace("%player%", target.getName()));
				
			} else Chat.getInstance().messagePlayer(player, Settings.get().ADMIN_MODE_DISABLE_OTHERS.replace("%player%", target.getName()));
			
		}
		
	}

}

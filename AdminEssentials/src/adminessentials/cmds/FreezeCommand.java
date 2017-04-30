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
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class FreezeCommand {
	
	@Command(name = "freeze", description = "Freezes a player in their current location.", usage = "/freeze <player> (reason)", permission = "adminessentials.freeze")
	public void freezeCommand(CommandArgs args) {
		
		if (args.length() < 1) {
			
			Chat.getInstance().messagePlayer(args.getSender(), "&cUsage: /" + args.getLabel() + " <player> (reason)");
			
			return;
		}
		
		String queriedPlayerName = args.getArgs(0);
		
		Player queriedPlayer = Bukkit.getPlayer(queriedPlayerName);
		
		if (queriedPlayer == null) {
			
			
			return;
		}
		
		AEPlayer player = AEPlayer.getInstance(queriedPlayer);
		
		player.setFrozen(!player.isFrozen()); // sets them to the opposite state
		
		if (player.isFrozen()) {
			
			Chat.getInstance().messagePlayer(queriedPlayer, Settings.PLAYER_FROZEN);
			Chat.getInstance().messagePlayer(args.getSender(), Settings.ADMIN_FREEZE);
			
		} else {
			
			Chat.getInstance().messagePlayer(queriedPlayer, Settings.PLAYER_UNFROZEN);
			Chat.getInstance().messagePlayer(args.getSender(), Settings.ADMIN_UNFREEZE);
			
		}
		
	}

}

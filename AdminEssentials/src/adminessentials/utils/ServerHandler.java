package adminessentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

/**
	 * 
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class ServerHandler {
	
	private Server server;
	private boolean chatMuted;
	
	public ServerHandler(Server server) {
		
		this.server = server;
		chatMuted = false;
		
	}
	
	public Server getServer() {
		return server;
	}
	
	public boolean isChatMuted() {
		return chatMuted;
	}
	
	public void setChatMuted(boolean mute) {
		chatMuted = mute;
	}
	
	public void clearChat() {

		for (Player on : Bukkit.getOnlinePlayers()) {

			if (on.hasPermission("adminessentials.clearchat.bypass")) continue;

			for (int i = 0; i < 120; i++) {

				on.sendMessage("     ");

			}

		}

		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Settings.CHAT_CLEARED));
	}

}

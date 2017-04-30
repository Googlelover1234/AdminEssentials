package adminessentials.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
	 * 
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class Chat {
	
	private Chat() { }
	
	private static Chat instance = new Chat();
	
	public static Chat getInstance() {
		
		return instance;
		
	}
	
	public static final String CHAT_PREFIX = "&8» ";
	
	public static final ChatColor BASE_COLOR = ChatColor.GRAY, IMPORTANT_COLOR = ChatColor.RED, DEBUG = ChatColor.DARK_RED, SECONDARY_BASE = ChatColor.GREEN, STAFF_NOTIFICATION = ChatColor.YELLOW;
	
	public void messagePlayer(CommandSender sender, String message) {
		
		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', CHAT_PREFIX + BASE_COLOR + message));
		
	}
	
	public void broadcastMessage(String message) {
		
		for (Player online : Bukkit.getOnlinePlayers()) {
			
			online.sendMessage(ChatColor.translateAlternateColorCodes('&', CHAT_PREFIX + BASE_COLOR + message));
			
		}
		
	}
	
}

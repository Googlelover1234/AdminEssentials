package adminessentials.utils;

import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.YamlConfiguration;

import adminessentials.main.AdminEssentials;

/**
	 * 
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class Settings {
	
	public static String SERVER_NAME;
	public static String MESSAGE_PREFIX;
	
	public static String PLAYER_FROZEN;
	public static String PLAYER_UNFROZEN;
	public static String ADMIN_FREEZE;
	public static String ADMIN_UNFREEZE;

	public static String CHAT_CLEARED;
	public static String CHAT_CURRENTLY_MUTED;
	
	public static void initSettings() {
		
		SERVER_NAME = initSetting("settings.server_name");
		MESSAGE_PREFIX = initSetting("settings.message_prefix");
		
		PLAYER_FROZEN = initSetting("messages.player_frozen");
		PLAYER_UNFROZEN = initSetting("messages.player_unfrozen");
		ADMIN_FREEZE = initSetting("messages.admin_freeze");
		ADMIN_UNFREEZE = initSetting("messages.admin_unfreeze");
		CHAT_CLEARED = initSetting("messages.chat_cleared");
		CHAT_CURRENTLY_MUTED = initSetting("messages.chat_currently_muted");

	}
	
	@SuppressWarnings("deprecation")
	private static String initSetting(String path) {
		
		if (!AdminEssentials.get().getConfigurationFile().contains(path)) { // check the config file directly from the jar in case there were any updates
			
			InputStream tempStream = AdminEssentials.get().getResource("config.yml");
			
			YamlConfiguration tempConfig = YamlConfiguration.loadConfiguration(tempStream);
			
			if (!tempConfig.contains(path)) {
				throw new NullPointerException("Could not find the path specified");
			}
			
			AdminEssentials.get().getConfigurationFile().set(path, tempConfig.get(path));
			
			initSetting(path);
			
			try {
				tempStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return AdminEssentials.get().getConfigurationFile().getString(path);
		
	}

}

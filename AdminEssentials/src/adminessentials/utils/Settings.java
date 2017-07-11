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
	
	private Settings() { }
	
	private static Settings instance = new Settings();
	
	public static Settings get() {
		return instance;
	}
	
	public String MESSAGE_PREFIX;
	
	public String PLAYER_FROZEN;
	public String PLAYER_UNFROZEN;
	public String ADMIN_FREEZE;
	public String ADMIN_UNFREEZE;

	public String CHAT_CLEARED;
	public String CHAT_CURRENTLY_MUTED;
	
	public String CHAT_MUTE_ENABLED;
	public String CHAT_MUTE_DISABLED;
	
	public String ADMIN_MODE_ENABLED;
	public String ADMIN_MODE_DISABLED;
	
	public String ADMIN_MODE_ENABLE_OTHERS;
	public String ADMIN_MODE_DISABLE_OTHERS;
	
	public void initSettings() {
		
		MESSAGE_PREFIX = initSetting("settings.message_prefix");
		
		PLAYER_FROZEN = initMessageString("messages.player_frozen");
		PLAYER_UNFROZEN = initMessageString("messages.player_unfrozen");
		ADMIN_FREEZE = initMessageString("messages.admin_freeze");
		ADMIN_UNFREEZE = initMessageString("messages.admin_unfreeze");
		CHAT_CLEARED = initMessageString("messages.chat_cleared");
		CHAT_CURRENTLY_MUTED = initMessageString("messages.chat_currently_muted");
		
		CHAT_MUTE_ENABLED = initMessageString("messages.chat_mute_enabled");
		CHAT_MUTE_DISABLED = initMessageString("messages.chat_mute_disabled");
		
		ADMIN_MODE_ENABLED = initMessageString("messages.admin_mode_enabled");
		ADMIN_MODE_DISABLED = initMessageString("messages.admin_mode_disabled");
		
		ADMIN_MODE_ENABLE_OTHERS = initMessageString("messages.admin_mode_enable_others");
		ADMIN_MODE_DISABLE_OTHERS = initMessageString("messages.admin_mode_disable_others");
		
	}
	
	private String initMessageString(String path) {
		
		return initSetting(path).replace("%message_prefix%", MESSAGE_PREFIX);
		
	}
	
	@SuppressWarnings("deprecation")
	private String initSetting(String path) {
		
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

package adminessentials.utils;

import adminessentials.main.AdminEssentials;

/**
	 * 
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class Settings {
	
	public static String SERVER_NAME;
	
	public static void initSettings() {
		
		SERVER_NAME = AdminEssentials.get().getConfigurationFile().getString("settings.server_name");
		
	}

}

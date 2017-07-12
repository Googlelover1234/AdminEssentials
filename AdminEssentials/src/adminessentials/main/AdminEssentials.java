package adminessentials.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import adminessentials.cmds.Admin;
import adminessentials.cmds.ClearChatCommand;
import adminessentials.cmds.FreezeCommand;
import adminessentials.cmds.MuteChatCommand;
import adminessentials.listeners.AsyncPlayerChat;
import adminessentials.listeners.FreezeCheck;
import adminessentials.listeners.PlayerJoin;
import adminessentials.listeners.adminmode.AdminBreakBlock;
import adminessentials.listeners.adminmode.AdminDamageEntity;
import adminessentials.listeners.adminmode.AdminPickupItem;
import adminessentials.utils.ConfigManager;
import adminessentials.utils.ServerHandler;
import adminessentials.utils.Settings;
import adminessentials.utils.Updater;
import adminessentials.utils.Updater.UpdateAvailability;
import adminessentials.utils.command.CommandFramework;

/**
	 * 
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class AdminEssentials extends JavaPlugin {
	
	private static AdminEssentials instance;
	
	private CommandFramework framework;
	
	private ConfigManager config;
	
	private ServerHandler serverHandler;
	
	private Updater updater;
	
	public void onEnable() {
		
		instance = this;
		framework = new CommandFramework(this);
		serverHandler = new ServerHandler(getServer());
		
		config = new ConfigManager("config", null);
		
		Settings.get().initSettings();
		
		framework.registerCommands(new FreezeCommand());
		framework.registerCommands(new ClearChatCommand());
		framework.registerCommands(new MuteChatCommand());
		framework.registerCommands(new Admin());
		
		registerPluginEvents(new FreezeCheck());
		registerPluginEvents(new AsyncPlayerChat());
		registerPluginEvents(new AdminPickupItem());
		registerPluginEvents(new AdminBreakBlock());
		registerPluginEvents(new AdminDamageEntity());
		registerPluginEvents(new PlayerJoin());
		
		this.updater = new Updater(this, 85492); // DevBukkit project ID
		
		if (updater.checkForUpdates() == UpdateAvailability.UPDATE_AVAILABLE) {
			
			Bukkit.getLogger().warning("AdminEssentials [" + this.getDescription().getVersion() + "] is out of date! Version " + updater.getLatest() + " can be found here: " + "https://dev.bukkit.org/projects/adminessentials/files");
			
		}
		
	}
	
	public void onDisable() {
		
		instance = null;
		framework = null;
		
	}
	
	private void registerPluginEvents(Listener listener) {
		getServer().getPluginManager().registerEvents(listener, this);
	}
	
	public static AdminEssentials get() {
		return instance;
	}
	
	public CommandFramework getCommandFramework() {
		return framework;
	}
	
	public ConfigManager getConfigurationFile() {
		return config;
	}
	
	public ServerHandler getServerHandler() {
		return serverHandler;
	}
	
	public Updater getUpdateChecker() {
		return updater;
	}
	
}

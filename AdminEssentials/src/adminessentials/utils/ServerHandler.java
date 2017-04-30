package adminessentials.utils;

import org.bukkit.Server;

/**
	 * 
	 * Created on Apr 29, 2017 by Jeremy Gooch.
	 * 
	 */

public class ServerHandler {
	
	private Server server;
	
	public ServerHandler(Server server) {
		
		this.server = server;
		
	}
	
	public Server getServer() {
		return server;
	}
	
	private boolean chatMuted;
	
	public boolean isChatMuted() {
		return chatMuted;
	}
	
	public void setChatMuted(boolean mute) {
		chatMuted = mute;
	}
	
	public void clearChat() {
		
		
	}

}

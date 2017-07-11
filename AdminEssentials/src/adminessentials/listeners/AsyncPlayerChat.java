package adminessentials.listeners;

import adminessentials.main.AdminEssentials;
import adminessentials.utils.Chat;
import adminessentials.utils.Settings;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Karandeep on 2017-04-30.
 */
public class AsyncPlayerChat implements Listener {

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {

        if (!AdminEssentials.get().getServerHandler().isChatMuted()) {
        	
        	if (event.getPlayer().hasPermission("adminessentials.mutechat.bypass")) return;
        	
            event.setCancelled(true);
            Chat.getInstance().messagePlayer(event.getPlayer(), Settings.get().CHAT_CURRENTLY_MUTED);
        	
        }
    }
}

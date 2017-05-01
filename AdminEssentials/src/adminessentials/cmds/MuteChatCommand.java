package adminessentials.cmds;

import adminessentials.main.AdminEssentials;
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

public class MuteChatCommand {

    @Command(name = "mutechat", description = "disable or enable the server chat", usage = "/mutechat", permission = "adminessentials.mutechat")
    public void freezeCommand(CommandArgs args) {

        AdminEssentials.get().getServerHandler().setChatMuted(!AdminEssentials.get().getServerHandler().isChatMuted());

        // do the broadcasts
    }

}

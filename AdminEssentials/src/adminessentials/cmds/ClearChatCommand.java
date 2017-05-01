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

public class ClearChatCommand {

    @Command(name = "clearchat", description = "clears the entire server chat.", usage = "/clearchat", permission = "adminessentials.clearchat")
    public void freezeCommand(CommandArgs args) {

        AdminEssentials.get().getServerHandler().clearChat();

    }

}

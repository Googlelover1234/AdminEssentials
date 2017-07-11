package adminessentials.cmds;

import adminessentials.main.AdminEssentials;
import adminessentials.utils.command.Command;
import adminessentials.utils.command.CommandArgs;

/**
 *
 * Created on Apr 29, 2017 by Jeremy Gooch.
 *
 */

public class ClearChatCommand {

    @Command(name = "clearchat", aliases = { "cc", "chatclear" }, description = "clears the entire server chat.", usage = "/clearchat", permission = "adminessentials.clearchat")
    public void freezeCommand(CommandArgs args) {
    	
        AdminEssentials.get().getServerHandler().clearChat(args.getSender().getName());
        
    }

}

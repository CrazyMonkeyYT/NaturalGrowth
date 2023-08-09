package thephilosophicat.tv.twitch.NatruralGrowth;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;


public class DoPlaceDespawn implements CommandExecutor {
	NaturalGrowthMain mainInstance = NaturalGrowthMain.getPlugin(NaturalGrowthMain.class);

	FileConfiguration config = mainInstance.getConfig();
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//debug Bukkit.broadcastMessage(Integer.toString((args.length)));

    	if(args.length == 0) {
    		  sender.sendMessage("doPlaceDespawn " + config.getString("doPlaceDespawn"));
    	}else if(args.length == 1) {
    		if(args[0].equalsIgnoreCase("true")) {
    			config.set("doPlaceDespawn", true);
    			mainInstance.saveConfig();
      		  	sender.sendMessage("DoPlaceDespawn true");
    		}else if (args[0].equalsIgnoreCase("false")) {
    			config.set("doPlaceDespawn", false);
    			mainInstance.saveConfig();
      		  	sender.sendMessage("doPlaceDespawn false");
    		}else {
    			sender.sendMessage(ChatColor.RED +"invalid format must be \"/doPlaceDespawn [true/false]\"");
    		}
    	}else {
			sender.sendMessage(ChatColor.RED + "invalid format must be \"/doPlaceDespawn [true/false]\"");
    	}
    	return true;
    }

   
    
}


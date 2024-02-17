package thephilosophicat.tv.twitch.NatruralGrowth;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;


public class DoPlaceCrops implements CommandExecutor {
	NaturalGrowthMain mainInstance = NaturalGrowthMain.getPlugin(NaturalGrowthMain.class);

	FileConfiguration config = mainInstance.getConfig();
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//debug Bukkit.broadcastMessage(Integer.toString((args.length)));

    	if(args.length == 0) {
    		  sender.sendMessage("doPlaceCrops " + config.getString("doPlaceCrops"));
    	}else if(args.length == 1) {
    		if(args[0].equalsIgnoreCase("true")) {
    			config.set("doPlaceCrops", true);
    			mainInstance.saveConfig();
      		  	sender.sendMessage("DoPlaceCrops true");
    		}else if (args[0].equalsIgnoreCase("false")) {
    			config.set("doPlaceCrops", false);
    			mainInstance.saveConfig();
      		  	sender.sendMessage("doPlaceCrops false");
    		}else {
    			sender.sendMessage(ChatColor.RED +"invalid format must be \"/doPlaceCrops [true/false]\"");
    		}
    	}else {
			sender.sendMessage(ChatColor.RED + "invalid format must be \"/doPlaceCrops [true/false]\"");
    	}
    	return true;
    }

   
    
}


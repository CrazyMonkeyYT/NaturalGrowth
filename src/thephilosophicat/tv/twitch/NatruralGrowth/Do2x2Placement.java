package thephilosophicat.tv.twitch.NatruralGrowth;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;


public class Do2x2Placement implements CommandExecutor {
	NaturalGrowthMain mainInstance = NaturalGrowthMain.getPlugin(NaturalGrowthMain.class);

	FileConfiguration config = mainInstance.getConfig();
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	//debug	Bukkit.broadcastMessage(Integer.toString((args.length)));
    	if(args.length == 0) {
    		  sender.sendMessage("Do2x2Placement " + config.getString("do2x2Placement"));
    	}else if(args.length == 1) {
    		if(args[0].equalsIgnoreCase("true")) {
    			config.set("do2x2Placement", true);
    			mainInstance.saveConfig();
      		  	sender.sendMessage("Do2x2Placement true");
    		}else if (args[0].equalsIgnoreCase("false")) {
    			config.set("do2x2Placement", false);
    			mainInstance.saveConfig();
      		  	sender.sendMessage("Do2x2Placement false");
    		}else {
    			sender.sendMessage(ChatColor.RED +"invalid format must be \"/Do2x2Placement [true/false]\"");
    		}
    	}else {
			sender.sendMessage(ChatColor.RED + "invalid format must be \"/Do2x2Placement [true/false]\"");
    	}
    	return true;
    }
    
    
}
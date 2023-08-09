package thephilosophicat.tv.twitch.NatruralGrowth;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;



public class NaturalGrowthMain extends JavaPlugin {
	public FileConfiguration config = getConfig();

  // Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	// registers commands 
        this.getCommand("doPlaceDespawn").setExecutor(new DoPlaceDespawn());
        this.getCommand("do2x2Placement").setExecutor(new Do2x2Placement());
        this.getCommand("doPlaceDespawn").setTabCompleter(new TabCompleation());
        this.getCommand("do2x2Placement").setTabCompleter(new TabCompleation());

    	//sets the default config file
    	String[] itemDrops ={"sapling", "fungus", "mushroom","propagule","flower","allium","bluet","orchid","dandelion","lilacs","lily","daisy","peony","poppy","rose","tulips"};
    	List<String> itemDespawnList = sArrayToList(itemDrops);
    	String[] item2x2  = {"spruce", "dark_oak", "jungle"};
    	List<String> placeItem2x2 = sArrayToList(item2x2);
    	config.addDefault("doPlaceDespawn", true);
    	config.addDefault("itemDespawnList", itemDespawnList);
    	config.addDefault("do2x2Placement", true);
    	config.addDefault("item2x2List", placeItem2x2);
 
    	config.options().copyDefaults(true);
        saveConfig();
        // registers sapling listener
    	getServer().getPluginManager().registerEvents(new SapplingListener(),this);
    	


    }
//    public static NaturalGrowthMain getInstance(){
//        return instance;
//    }
    public List<String> sArrayToList(String[] sArray){
    	List<String> sList =new ArrayList<String>();
    	for(String i : sArray) {
    		sList.add(i);
    		} 
    	return sList;
    }

    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    }
}
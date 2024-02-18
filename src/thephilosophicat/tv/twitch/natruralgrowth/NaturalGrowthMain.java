package thephilosophicat.tv.twitch.NatruralGrowth;
/*
 * Author ThePhilosophiCat
 * 
 * main class for NaturalGrowth 
 *
 * NaturalGrowth causes dropped plants to plant themselves on the ground instead of despawning.
 * This plugin works with all saplings including large trees, flowers, crops, fungi and mushrooms.
 * 
 * registers natural growth as a plugin and links all corresponding class files
 * 
 */


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
        this.getCommand("doPlaceCrops").setExecutor(new DoPlaceCrops());
        this.getCommand("do2x2Placement").setExecutor(new Do2x2Placement());
        this.getCommand("doPlaceDespawn").setTabCompleter(new TabCompleation());
        this.getCommand("doPlaceCrops").setTabCompleter(new TabCompleation());
        this.getCommand("do2x2Placement").setTabCompleter(new TabCompleation());

    	//sets the default config file
    	String[] itemDrops ={"ACACIA_SAPLING","BIRCH_SAPLING","CHERRY_SAPLING","DARK_OAK_SAPLING","OAK_SAPLING","SPRUCE_SAPLING",
    			"BAMBOO","BROWN_MUSHROOM","RED_MUSHROOM","CACTUS","ALLIUM","AZALEA_BUSH","AZURE_BLUET","BLUE_ORCHID","CORNFLOWER",
    			"CRIMSON_FUNGUS","CRIMSON_ROOTS","DANDELION","DEAD_BUSH","FERN","FLOWERING_AZALEA_BUSH","JUNGLE_SAPLING",
    			"LILY_OF_THE_VALLEY","MANGROVE_PROPAGULE","ORANGE_TULIP","OXEYE_DAISY","PINK_TULIP","PITCHER_PLANT","POPPY","RED_TULIP","TORCHFLOWER",
    			"WARPED_FUNGUS","WARPED_ROOTS","WHITE_TULIP","WITHER_ROSE"};
    	List<String> itemDespawnList = sArrayToList(itemDrops);
    	String[] crops = {"POTATO:POTATOES","WHEAT_SEEDS:WHEAT","BEETROOT_SEEDS:BEETROOTS","MELON_SEEDS:MELON_STEM",
    			"PUMPKIN_SEEDS:PUMPKIN_STEM","TORCHFLOWER_SEEDS:TORCHFLOWER_CROP","PITCHER_POD:PITCHER_CROP", "CARROT:CARROTS"};
    	List<String> cropDespawnList = sArrayToList(crops);
    	String[] item2x2  = {"spruce", "dark_oak", "jungle"};
    	List<String> placeItem2x2 = sArrayToList(item2x2);
    	config.addDefault("doPlaceDespawn", true);
    	config.addDefault("itemDespawnList", itemDespawnList);
    	config.addDefault("doPlaceCrops", true);
    	config.addDefault("cropDespawnList", cropDespawnList);
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
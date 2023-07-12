package thephilosophicat.tv.twitch.NatruralGrowth;

import org.bukkit.plugin.java.JavaPlugin;

public class NaturalGrowthMain extends JavaPlugin {
    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	getServer().getPluginManager().registerEvents(new SapplingListener(),this);
    }
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    }
}

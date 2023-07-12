package thephilosophicat.tv.twitch.NatruralGrowth;
/*
listens for item despawn events
if sapling places sapling if in an appropriate  location

*/
import org.bukkit.Bukkit;
//import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
  
public class SapplingListener implements Listener {
	
	@EventHandler
	public void onSaplingDespawn(ItemDespawnEvent event) {
		//Determines if despawning entity is a sapling 
		//Bukkit.broadcastMessage(event.getEntity().getItemStack().getType().getKey().getKey());
		if (event.getEntity().getItemStack().getType().getKey().getKey().contains("sapling")){
			//(to be added random chance per each sapling )int stackSize = event.getEntity().getItemStack().getAmount();
			//check if sapling can be placed 
			
			if (event.getLocation().getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType()))) {
				//place sapling
				//Bukkit.broadcastMessage("setblock");
				event.getLocation().getBlock().setType(event.getEntity().getItemStack().getType());
			}
		}
	}
}

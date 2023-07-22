package thephilosophicat.tv.twitch.NatruralGrowth;
/*
listens for item despawn events
if sapling places sapling if in an appropriate  location

*/
import org.bukkit.Bukkit;
import org.bukkit.Location;
//import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
  
public class SapplingListener implements Listener {
	String[] itemDrops = {"sapling", "fungus", "mushroom","propagule","flower","allium","bluet","orchid","dandelion","lilacs","lily","daisy","peony","poppy","rose","tulips"};
	String[] items2x2 = {"spruce", "dark_oak", "jungle"};
	@EventHandler
	public void onSaplingDespawn(ItemDespawnEvent event) {
		//Determines if despawning entity is a plant 
		//debug Bukkit.broadcastMessage(event.getEntity().getItemStack().getType().getKey().getKey());
		String entityType = event.getEntity().getItemStack().getType().getKey().getKey();
		for( String item : itemDrops) {
			placeItem:
			if (entityType.contains(item)){
				//(to-do add random chance per each sapling )int stackSize = event.getEntity().getItemStack().getAmount();
				//check if sapling can be placed 
				if (event.getLocation().getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType()))) {
					//place sapling
					event.getLocation().getBlock().setType(event.getEntity().getItemStack().getType());
					//check for placing 2x2
					for( String i2x2 : items2x2) {
						//if there are enough in a stack, and if it is an allowed item
						if (entityType.contains(i2x2) && (event.getEntity().getItemStack().getAmount() >= 4)){
							//checks if blocks can accommodate a 2x2 placement 
							Location location = new Location(centerLocation(event.getLocation()).getWorld(), centerLocation(event.getLocation()).getX(), centerLocation(event.getLocation()).getY(), centerLocation(event.getLocation()).getZ());
							Location location1 = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ()+1);
							Location location2 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ()+1);
							Location location3 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ());
							//debug Bukkit.broadcastMessage(location1.toString()+  location2.toString()+ location3.toString());
							if (location1.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType())) && location1.getBlock().isEmpty()) {
								
								if (location2.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType())) &&
										location3.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType()))&& location2.getBlock().isEmpty()&& location3.getBlock().isEmpty()){
									location1.getBlock().setType(event.getEntity().getItemStack().getType());
									location2.getBlock().setType(event.getEntity().getItemStack().getType());
									location3.getBlock().setType(event.getEntity().getItemStack().getType());
									//debug Bukkit.broadcastMessage(String.valueOf(location1.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType()))));
									break placeItem;
								}else {
									location2 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ()+1);
									location3 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ());
									if (location2.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType())) &&
											location3.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType()))&& location2.getBlock().isEmpty()&& location3.getBlock().isEmpty()){
										location1.getBlock().setType(event.getEntity().getItemStack().getType());
										location2.getBlock().setType(event.getEntity().getItemStack().getType());
										location3.getBlock().setType(event.getEntity().getItemStack().getType());
										//debug Bukkit.broadcastMessage("pass 2");
										break placeItem;
									}
								}
							}else {
								location1 = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ()-1);
								location2 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ()-1);
								location3 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ());
								if (location1.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType())) && location2.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType())) &&
										location3.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType()))&& location1.getBlock().isEmpty()&& location2.getBlock().isEmpty()&& location3.getBlock().isEmpty()) {
									location1.getBlock().setType(event.getEntity().getItemStack().getType());
									location2.getBlock().setType(event.getEntity().getItemStack().getType());
									location3.getBlock().setType(event.getEntity().getItemStack().getType());
									//debug Bukkit.broadcastMessage("pass 3");
									break placeItem;
								}else {
									location2 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ()-1);
									location3 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ());
									if (location1.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType())) && location2.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType())) &&
											location3.getBlock().canPlace(Bukkit.createBlockData(event.getEntity().getItemStack().getType()))&& location1.getBlock().isEmpty()&& location2.getBlock().isEmpty()&& location3.getBlock().isEmpty()) {
										location1.getBlock().setType(event.getEntity().getItemStack().getType());
										location2.getBlock().setType(event.getEntity().getItemStack().getType());
										location3.getBlock().setType(event.getEntity().getItemStack().getType());
										//debug Bukkit.broadcastMessage("pass 4");
										break placeItem;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	private Location centerLocation(Location location) {
			location.setX(location.getBlockX());
			location.setZ(location.getBlockZ());
		return(location);
	}
}

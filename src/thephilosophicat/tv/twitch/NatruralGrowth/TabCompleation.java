package thephilosophicat.tv.twitch.NatruralGrowth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

//Make sure your class implements TabCompleter.
public class TabCompleation implements TabCompleter {
 public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
     List<String> list = new ArrayList<>();
     // Now, it's just like any other command.
     // Check if the sender is a player.
     if (sender instanceof Player) {
         // Check if the command is "something."
         if (cmd.getName().equalsIgnoreCase("doPlaceDespawn") || cmd.getName().equalsIgnoreCase("do2x2Placement") || cmd.getName().equalsIgnoreCase("doPlaceCrops")) {
             // If the player has not typed anything in
             if (args.length == 0) {
                 // Add a list of words that you'd like to show up
                 // when the player presses tab.
                 list.add("true");
                 list.add("false");
                 // Sort them alphabetically.
                 Collections.sort(list);
                 // return the list.
                 return list;
             // If player has typed one word in.
             // This > "/command hello " does not count as one
             // argument because of the space after the hello.
             } else if (args.length == 1) {
                 list.add("false");
                 list.add("true");
                 for (String s : list){
                     // Since the player has already typed something in,
                     // we ant to complete the word for them so we check startsWith().
                     if (!s.toLowerCase().startsWith(args[0].toLowerCase())){
                         list.remove(s);
                     }
                 }
                 Collections.sort(list);
                 return list;
             }
         }
     }
     // return null at the end.
     return null;
 }
}
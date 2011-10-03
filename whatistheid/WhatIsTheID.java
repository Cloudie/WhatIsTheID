
package whatistheid;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class WhatIsTheID extends JavaPlugin{
    
    private PluginDescriptionFile plugin;

    @Override
    public void onDisable() {
        plugin = getDescription();
        System.out.println("["+ plugin.getName() + "] has been disabled!");
    }

    @Override
    public void onEnable() {
        plugin = getDescription();
        System.out.println("["+ plugin.getName() + "] has been enabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        
        if(label.equalsIgnoreCase("id")){
            if(player instanceof Player){
                player.sendMessage("test");
                int id =  player.getItemInHand().getTypeId();
                Material mat = player.getItemInHand().getType();
                player.sendMessage(ChatColor.RED + "[Item ID] Item ID is " + id + 
                        " and it is " + mat + ".");
                return true;
            }
            else{
                System.out.println("You must be a player to do this!");
                return false;
            }
        }
        
        return false;
    }
    
    
}

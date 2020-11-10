package me.illuminatiproductions.youtubeplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GUIMoveItem implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        //Check to see if its the GUI menu
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Custom GUI")){
            Player player = (Player) e.getWhoClicked();
            //Determine what they selected and what to do
            switch(e.getCurrentItem().getType()){
                case TNT:
                    player.closeInventory();
                    player.setHealth(0.0);
                    player.sendMessage("You just killed yourself");
                    break;
                case BREAD:
                    player.closeInventory();
                    player.setFoodLevel(20);
                    player.sendMessage("YUM!");
                    break;
                case DIAMOND_SWORD:
                    player.closeInventory();
                    player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    player.sendMessage("Don't slice yourself");
                    break;
            }


            e.setCancelled(true); //So they cant take the items
        }

    }

}
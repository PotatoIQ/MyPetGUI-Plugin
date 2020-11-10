package com.tatomc.mypetgui.events;

import com.tatomc.mypetgui.MyPetGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class ClickEvent implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Plugin plugin = MyPetGUI.getPlugin(MyPetGUI.class);
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_menu_title")))){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.CHEST)){
                p.closeInventory();
                p.performCommand("petinventory");
            }else if (e.getCurrentItem().getType().equals(Material.BEACON)){
                p.closeInventory();
                p.performCommand("petbeacon");
            }else if (e.getCurrentItem().getType().equals(Material.SAPLING)){
                p.closeInventory();
                p.performCommand("petchooseskilltree");
            }else if (e.getCurrentItem().getType().equals(Material.SADDLE)){
                p.closeInventory();
                p.performCommand("petcall");
            }else if (e.getCurrentItem().getType().equals(Material.LEASH)){
                p.closeInventory();
                p.performCommand("petsendaway");
            }else if (e.getCurrentItem().getType().equals(Material.BED)){
                p.closeInventory();
                p.performCommand("petstore");
            }else if (e.getCurrentItem().getType().equals(Material.MONSTER_EGG)){
                p.closeInventory();
                p.performCommand("petswitch");
            }else if (e.getCurrentItem().getType().equals(Material.HOPPER)){
                p.closeInventory();
                p.performCommand("petpickup");
            }else if (e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)){
                p.closeInventory();
                p.performCommand("petbmenu");
            }else if (e.getCurrentItem().getType().equals(Material.BOOK_AND_QUILL)){
                p.closeInventory();
                p.performCommand("petinfo");
            }else if (e.getCurrentItem().getType().equals(Material.PAPER)){
                p.closeInventory();
                p.performCommand("petskill");
            }else if (e.getCurrentItem().getType().equals(Material.STORAGE_MINECART)){
                p.closeInventory();
                p.performCommand("petshop");
            }else if (e.getCurrentItem().getType().equals(Material.NAME_TAG)){
                p.closeInventory();
                p.performCommand("petname");
            }else if (e.getCurrentItem().getType().equals(Material.GOLD_NUGGET)){
                p.closeInventory();
                p.performCommand("pettrade");
            }else if (e.getCurrentItem().getType().equals(Material.TNT)){
                p.closeInventory();
                p.performCommand("petrelease");
            }
        }else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behvaior_menu_title")))){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.ARMOR_STAND)){
                p.closeInventory();
                p.performCommand("petbehavior Friendly");
            }else if (e.getCurrentItem().getType().equals(Material.BONE)){
                p.closeInventory();
                p.performCommand("petbehavior Normal");
            }else if (e.getCurrentItem().getType().equals(Material.LEASH)){
                p.closeInventory();
                p.performCommand("petbehavior Raid");
            }else if (e.getCurrentItem().getType().equals(Material.DIAMOND_AXE)){
                p.closeInventory();
                p.performCommand("petbehavior Duel");
            }else if (e.getCurrentItem().getType().equals(Material.BOW)){
                p.closeInventory();
                p.performCommand("petbehavior Farm");
            }else if (e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)){
                p.closeInventory();
                p.performCommand("petbehavior Aggressive");
            }
        }
    }
}
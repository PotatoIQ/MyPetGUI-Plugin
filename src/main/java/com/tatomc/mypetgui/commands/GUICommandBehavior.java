package com.tatomc.mypetgui.commands;

import com.tatomc.mypetgui.MyPetGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class GUICommandBehavior implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            Plugin plugin = MyPetGUI.getPlugin(MyPetGUI.class);
            if (plugin.getConfig().getStringList("black_listed_worlds").contains(player.getWorld().getName()) || !player.hasPermission("mypetgui.use")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.messages.no_permission_use")));
            }else {
                Inventory petguib = Bukkit.createInventory(player, 9, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behvaior_menu_title")));

                //Menu Options(Items)
                ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY.getDyeData());
                ItemStack arm = new ItemStack(Material.ARMOR_STAND);
                ItemStack bone = new ItemStack(Material.BONE);
                ItemStack lead = new ItemStack(Material.LEASH);
                ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
                ItemStack bow = new ItemStack(Material.BOW);
                ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

                //Edit the items
                ItemMeta filler_meta = filler.getItemMeta();
                filler_meta.setDisplayName(ChatColor.BLACK + " ");
                filler_meta.setLocalizedName(ChatColor.BLACK + " ");
                filler.setItemMeta(filler_meta);

                ItemMeta arm_meta = arm.getItemMeta();
                arm_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_friendly")));
                ArrayList<String> arm_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_friendly")){
                    arm_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                arm_meta.setLore(arm_lore);
                arm.setItemMeta(arm_meta);

                ItemMeta bone_meta = bone.getItemMeta();
                bone_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_normal")));
                ArrayList<String> bone_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_normal")){
                    bone_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                bone_meta.setLore(bone_lore);
                bone.setItemMeta(bone_meta);

                ItemMeta lead_meta = lead.getItemMeta();
                lead_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_raid")));
                ArrayList<String> lead_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_raid")){
                    lead_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                lead_meta.setLore(lead_lore);
                lead.setItemMeta(lead_meta);

                ItemMeta axe_meta = axe.getItemMeta();
                axe_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_duel")));
                ArrayList<String> axe_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_duel")){
                    axe_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                axe_meta.setLore(axe_lore);
                axe_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                axe.setItemMeta(axe_meta);

                ItemMeta bow_meta = bow.getItemMeta();
                bow_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_farm")));
                ArrayList<String> bow_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_farm")){
                    bow_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                bow_meta.setLore(bow_lore);
                bow_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                bow.setItemMeta(bow_meta);

                ItemMeta sword_meta = sword.getItemMeta();
                sword_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.behavior_icon_title_aggressive")));
                ArrayList<String> sword_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.behavior_icon_lore_aggressive")){
                    sword_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                sword_meta.setLore(sword_lore);
                sword_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                sword.setItemMeta(sword_meta);

                //Put the items in the inventory
                ItemStack[] menu_items = {filler, arm, bone, lead, filler, axe, bow, sword, filler};
                petguib.setContents(menu_items);
                player.openInventory(petguib);


            }
        }

        return true;
    }
}

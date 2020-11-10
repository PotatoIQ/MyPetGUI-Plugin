package com.tatomc.mypetgui.commands;

import com.tatomc.mypetgui.MyPetGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class GUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            Plugin plugin = MyPetGUI.getPlugin(MyPetGUI.class);
            if (plugin.getConfig().getStringList("black_listed_worlds").contains(player.getWorld().getName()) || !player.hasPermission("mypetgui.use")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.messages.no_permission_use")));
            }else {
                Inventory petgui = Bukkit.createInventory(player, 45, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_menu_title")));

                //Menu Options(Items)
                ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY.getDyeData());
                ItemStack chest = new ItemStack(Material.CHEST);
                ItemStack beacon = new ItemStack(Material.BEACON);
                ItemStack sapling = new ItemStack(Material.SAPLING, 1, (short) 1);
                ItemStack saddle = new ItemStack(Material.SADDLE);
                ItemStack lead = new ItemStack(Material.LEASH);
                ItemStack bed = new ItemStack(Material.BED, 1, DyeColor.BLUE.getWoolData());
                ItemStack egg = new ItemStack(Material.MONSTER_EGG, 1, EntityType.CREEPER.getTypeId());
                ItemStack hopper = new ItemStack(Material.HOPPER);
                ItemStack dSword = new ItemStack(Material.DIAMOND_SWORD);
                ItemStack book = new ItemStack(Material.BOOK_AND_QUILL);
                ItemStack paper = new ItemStack(Material.PAPER);
                ItemStack cMineCart = new ItemStack(Material.STORAGE_MINECART);
                ItemStack NameTag = new ItemStack(Material.NAME_TAG);
                ItemStack gNugget = new ItemStack(Material.GOLD_NUGGET);
                ItemStack tnt = new ItemStack(Material.TNT);

                //Edit the items
                ItemMeta filler_meta = filler.getItemMeta();
                filler_meta.setDisplayName(ChatColor.BLACK + " ");
                filler_meta.setLocalizedName(ChatColor.BLACK + " ");
                filler.setItemMeta(filler_meta);

                ItemMeta chest_meta = chest.getItemMeta();
                chest_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petinventory")));
                ArrayList<String> chest_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petinventory")){
                    chest_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                chest_meta.setLore(chest_lore);
                chest.setItemMeta(chest_meta);

                ItemMeta beacon_meta = beacon.getItemMeta();
                beacon_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petbeacon")));
                ArrayList<String> beacon_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petbeacon")){
                    beacon_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                beacon_meta.setLore(beacon_lore);
                beacon.setItemMeta(beacon_meta);

                ItemMeta sapling_meta = sapling.getItemMeta();
                sapling_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_skilltree")));
                ArrayList<String> sapling_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_skilltree")){
                    sapling_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                sapling_meta.setLore(sapling_lore);
                sapling.setItemMeta(sapling_meta);

                ItemMeta saddle_meta = saddle.getItemMeta();
                saddle_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_callpet")));
                ArrayList<String> saddle_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_callpet")){
                    saddle_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                saddle_meta.setLore(saddle_lore);
                saddle.setItemMeta(saddle_meta);

                ItemMeta lead_meta = lead.getItemMeta();
                lead_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_sendpetaway")));
                ArrayList<String> lead_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_sendpetaway")){
                    lead_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                lead_meta.setLore(lead_lore);
                lead.setItemMeta(lead_meta);

                ItemMeta bed_meta = bed.getItemMeta();
                bed_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_storepet")));
                ArrayList<String> bed_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_storepet")){
                    bed_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                bed_meta.setLore(bed_lore);
                bed.setItemMeta(bed_meta);

                ItemMeta egg_meta = egg.getItemMeta();
                egg_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_choosepet")));
                ArrayList<String> egg_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_choosepet")){
                    egg_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                egg_meta.setLore(egg_lore);
                egg.setItemMeta(egg_meta);

                ItemMeta hopper_meta = hopper.getItemMeta();
                hopper_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_itempickup")));
                ArrayList<String> hopper_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_itempickup")){
                    hopper_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                hopper_meta.setLore(hopper_lore);
                hopper.setItemMeta(hopper_meta);

                ItemMeta dSword_meta = dSword.getItemMeta();
                dSword_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petbehavior")));
                ArrayList<String> dSword_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petbehavior")){
                    dSword_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                dSword_meta.setLore(dSword_lore);
                dSword_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                dSword.setItemMeta(dSword_meta);

                ItemMeta book_meta = book.getItemMeta();
                book_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petinfo")));
                ArrayList<String> book_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petinfo")){
                    book_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                book_meta.setLore(book_lore);
                book.setItemMeta(book_meta);

                ItemMeta paper_meta = paper.getItemMeta();
                paper_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petskillinfo")));
                ArrayList<String> paper_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petskillinfo")){
                    paper_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                paper_meta.setLore(paper_lore);
                paper.setItemMeta(paper_meta);

                ItemMeta cMineCart_meta = cMineCart.getItemMeta();
                cMineCart_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petshop")));
                ArrayList<String> cMineCart_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petshop")){
                    cMineCart_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                cMineCart_meta.setLore(cMineCart_lore);
                cMineCart.setItemMeta(cMineCart_meta);

                ItemMeta NameTag_meta = NameTag.getItemMeta();
                NameTag_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_petname")));
                ArrayList<String> NameTag_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_petname")){
                    NameTag_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                NameTag_meta.setLore(NameTag_lore);
                NameTag.setItemMeta(NameTag_meta);

                ItemMeta gNugget_meta = gNugget.getItemMeta();
                gNugget_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_tradepet")));
                ArrayList<String> gNugget_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_tradepet")){
                    gNugget_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                gNugget_meta.setLore(gNugget_lore);
                gNugget.setItemMeta(gNugget_meta);

                ItemMeta tnt_meta = tnt.getItemMeta();
                tnt_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("lang.mypetgui_icon_title_deletepet")));
                ArrayList<String> tnt_lore = new ArrayList<>();
                for(String lore_title : plugin.getConfig().getStringList("lang.mypetgui_icon_lore_deletepet")){
                    tnt_lore.add(ChatColor.translateAlternateColorCodes('&', lore_title));
                }
                tnt_meta.setLore(tnt_lore);
                tnt.setItemMeta(tnt_meta);

                //Put the items in the inventory
                ItemStack[] menu_items = {filler, chest, beacon, sapling, filler, filler, saddle, lead, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, bed, egg, cMineCart, filler, filler, hopper, dSword, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, filler, book, paper, filler, filler, NameTag, gNugget, tnt, filler};
                petgui.setContents(menu_items);
                player.openInventory(petgui);


            }
        }

        return true;
    }
}

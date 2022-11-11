package de.maxbossing.serverapi.Constants;

import de.maxbossing.serverapi.ItemUtils.ItemStackBuilder;
import de.maxbossing.serverapi.UTils.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class Items {

    /*
    This Class returns standard ItemStacks for use in all Plugins

    Please use for everything these items are needed (e.g. placeholders in GUI's)

    to use the Items, create an instance of the class at the top of your class like

    '''
    Items $Instance_Name = new ServerAPI.Items;
    '''
     */


    /*
    Placeholder for unused slots in GUI's
     */
    public static final ItemStack placeHolder() {
        return new ItemStackBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setDisplayname("")
                .setLore("")
                .setAmount(1)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .addCustomModelData(1)
                .addNameSpacedKey(NameSpacedKeys.placeholder())
                .build();
    }

    /*
    Coming soon Placeholder for not yet implemented slots in GUI's
     */
    public static final ItemStack comingSoon() {
        return new ItemStackBuilder(Material.BEDROCK)
                .setDisplayname(StringUtils.rainbowlize("Coming Soon..."))
                .setLore("")
                .setAmount(1)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .addCustomModelData(1)
                .addNameSpacedKey(NameSpacedKeys.comingSoon())
                .build();
    }


    /*
    Button for next page in GUI's
     */
    public static final ItemStack nextPage() {
        return new ItemStackBuilder(Material.ARROW)
                .setDisplayname(StringUtils.format(ChatColor.GOLD + "Next Page"))
                .setLore("")
                .setAmount(1)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .addCustomModelData(1)
                .addNameSpacedKey(NameSpacedKeys.nextPage())
                .build();
    }

    /*
    Button for page back in GUI's
     */
    public static final ItemStack pageBack() {
        return new ItemStackBuilder(Material.ARROW)
                .setDisplayname(StringUtils.format(ChatColor.GOLD + "Page Back"))
                .setLore("")
                .setAmount(1)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .addCustomModelData(2)
                .addNameSpacedKey(NameSpacedKeys.pageBack())
                .build();
    }

    /*
    Button for first page in GUI's
    */
    public static final ItemStack firstPage() {
        return new ItemStackBuilder(Material.SPECTRAL_ARROW)
                .setDisplayname(StringUtils.format(ChatColor.GOLD + "First Page"))
                .setLore("Jump to first page")
                .setAmount(1)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .addCustomModelData(1)
                .addNameSpacedKey(NameSpacedKeys.firstPage())
                .build();
    }

    /*
    Button for last page in GUI's
    */
    public static final ItemStack lastPage() {
        return new ItemStackBuilder(Material.SPECTRAL_ARROW)
                .setDisplayname(StringUtils.format(ChatColor.GOLD + "Last Page"))
                .setLore("Jump to last page")
                .setAmount(1)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .addCustomModelData(2)
                .addNameSpacedKey(NameSpacedKeys.lastPage())
                .build();
    }

    /*
    Back Button for use in GUI's
     */
    public static final ItemStack back() {
        return new ItemStackBuilder(Material.SPRUCE_DOOR)
                .setDisplayname(StringUtils.format(ChatColor.GOLD + "Back"))
                .setLore("")
                .setAmount(1)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .addCustomModelData(1)
                .addNameSpacedKey(NameSpacedKeys.back())
                .build();
    }

    /*
    Exit button for use in GUI's
     */
    public static final ItemStack exit() {
        return new ItemStackBuilder(Material.BARRIER)
                .setDisplayname(StringUtils.format(ChatColor.GOLD + "Exit"))
                .setLore("")
                .setAmount(1)
                .addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
                .addCustomModelData(1)
                .addNameSpacedKey(NameSpacedKeys.exit())
                .build();
    }









}

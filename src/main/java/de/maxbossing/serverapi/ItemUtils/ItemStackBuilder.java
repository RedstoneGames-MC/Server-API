package de.maxbossing.serverapi.ItemUtils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;


import java.util.*;

public class ItemStackBuilder {

    /*
    This library is used to simplify creating Items

    Please only create items without the builder if there is no other way

    If features are missing, first try to add them an send a PR instead of creating itemstacks manually

    to use the Itembuilder, create an instance of it at the top of your class like

    '''
    ItemBuilder $Instance_Name = new ServerAPI.ItemBuilder;
    '''
     */


    /*
    TODO: Add descriptive variable names
    TODO: organise into correlative blocks

     */


    private final ItemMeta itemMeta;
    private final ItemStack itemStack;

    /*
    For setting material, add an itemstack in Itembuilder(),

    ItemBuilder(Material);
     */
    public ItemStackBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }


    /*
    Sets the Displayname. This can be altered by a Player if not deactivated.

    ItemBuilder(Material).setDisplayName(String);
     */
    public ItemStackBuilder setDisplayname(String displayName){
        itemMeta.setDisplayName(displayName);
        return this;
    }


    /*
    Sets the Localized Name. This cant be altered by the player but will not get displayed. Useful for internal checks of renamed items

    ItemBuilder().setLocalizedName(String);
     */
    public ItemStackBuilder setLocalizedName(String localizedName){
        itemMeta.setLocalizedName(localizedName);
        return this;
    }


    /*
    Sets the unbreakable flag

    ItemBuilder(Material).setUnbreakble(boolean)
     */
    public ItemStackBuilder setUnbreakable(boolean unbreakable){
        itemMeta.setUnbreakable(unbreakable);
        return this;
    }


    /*
    Used to set ItemFlags
    for every flag, create an entry to the arraylist

    ItemBuilder().addItemFlags(Arraylist<ItemFlag>);

    or write it directly in the Parenthesis

    ItemBuilder(Material).setItemFlags(ItemFlag, ItemFlag);

     */
    public ItemStackBuilder addItemFlags(ItemFlag... itemFlags){
        itemMeta.addItemFlags(itemFlags);
        return this;
    }


    /*
    Sets the CustomModelData for use in texturepacks

    ItemBuilder(Material).addCustomModelData(int);
     */
    public ItemStackBuilder addCustomModelData(int customModelData) {
        itemMeta.setCustomModelData(customModelData);
        return this;
    }


    /*
    Adds a NameSpacedKey to the persistent Data Container of an Item
    Useful for internal checking of items
    Similar to the key of vanilla items, eg: "minecraft:dirt"

    ItemBuilder(Material).addNameSpacedKey(NameSpacedkey);
     */
    public ItemStackBuilder addNameSpacedKey(NamespacedKey namespacedKey) {
        itemMeta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.BYTE, (byte) 1);
        return this;
    }


    /*
    Sets the Durability of the Itemstack

    ItemBuilder(Material).setDurability(short);
     */
    public ItemStackBuilder setDurability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }


    /*
    Sets the amount of the ItemStack.
    this can be used to create infinite stacks / stacks over 64

    ItemBuilder(Material).setAmount(int)
     */
    public ItemStackBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /*
    Adds to the amount of the ItemStack.

    ItemBuilder(Material).addToAmount(int)
    */
    public ItemStackBuilder addToAmount(int amount) {
        itemStack.setAmount(itemStack.getAmount() + amount);
        return this;
    }


    /*
    Sets the Enchantments of the Itemstack
    Can be used to create infinite enchantments
    WARNING: This will CLEAR ALL enchantments present on the Item

    ItemBuilder(Material).setEnchantments(Hashmap<Enchantment, Integer>);
     */
    public ItemStackBuilder setEnchantments(HashMap<Enchantment, Integer> enchantments) {
        for (Enchantment enchantment : itemStack.getEnchantments().keySet()) {
            itemStack.removeEnchantment(enchantment);
        }
        itemStack.addUnsafeEnchantments(enchantments);
        return this;
    }

    /*
    Adds an Enchantment to the Itemstack
    Can be used to create infinite enchantments

    ItemBuilder(Material).addEnchantments(Enchantment, int);
     */
    public ItemStackBuilder addEnchantment(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }


    /*
    These methods are for creating a line of '-' characters
    If no argument is passed, it will add a line 20 chars of length

    If an int is passed, it will create a line the length of the int

    If a String is passed, it will append these at the beginning
    mostly used to add Color/Format codes

    If a string and an int is passed, it will add the string at the beginning, and create a line the length of the int

    ItemBuilder(Material).addLineLore(*int, *String)
     */
    public ItemStackBuilder addLineLore() {
        addLineLore(20);
        return this;
    }

    public ItemStackBuilder addLineLore(String format) {
        addLineLore(20, format);
        return this;
    }

    public ItemStackBuilder addLineLore(int length) {
        addLineLore(length, "§8§l");
        return this;
    }

    public ItemStackBuilder addLineLore(int length, String format) {
        String line = format;
        for (int i = 0; i <= length; i++) {
            line = line + '-';
        }
        addLore(line);
        return this;
    }


    /*
    appends to the current lore

    ItemBuilder().addlore(Arraylist);

    or write it directly in the Parenthesis

    ItemBuilder(Material).addLore(String, String);
     */
    public ItemStackBuilder addLore(String... lore) {
        List originalLore = itemMeta.getLore();
        originalLore.addAll(Collections.singleton(lore));
        itemMeta.setLore(originalLore);
        return this;
    }

    /*
    Sets Lore of the Item.

    ItemBuilder().setLore(Arraylist<String>);

    or write it directly in the Parenthesis

    ItemBuilder(Material).setLore(String, String);
     */
    public ItemStackBuilder setLore(String... lore){
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }



    /*
    Outputs The created ItemStack incl. ItemMeta as String
    Conflicts with build()

    This MUST be the last method in the ItemBuilder call

    ItemBuilder(Material).toString
     */
    @Override
    public String toString() {
        return "ItemBuilder{" +
                "itemMeta=" + itemMeta +
                ", itemStack=" + itemStack +
                '}';
    }

    /*
    Creates the ItemStack with the defined Meta
    Conflicts with toString()

    This MUST be the last method in the ItemBuilder call

    ItemBuilder(Material).build;
     */
    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}

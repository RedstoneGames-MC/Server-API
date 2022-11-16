package de.maxbossing.serverapi.ItemUtils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BannerBuilder {

    /*
    This library is used to simplify creating Banners

    Please only create Banners without the builder if there is no other way

    If features are missing, first try to add them and send a PR instead of creating Banners manually

    to use the BanenrBuilder, create an instance of it at the top of your class like

    '''
    BannerBuilder $Instance_Name = new ServerAPI.BannerBuilder;
    '''
     */

    private final BannerMeta bannerMeta;

    private final ItemStack itemStack;


    /*
    This class does not need a material specification.
    It uses the legacy banner for simplification of developing
     */
    public BannerBuilder() {
        itemStack = new ItemStack(Material.LEGACY_BANNER);
        bannerMeta = (BannerMeta) itemStack.getItemMeta();
    }

    /*
    Sets base color of the Banner

    BannerBuilder().setBaseColor(DyeColor);
     */
    public BannerBuilder setBaseColor(DyeColor color) {
        bannerMeta.setBaseColor(color);
        return this;
    }

    /*
    Sets pattern pattern at index index

    BannerBuilder().setPattern(int, Pattern);
     */
    public BannerBuilder setPattern(int index, Pattern pattern) {
        bannerMeta.setPattern(index, pattern);
        return this;
    }

    /*
    Sets new Pattern(color, type) at index index

    BannerBuilder().setPattern(int, DyeColor, PatternType);
     */
    public BannerBuilder setPattern(int index, DyeColor color, PatternType type) {
        bannerMeta.setPattern(index, new Pattern(color, type));
        return this;
    }

    /*
    Sets List<Patterns> as patterns

    BannerBuilder().setpatterns(List<Patterns>);
     */
    public BannerBuilder setPatterns(List<Pattern> patterns) {
        bannerMeta.setPatterns(patterns);
        return this;
    }

    /*
    Append pattern as the last pattern

    BannerBuilder().addPattern(Pattern);
     */
    public BannerBuilder addPattern(Pattern pattern) {
        bannerMeta.addPattern(pattern);
        return this;
    }


    /*
    Append new Pattern(color, type) as the last pattern

    BannerBuilder().addPattern(DyeColor, PatternType);
     */
    public BannerBuilder addPattern(DyeColor color, PatternType type) {
        bannerMeta.addPattern(new Pattern(color, type));
        return this;
    }


    /*
    Removes pattern at index

    BannerBuilder().removePattern(int);
     */
    public BannerBuilder removePattern(int index) {
        bannerMeta.removePattern(index);
        return this;
    }

    /*
    Removes all Patterns of banner

    BannerBuilder().removePattern();
    */
    public BannerBuilder removePattern() {
        for (Pattern pattern : bannerMeta.getPatterns()) {
            bannerMeta.removePattern(bannerMeta.getPatterns().indexOf(pattern));
        }
        return this;
    }



    /*
    Outputs The created Banner incl. BannerMeta as String
    Conflicts with build()

    This MUST be the last method in the BannerBuiler call

    BannerBuilder().toString
    */
    @Override
    public String toString() {
        return "BannerBuilder{" +
                "bannerMeta=" + bannerMeta +
                ", itemStack=" + itemStack +
                '}';
    }

    /*
    Creates the Banner with the defined Meta
    Conflicts with toString()

    This MUST be the last method in the ItemBuilder call

    BannerBuilder().build;
     */
    public ItemStack build(){
        itemStack.setItemMeta(bannerMeta);
        return itemStack;
    }
}

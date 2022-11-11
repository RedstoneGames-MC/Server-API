package de.maxbossing.serverapi.Constants;

import de.maxbossing.serverapi.ServerAPI;
import org.bukkit.NamespacedKey;

public class NameSpacedKeys {

    /*
    This Class returns standard NameSpacedKeys for use in all Plugins

    these correspond to the items in Constants.Items

    to use the Keys, create an instance of the class at the top of your class like

    '''
    NameSpacedKeys $Instance_Name = new ServerAPI.NameSpacedKeys;
    '''
     */


    /*
    Placeholder Item
     */
    public static final NamespacedKey placeholder() { return new NamespacedKey(ServerAPI.getInstance(), "placeholder"); }

    /*
    Coming Soon Item
    */
    public static final NamespacedKey comingSoon() { return new NamespacedKey(ServerAPI.getInstance(), "coming_soon"); }


    /*
    Next Page Item
     */
    public static final NamespacedKey nextPage() { return new NamespacedKey(ServerAPI.getInstance(), "next_page"); }

    /*
    Page Back Item
     */
    public static final NamespacedKey pageBack() { return new NamespacedKey(ServerAPI.getInstance(), "page_back"); }

    /*
    First Page Item
     */
    public static final NamespacedKey firstPage() { return new NamespacedKey(ServerAPI.getInstance(), "first_page"); }

    /*
    Last Page Item
    */
    public static final NamespacedKey lastPage() { return new NamespacedKey(ServerAPI.getInstance(), "last_page"); }


    /*
    Back Button
     */
    public static final NamespacedKey back() { return new NamespacedKey(ServerAPI.getInstance(), "back"); }

    /*
    Exit Button
     */
    public static final NamespacedKey exit() { return new NamespacedKey(ServerAPI.getInstance(), "exit"); }
}

package de.maxbossing.serverapi.Constants;

public class Prefixes {

    /*
    This Class returns standard Prefixes for use in all Plugins

    Please use for all Player interaction the Prefixes in this class
    only use own Prefixes if needed

    For console logging please create an own prefix like "[$Plugin_Name] "

    to use the Prefixes, create an instance of it at the top of your class like

    '''
    final String $Prefix_Name = new ServerAPI.Prefixes.Prefix();
    '''
     */

    /*
    Main Prefix. Used when Messages not falling in the categories of the other Prefixes are sent to the Player
     */
    public static final String MAIN() {return "§6§lRedstoneGames §r§0» §r";}

    /*
    Error Prefix. used when Errors are sent to the Player
     */
    public static final String ERROR() {return "§6§lRedstoneGames §r§4ERROR §0» §r";}

    /*
    Warning Prefix. used when Warnings are sent to the Player
     */
    public static final String WARNING() {return "§6§lRedstoneGames §r§cWARNING §0» §r";}

    /*
    Info Prefix. used when Infos are sent to the Player
     */
    public static final String INFO() {return "§6§lRedstoneGames §r§eINFO §0» §r";}



}

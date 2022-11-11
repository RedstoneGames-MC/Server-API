package de.maxbossing.serverapi.UTils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringUtils {

    /*
    This library is used to simplify formatting Strings

    Please use this Library as much as possible

    '''
    StringUtils $Instance_Name = new ServerAPI.StringUtils;
    '''
     */


    /*
    These methods translate ChatColor.COLOR to vanilla Color Codes

    StringUtils.format(String);
     */
    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('§', string);
    }

    public static String[] format(String[] strings) {
        return format(Arrays.asList(strings)).toArray(new String[strings.length]);
    }

    public static List<String> format(List<String> strings) {
        List<String> collection = new ArrayList<>();
        for (String string : strings) {
            collection.add(format(string));
        }
        return collection;
    }


    /*
    Links a list of Strings to one string with the Content of the list separated by a comma

    StringUtils.link(List<String>);
     */
    public static String link(List<String> strings) {
        String newString = "";
        for (String string : strings) {
            newString += string + ", ";
        }
        newString = newString.substring(0, newString.length() - 2);
        return newString;
    }


    /*
    Prefixes the contents of a List of Strings with a String

    StringUtils.prefix(List<String>, String);
     */
    public static List<String> prefix(List<String> strings, String prefix) {
        List<String> newStrings = new ArrayList<>();
        for (String string : strings) {
            newStrings.add(prefix + string);
        }
        return newStrings;
    }

    /*
    Suffixes the contents of a List of Strings with a String

    StringUtils.suffix(List<String>, String);
     */
    public static List<String> suffix(List<String> strings, String suffix) {
        List<String> newStrings = new ArrayList<>();
        for (String string : strings) {
            newStrings.add(string + suffix);
        }
        return newStrings;
    }


    /*
    Rainbowlizes a String
    def -> add a color code in between every character

    if a String of characters/numbers is passed, it will only use these colors

    StringUtils.rainbowlize(String, *String);
     */
    public static String rainbowlize(String string) {
        int lastColor = 0;
        int currColor;
        String newString = "";
        String colors = "123456789abcde";
        for (int i = 0; i < string.length(); i++) {
            do {
                currColor = new Random().nextInt(colors.length() - 1) + 1;
            }
            while (currColor == lastColor);
            newString += ChatColor.RESET.toString() + ChatColor.getByChar(colors.charAt(currColor)) + "" + string.charAt(i);
        }
        return newString;
    }

    public static String rainbowlize(String string, String codes) {
        int lastColor = 0;
        int currColor;
        String newString = "";
        String colors = codes;
        for (int i = 0; i < string.length(); i++) {
            do {
                currColor = new Random().nextInt(colors.length() - 1) + 1;
            }
            while (currColor == lastColor);
            newString += ChatColor.RESET.toString() + ChatColor.getByChar(colors.charAt(currColor)) + "" + string.charAt(i);
        }
        return newString;
    }


    /*
    Repeats a String by the passed amount

    StringUtils.repeat(String, int);
     */
    public static String repeat(String string, int count) {
        if (count == 0) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(string);
        }
        return builder.toString();
    }


    /*
    Strips all colors from a String

    StringUtils.stripColor(String);
     */
    public static String stripColor(String string) {
        return ChatColor.stripColor(string);
    }


    /*
    formats seconds in mm:ss format

    StringUtils.toMMSS;
     */
    public static String toMMSS(int seconds) {
        int rem = seconds % 3600;
        int mn = rem / 60;
        int sec = rem % 60;
        return (mn < 10 ? "0" : "") + mn + ":" + (sec < 10 ? "0" : "") + sec;
    }

    /*
    formats seconds in hh:mm:ss format

    StringUtils.toHHMMSS;
     */
    public static String toHHMMSS (int timeInSeconds){
        int hours = timeInSeconds / 3600;
        int secondsLeft = timeInSeconds - hours * 3600;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;
        String formattedTime = "";

        if (hours < 10)
            formattedTime += "0";
        formattedTime += hours + ":";

        if (minutes < 10)
            formattedTime += "0";
        formattedTime += minutes + ":";

        if (seconds < 10)
            formattedTime += "0";
        formattedTime += seconds;

        return formattedTime;
        }

}


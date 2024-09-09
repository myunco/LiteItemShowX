package net.myunco.liteitemshowx.config;

import net.myunco.liteitemshowx.LiteItemShowX;

public class Config {
    public static String keyword;
    public static boolean showAmount;
    public static String sColor;
    public static String xColor;
    public static String nColor;

    public static void loadConfig(LiteItemShowX plugin) {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        keyword = plugin.getConfig().getString("keyword");
        showAmount = plugin.getConfig().getBoolean("showAmount");
        sColor = plugin.getConfig().getString("sColor");
        xColor = plugin.getConfig().getString("xColor");
        nColor = plugin.getConfig().getString("nColor");
    }
}

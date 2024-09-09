package net.myunco.liteitemshowx;

import net.myunco.liteitemshowx.config.Config;
import net.myunco.liteitemshowx.listener.ChatEventListener;
import net.myunco.liteitemshowx.metrics.Metrics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public final class LiteItemShowX extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        int mcVersion = Integer.parseInt(getServer().getBukkitVersion().replace('-', '.').split("\\.")[1]);
        getLogger().info("minecraft version: 1." + mcVersion);
        try {
            Class.forName("net.kyori.adventure.text.Component");
        } catch (ClassNotFoundException e) {
            getLogger().severe("插件加载出错：不受支持的服务端，请使用Paper系服务端。");
            // getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Config.loadConfig(this);
        getServer().getPluginManager().registerEvents(new ChatEventListener(this), this);
        new Metrics(this, 13325);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            return false;
        }
        switch (args[0].toLowerCase()) {
            case "reload":
                Config.loadConfig(this);
                sendMessage(sender, "§a配置文件重载完成。");
                break;
            case "version":
                sendMessage(sender, "§a当前版本: §b" + this.getDescription().getVersion());
                break;
            default:
                sendMessage(sender, "§6错误: 未知的命令参数。");
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, Command command, @NotNull String alias, String[] args) {
        return TabComplete.getCompleteList(args, TabComplete.getTabList(args, command.getName()));
    }

    private void sendMessage(CommandSender sender, String msg) {
        sender.sendMessage("§8[§3LiteItemShowX§8] " + msg);
    }

}

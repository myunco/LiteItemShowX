package net.myunco.liteitemshowx.listener;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.myunco.liteitemshowx.LiteItemShowX;
import net.myunco.liteitemshowx.config.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatEventListener implements Listener {
    private final LiteItemShowX plugin;

    public ChatEventListener(LiteItemShowX plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        if (event.getPlayer().hasPermission("LiteItemShowX.show") && ChatColor.stripColor(event.getMessage()).equals(Config.keyword)) {
            ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemStack.getType() == Material.AIR) {
                return;
            }
            event.setCancelled(true);
            TextComponent format = Component.text(getTextLeft(event.getFormat(), "%2$s").replace("%1$s", event.getPlayer().getDisplayName()));
            if (itemMeta.hasDisplayName()) {
                TextComponent text;
                if (Config.showAmount) {
                    text = Component.text("[", TextColor.color(Integer.parseInt(Config.sColor, 16)))
                            .append(itemMeta.displayName())
                            .append(Component.text(" x", TextColor.color(Integer.parseInt(Config.xColor, 16))))
                            .append(Component.text(itemStack.getAmount(), TextColor.color(Integer.parseInt(Config.nColor, 16))))
                            .append(Component.text("]"))
                            .hoverEvent(itemStack);
                } else {
                    text = Component.text("[", TextColor.color(Integer.parseInt(Config.sColor, 16)))
                            .append(itemMeta.displayName())
                            .append(Component.text("]"))
                            .hoverEvent(itemStack);
                }
                plugin.getServer().broadcast(format.append(text));
            } else {
                TextComponent text;
                if (Config.showAmount) {
                    text = Component.text("[", TextColor.color(Integer.parseInt(Config.sColor, 16)))
                            .append(Component.translatable(itemStack.translationKey()).color(getRarityColor(itemStack)))
                            .append(Component.text(" x", TextColor.color(Integer.parseInt(Config.xColor, 16))))
                            .append(Component.text(itemStack.getAmount(), TextColor.color(Integer.parseInt(Config.nColor, 16))))
                            .append(Component.text("]"))
                            .hoverEvent(itemStack);
                } else {
                    text = Component.text("[", TextColor.color(Integer.parseInt(Config.sColor, 16)))
                            .append(Component.translatable(itemStack.translationKey()).color(getRarityColor(itemStack)))
                            .append(Component.text("]"))
                            .hoverEvent(itemStack);
                }
                plugin.getServer().broadcast(format.append(text));
            }
        }
    }

    Material[] uncommonList = {
            Material.DRAGON_BREATH,
            Material.EXPERIENCE_BOTTLE,
            Material.ELYTRA,
            Material.ENCHANTED_BOOK,
            Material.CREEPER_HEAD,
            Material.PLAYER_HEAD,
            Material.DRAGON_HEAD,
            Material.PISTON_HEAD,
            Material.ZOMBIE_HEAD,
            Material.HEART_OF_THE_SEA,
            Material.NETHER_STAR,
            Material.TOTEM_OF_UNDYING
    };
    Material[] rareList = {
            Material.BEACON,
            Material.CONDUIT,
            Material.END_CRYSTAL,
            Material.GOLDEN_APPLE
    };
    Material[] epicList = {
            Material.COMMAND_BLOCK,
            Material.CHAIN_COMMAND_BLOCK,
            Material.REPEATING_COMMAND_BLOCK,
            Material.COMMAND_BLOCK_MINECART,
            Material.DRAGON_EGG,
            Material.ENCHANTED_GOLDEN_APPLE,
            Material.KNOWLEDGE_BOOK,
            Material.STRUCTURE_BLOCK,
            Material.STRUCTURE_VOID
    };

    private TextColor getRarityColor(ItemStack item) {
        Material material = item.getType();
        for (Material mater : uncommonList) {
            if (material.equals(mater)) {
                return NamedTextColor.YELLOW;
            }
        }
        if (material.isRecord()) {
            return NamedTextColor.AQUA;
        } else {
            for (Material mater : rareList) {
                if (material.equals(mater)) {
                    return NamedTextColor.AQUA;
                }
            }
        }
        for (Material mater : epicList) {
            if (material.equals(mater)) {
                return NamedTextColor.LIGHT_PURPLE;
            }
        }
        if (item.getEnchantments().isEmpty()) {
            return NamedTextColor.WHITE;
        } else {
            return NamedTextColor.AQUA;
        }
    }

    private static String getTextLeft(String str, String subStr) {
        int index = str.indexOf(subStr);
        return index < 1 ? "" : str.substring(0, index);
    }

}

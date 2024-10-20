package main.java.dev.rellox.spigot.extractableenchantments.item;

import java.util.List;
import java.util.stream.IntStream;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import main.java.dev.rellox.spigot.extractableenchantments.configuration.Language;
import main.java.dev.rellox.spigot.extractableenchantments.text.Text;
import main.java.dev.rellox.spigot.extractableenchantments.text.content.Content;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Keys;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Utility;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Version;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Version.VersionType;
import main.java.dev.rellox.spigot.extractableenchantments.utility.reflect.Reflect.RF;

public final class ItemRegistry {
	
	@SuppressWarnings("deprecation")
	public static void glint(ItemMeta meta) {
		if(Version.version.high(VersionType.v_20_4) == true) {
			RF.order(meta, "setEnchantmentGlintOverride", Boolean.class).invoke(true);
		} else {
			meta.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft("power")), 0, true);
		}
	}
	
	public static boolean full(Player player) {
		PlayerInventory pi = player.getInventory();
		return IntStream.range(0, 36)
				.mapToObj(pi::getItem)
				.noneMatch(ItemRegistry::nulled);
	}

	public static int free(Player player) {
		PlayerInventory pi = player.getInventory();
		return (int) IntStream.range(0, 36)
				.mapToObj(pi::getItem)
				.filter(ItemRegistry::nulled)
				.count();
	}

	public static boolean nulled(ItemStack item) {
		return item == null || item.getType() == Material.AIR;
	}
	
	public static boolean chance(ItemStack item) {
		if(nulled(item) == true) return false;
		PersistentDataContainer p = item.getItemMeta().getPersistentDataContainer();
		return Utility.random(100) <= p.getOrDefault(Keys.chance(), PersistentDataType.INTEGER, 100);
	}
	
	public static void replace(ItemStack item, List<Content> list) {
		if(item == null || item.hasItemMeta() == false) return;
		ItemMeta meta = item.getItemMeta();
		List<String> lore = meta.getLore();
		if(lore == null) return;

		int s = -1;
		for(int i = lore.size() - 1; i >= 0; i--) {
			String line = lore.get(i);
			if(line.startsWith(Language.prefix_chance) == false) continue;
			lore.remove(i);
			s = i;
		}
		if(s < 0) return;

		list.replaceAll(c -> Content.of(Content.of(Language.prefix_chance), c));
		lore.addAll(s, Text.toText(list));
		meta.setLore(lore);
		item.setItemMeta(meta);
	}

}

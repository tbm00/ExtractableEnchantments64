package main.java.dev.rellox.spigot.extractableenchantments.hook;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import com.willfp.ecoenchants.enchant.EcoEnchantLike;

import main.java.dev.rellox.spigot.extractableenchantments.api.item.enchantment.IEnchantment;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.enchantment.IEnchantmentReader;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.enchantment.IMetaFetcher;
import main.java.dev.rellox.spigot.extractableenchantments.item.ItemRegistry;
import main.java.dev.rellox.spigot.extractableenchantments.item.enchantment.EnchantmentRegistry;

public class EcoEnchantsHook implements IHook, IEnchantmentReader {

	@Override
	public String name() {
		return "EcoEnchants";
	}

	@Override
	public void enable() {}

	@Override
	public String key() {
		return name().toLowerCase();
	}

	@Override
	public Map<IEnchantment, Integer> enchantments(ItemStack item) {
		Map<IEnchantment, Integer> map = new HashMap<>();
		if(ItemRegistry.nulled(item) == true || item.hasItemMeta() == false) return map;
		
		IMetaFetcher fetcher = EnchantmentRegistry.fetcher(item.getItemMeta());
		
		fetcher.enchantments().forEach((e, level) -> {
			if(e instanceof EcoEnchantLike ee) {
				String key = e.getKey().getKey();
				String name = ChatColor.stripColor(ee.getRawDisplayName());
				int max = ee.getMaximumLevel();
				map.put(new EcoEnchantment(e, key, name, max), level);
			}
		});
		return map;
	}
	
	public record EcoEnchantment(Enchantment enchantment, String key, String name, int maximum) implements IEnchantment {

		@Override
		public void remove(ItemStack item) {
			IEnchantment.removeAsDefault(item, enchantment);
		}

		@Override
		public void apply(ItemStack item, int level) {
			IEnchantment.applyAsDefault(item, enchantment, level);
		}
		
	}

}

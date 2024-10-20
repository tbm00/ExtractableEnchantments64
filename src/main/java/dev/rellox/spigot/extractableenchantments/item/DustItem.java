package main.java.dev.rellox.spigot.extractableenchantments.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import main.java.dev.rellox.spigot.extractableenchantments.api.dust.IDust;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.IDustItem;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.order.IOrder;
import main.java.dev.rellox.spigot.extractableenchantments.configuration.Settings;
import main.java.dev.rellox.spigot.extractableenchantments.text.content.Content;
import main.java.dev.rellox.spigot.extractableenchantments.text.content.Content.Variables;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Keys;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Utility;

public class DustItem extends Item implements IDustItem {
	
	public IDust dust;

	public DustItem(Material material, List<Content> name, List<Content> info, boolean glint, int model) {
		super(material, name, info, glint, model);
	}

	@Override
	public boolean match(ItemStack item) {
		if(item == null || item.hasItemMeta() == false) return false;
		ItemMeta meta = item.getItemMeta();
		PersistentDataContainer data = meta.getPersistentDataContainer();
		String saved = data.get(Keys.dust(), PersistentDataType.STRING);
		return dust.key().equalsIgnoreCase(saved) == true;
	}

	@Override
	public ItemStack constant() {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.values());
		
		if(glint == true) ItemRegistry.glint(meta);
		if(model > 0) meta.setCustomModelData(model);
		
		List<Content> name = new ArrayList<>(this.name);
		name.replaceAll(c -> c.modified(Variables.with("percent", dust.percent())));
		if(name.size() > 0) meta.setDisplayName(name.remove(0).text());
		
		IOrder order = Settings.settings.order_dust.oderer();
		
		order.named(name);
		
		order.submit("INFO", () -> info);
		
		meta.setLore(order.build());

		item.setItemMeta(meta);
		return item;
	}

	@Override
	public ItemStack item(int percent) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.values());
		
		if(glint == true) ItemRegistry.glint(meta);
		if(model > 0) meta.setCustomModelData(model);
		
		List<Content> name = new ArrayList<>(this.name);
		name.replaceAll(c -> c.modified(Variables.with("percent", percent)));
		if(name.size() > 0) meta.setDisplayName(name.remove(0).text());
		
		IOrder order = Settings.settings.order_dust.oderer();
		
		order.named(name);
		
		order.submit("INFO", () -> info);
		
		meta.setLore(order.build());

		PersistentDataContainer data = meta.getPersistentDataContainer();
		data.set(Keys.dust(), PersistentDataType.STRING, dust.key());
		data.set(Keys.percent(), PersistentDataType.INTEGER, percent);
		data.set(Keys.random(), PersistentDataType.INTEGER, Utility.random());
		
		item.setItemMeta(meta);
		return item;
	}

	@Override
	public void update(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		PersistentDataContainer data = meta.getPersistentDataContainer();
		int percent = data.getOrDefault(Keys.percent(), PersistentDataType.INTEGER, 0);
		
		ItemStack copy = item(percent);
		item.setItemMeta(copy.getItemMeta());
	}

}

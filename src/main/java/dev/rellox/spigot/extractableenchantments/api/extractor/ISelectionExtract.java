package main.java.dev.rellox.spigot.extractableenchantments.api.extractor;

import java.util.List;

import org.bukkit.inventory.Inventory;

import main.java.dev.rellox.spigot.extractableenchantments.api.item.enchantment.ILevelledEnchantment;

public interface ISelectionExtract {
	
	Inventory inventory();
	
	IExtractor extractor();
	
	List<ILevelledEnchantment> enchantments();
	
	void update();

}

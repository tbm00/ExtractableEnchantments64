package main.java.dev.rellox.spigot.extractableenchantments.api.item;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import main.java.dev.rellox.spigot.extractableenchantments.text.content.Content;

public interface IItem {
	
	Material material();
	
	List<Content> name();
	
	List<Content> info();
	
	boolean glint();
	
	int model();
	
	boolean match(ItemStack item);
	
}

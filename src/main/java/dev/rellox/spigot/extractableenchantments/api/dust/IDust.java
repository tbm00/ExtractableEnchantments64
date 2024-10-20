package main.java.dev.rellox.spigot.extractableenchantments.api.dust;

import org.bukkit.inventory.ItemStack;

import main.java.dev.rellox.spigot.extractableenchantments.api.item.IDustItem;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.recipe.IRecipe;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.recipe.IRecipeObject;

public interface IDust extends IRecipeObject {
	
	String key();
	
	/**
	 * @return Dust item
	 */
	
	IDustItem item();
	
	/**
	 * @return Dust applicable options
	 */
	
	IApplicable applicable();
	
	IRecipe recipe();
	
	/**
	 * @return Dust percentage limit
	 */
	
	int limit();
	
	/**
	 * @return Crafted item percent
	 */
	
	int percent();
	
	@Override
	default ItemStack result() {
		return item().constant();
	}
	
	@Override
	default String prefix() {
		return "dust_";
	}

}

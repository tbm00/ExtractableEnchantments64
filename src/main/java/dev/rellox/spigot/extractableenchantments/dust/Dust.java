package main.java.dev.rellox.spigot.extractableenchantments.dust;

import main.java.dev.rellox.spigot.extractableenchantments.api.dust.IApplicable;
import main.java.dev.rellox.spigot.extractableenchantments.api.dust.IDust;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.IDustItem;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.recipe.IRecipe;

public class Dust implements IDust {
	
	private final String key;
	private final IDustItem item;
	private final IApplicable applicable;
	private final IRecipe recipe;
	private final int limit;
	private final int percent;
	
	public Dust(String key, IDustItem item, IApplicable applicable, IRecipe recipe, int limit, int percent) {
		this.key = key;
		this.item = item;
		this.applicable = applicable;
		this.recipe = recipe;
		this.limit = limit;
		this.percent = percent;
	}

	@Override
	public String key() {
		return key;
	}

	@Override
	public IDustItem item() {
		return item;
	}

	@Override
	public IApplicable applicable() {
		return applicable;
	}

	@Override
	public IRecipe recipe() {
		return recipe;
	}

	@Override
	public int limit() {
		return limit;
	}
	
	@Override
	public int percent() {
		return percent;
	}

}

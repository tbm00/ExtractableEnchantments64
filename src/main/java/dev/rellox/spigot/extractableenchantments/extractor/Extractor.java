package main.java.dev.rellox.spigot.extractableenchantments.extractor;

import java.util.List;

import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.IChanceOverride;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.IExtractPrice;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.IExtractor;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.IExtractorChance;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.constraint.IConstraint;
import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract.IExtract;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.IExtractorItem;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.recipe.IRecipe;

public class Extractor implements IExtractor {
	
	private final String key;
	
	private final IExtractorItem item;
	private final IExtractorChance chance;
	private final boolean clearing;
	private final IChanceOverride override;
	private final IExtractPrice price;
	private final IExtract extract;
	private final List<IConstraint> constraints;
	private final IRecipe recipe;
	private final boolean stackable;
	
	public Extractor(String key, IExtractorItem item, IExtractorChance chance,
			boolean clearing, IChanceOverride override, IExtract extract,
			IExtractPrice price, List<IConstraint> constraints,
			IRecipe recipe, boolean stackable) {
		this.key = key;
		
		this.item = item;
		this.chance = chance;
		this.clearing = clearing;
		this.override = override;
		this.price = price;
		this.extract = extract;
		this.constraints = constraints;
		this.recipe = recipe;
		this.stackable = stackable;
	}

	@Override
	public String key() {
		return key;
	}

	@Override
	public IExtractorItem item() {
		return item;
	}

	@Override
	public IExtractorChance chance() {
		return chance;
	}
	
	@Override
	public boolean clearing() {
		return clearing;
	}

	@Override
	public IChanceOverride override() {
		return override;
	}
	
	@Override
	public IExtractPrice price() {
		return price;
	}
	
	@Override
	public IExtract extract() {
		return extract;
	}
	
	@Override
	public List<IConstraint> constraints() {
		return constraints;
	}

	@Override
	public IRecipe recipe() {
		return recipe;
	}

	@Override
	public boolean stackable() {
		return stackable;
	}


}

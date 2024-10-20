package main.java.dev.rellox.spigot.extractableenchantments.extractor;

import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.IExtractorChance;

public record ExtractorChance(boolean enabled, boolean destroy, int minimum, int maximum) implements IExtractorChance {

	public ExtractorChance(boolean destroy, int minimum, int maximum) {
		this(true, destroy, minimum, maximum);
	}

}
package main.java.dev.rellox.spigot.extractableenchantments.extractor;

import main.java.dev.rellox.spigot.extractableenchantments.api.extractor.IExtractPrice;
import main.java.dev.rellox.spigot.extractableenchantments.api.price.IPrice;

public record ExtractPrice(boolean enabled, IPrice price) implements IExtractPrice {
	public ExtractPrice(IPrice price) {
		this(true, price);
	}
}
package main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract;

import java.util.Set;

import main.java.dev.rellox.spigot.extractableenchantments.api.item.enchantment.ILevelledEnchantment;

public interface IAccepted {
	
	Set<IIgnoredEnchantment> ignored();
	
	boolean invert();
	
	default boolean accepted(ILevelledEnchantment enchantment) {
		IIgnoredEnchantment ignored = ignored().stream()
				.filter(i -> i.enchantment().equals(enchantment.key()))
				.findFirst()
				.orElse(null);
		if(ignored == null) return true;
		return ignored.ignore(enchantment.level()) == invert();
	}

}

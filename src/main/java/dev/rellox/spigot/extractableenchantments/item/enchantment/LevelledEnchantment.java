package main.java.dev.rellox.spigot.extractableenchantments.item.enchantment;

import main.java.dev.rellox.spigot.extractableenchantments.api.item.enchantment.IEnchantment;
import main.java.dev.rellox.spigot.extractableenchantments.api.item.enchantment.ILevelledEnchantment;

public record LevelledEnchantment(IEnchantment enchantment, int level) implements ILevelledEnchantment {

	@Override
	public int hashCode() {
		return enchantment.key().hashCode();
	}

}

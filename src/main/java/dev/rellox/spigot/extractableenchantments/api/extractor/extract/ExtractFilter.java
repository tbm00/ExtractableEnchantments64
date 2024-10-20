package main.java.dev.rellox.spigot.extractableenchantments.api.extractor.extract;

import main.java.dev.rellox.spigot.extractableenchantments.api.item.enchantment.IEnchantment;

public enum ExtractFilter {
	ALL {
		@Override
		public boolean accepts(IEnchantment enchantment) {
			return true;
		}
	},
	MINECRAFT {
		@Override
		public boolean accepts(IEnchantment enchantment) {
			return enchantment.minecraft();
		}
	},
	CUSTOM {
		@Override
		public boolean accepts(IEnchantment enchantment) {
			return !enchantment.minecraft();
		}
	};
	
	public abstract boolean accepts(IEnchantment enchantment);
}

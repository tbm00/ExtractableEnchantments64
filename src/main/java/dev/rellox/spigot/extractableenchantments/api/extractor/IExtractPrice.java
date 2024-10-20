package main.java.dev.rellox.spigot.extractableenchantments.api.extractor;

import main.java.dev.rellox.spigot.extractableenchantments.api.price.IPrice;

public interface IExtractPrice {
	
	static IExtractPrice empty = new IExtractPrice() {
		@Override
		public IPrice price() {return null;}
		@Override
		public boolean enabled() {return false;}
	};
	
	boolean enabled();
	
	IPrice price();

}

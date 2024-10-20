package main.java.dev.rellox.spigot.extractableenchantments.api.price;

public enum PriceType {
	
	EXPERIENCE_POINTS,
	EXPERIENCE_LEVELS,
	MATERIALS,
	ECONOMY;
	
	public String key() {
		return name().replace('_', '-').toLowerCase();
	}

}

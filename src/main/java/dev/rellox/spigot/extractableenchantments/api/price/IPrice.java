package main.java.dev.rellox.spigot.extractableenchantments.api.price;

import org.bukkit.entity.Player;

import main.java.dev.rellox.spigot.extractableenchantments.text.content.Content;

public interface IPrice {
	
	PriceType type();
	
	int value();
	
	boolean has(Player player);
	
	void remove(Player player);
	
	int balance(Player player);
	
	Content insufficient();
	
	Content text();

}

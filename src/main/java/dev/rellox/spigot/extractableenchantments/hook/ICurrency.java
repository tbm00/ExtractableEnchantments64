package main.java.dev.rellox.spigot.extractableenchantments.hook;

import org.bukkit.entity.Player;

public interface ICurrency {
	
	double get(Player player);
	
	void remove(Player player, double value);

}

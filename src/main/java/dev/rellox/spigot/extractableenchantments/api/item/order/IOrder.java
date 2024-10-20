package main.java.dev.rellox.spigot.extractableenchantments.api.item.order;

import java.util.List;
import java.util.function.Supplier;

import main.java.dev.rellox.spigot.extractableenchantments.text.content.Content;

public interface IOrder {
	
	void submit(String type, Supplier<List<Content>> supplier);
	
	List<String> build();
	
	void named(List<Content> overflow);

}

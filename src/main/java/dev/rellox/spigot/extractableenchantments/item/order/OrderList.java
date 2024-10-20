package main.java.dev.rellox.spigot.extractableenchantments.item.order;

import java.util.List;

import main.java.dev.rellox.spigot.extractableenchantments.api.item.order.IOrder;

public record OrderList(List<String> keys) {
	
	public OrderList {
		keys.removeIf(e -> e.length() > 1 && e.charAt(e.length() - 1) == '!');
		keys.add(0, "NAMED");
	}
	
	public IOrder oderer() {
		return new Order(this);
	}

}

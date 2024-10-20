package main.java.dev.rellox.spigot.extractableenchantments.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.dev.rellox.spigot.extractableenchantments.configuration.Configuration.CF;
import main.java.dev.rellox.spigot.extractableenchantments.text.content.Content;
import main.java.dev.rellox.spigot.extractableenchantments.text.content.Content.Variables;

public interface Language {
	
	public static final String prefix_chance = "�#�0�#";

	public static Content get(String key) {
		List<Content> list = CF.l.get(key);
		return list == null ? Content.empty() : list.get(0);
	}

	public static Content get(String key, String k, Object o) {
		List<Content> list = CF.l.get(key);
		if(list == null) return Content.empty();
		return list.get(0).modified(Variables.with(k, o));
	}

	public static Content get(String key, Object... vs) {
		List<Content> list = CF.l.get(key);
		if(list == null) return Content.empty();
		return list.get(0).modified(Variables.with(vs));
	}

	public static List<Content> list(String key) {
		List<Content> list = CF.l.get(key);
		return list == null ? empty() : new ArrayList<>(list);
	}

	public static List<Content> list(String key, String k, Object o) {
		List<Content> list = CF.l.get(key);
		if(list == null) return empty(); 
		Variables v = Variables.with(k, o);
		return list.stream()
				.map(c -> c.modified(v))
				.collect(Collectors.toList());
	}

	public static List<Content> list(String key, Object... vs) {
		List<Content> list = CF.l.get(key);
		if(list == null) return empty(); 
		Variables v = Variables.with(vs);
		return list.stream()
				.map(c -> c.modified(v))
				.collect(Collectors.toList());
	}
	
	public static Content or(String key, Content text) {
		List<Content> list = CF.l.get(key);
		return list == null ? text : list.get(0);
	}
	
	private static List<Content> empty() {
		return new ArrayList<>();
	}
	
}

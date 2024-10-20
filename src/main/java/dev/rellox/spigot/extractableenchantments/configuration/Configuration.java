package main.java.dev.rellox.spigot.extractableenchantments.configuration;

import main.java.dev.rellox.spigot.extractableenchantments.configuration.file.LanguageFile;
import main.java.dev.rellox.spigot.extractableenchantments.configuration.file.SettingsFile;

public final class Configuration {
	
	public static void initialize() {
		CF.s.load();
		CF.l.load();
		
		CF.s.free();
		CF.l.free();
	}
	
	public static final class CF {
		
		public static final SettingsFile s = new SettingsFile();
		public static final LanguageFile l = new LanguageFile();
		
	}

}

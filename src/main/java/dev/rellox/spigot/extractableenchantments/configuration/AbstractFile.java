package main.java.dev.rellox.spigot.extractableenchantments.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import main.java.dev.rellox.spigot.extractableenchantments.ExtractableEnchantments;
import main.java.dev.rellox.spigot.extractableenchantments.api.configuration.IFile;
import main.java.dev.rellox.spigot.extractableenchantments.utility.reflect.Reflect.RF;

public abstract class AbstractFile implements IFile {
	
	private final File parent;
	private final String name;
	
	private File f;
	protected FileConfiguration file;
	
	private boolean first;
	
	public AbstractFile(String name) {
		this(ExtractableEnchantments.instance().getDataFolder(), name);
	}
	
	public AbstractFile(File parent, String name) {
		this.parent = parent;
		this.name = name;
	}
	
	@Override
	public final void create() {
		f = new File(parent, name + ".yml");
		if(f.getParentFile().exists() == false) f.getParentFile().mkdirs();
		if(f.exists() == false) {
			try {
				first = true;
				f.createNewFile();
			} catch(IOException e) {
				RF.debug(e);
			}
		}
		file = YamlConfiguration.loadConfiguration(f);
		file.options().copyDefaults(true);
	}
	
	public void load() {
		create();
		initialize();
	}
	
	protected abstract void initialize();

	@Override
	public final FileConfiguration file() {
		return file;
	}

	@Override
	public final String name() {
		return name;
	}
	
	@Override
	public final boolean isNew() {
		return first;
	}

	@Override
	public final void save() {
		try {
			file.save(f);
		} catch(IOException e) {
			RF.debug(e);
		}
	}
	
	@Override
	public void free() {
		f = null; file = null;
	}

}

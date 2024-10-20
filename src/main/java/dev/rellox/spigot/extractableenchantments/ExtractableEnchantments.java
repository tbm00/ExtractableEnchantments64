package main.java.dev.rellox.spigot.extractableenchantments;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import main.java.dev.rellox.spigot.extractableenchantments.commands.CommandRegistry;
import main.java.dev.rellox.spigot.extractableenchantments.configuration.Configuration;
import main.java.dev.rellox.spigot.extractableenchantments.event.EventRegistry;
import main.java.dev.rellox.spigot.extractableenchantments.hook.HookRegistry;
import main.java.dev.rellox.spigot.extractableenchantments.item.enchantment.EnchantmentRegistry;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Keys;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Metrics;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Utility;
import main.java.dev.rellox.spigot.extractableenchantments.utility.Version;

public class ExtractableEnchantments extends JavaPlugin {
	
	public static final double PLUGIN_VERSION = 11.6;
    
	private static Plugin plugin;
	
	private boolean loaded;
	
    @Override
    public void onLoad() {
		plugin = this;
		loaded = Version.version != null;
    }
	
	@Override
	public void onEnable() {
		if(loaded == true) {
			Utility.check(73954, s -> {
				if(Utility.isDouble(s) == false) return; 
				double v = Double.parseDouble(s);
				if(v <= PLUGIN_VERSION) return;
				Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[EE] " + ChatColor.YELLOW + "A newer version is available! "
						+ ChatColor.GOLD + "To download visit: " + "https://www.spigotmc.org/resources/extractable-enchantments.73954/");
				new UpdateAvailable();
			});
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "Extractable Enchantments " + 
					ChatColor.AQUA + "v" + PLUGIN_VERSION + ChatColor.GREEN + " enabled!");
			
			Keys.initialize();
			EnchantmentRegistry.initialize();
			HookRegistry.initialize();
			Configuration.initialize();
			EventRegistry.initialize();
			
			initializeMetrics();
		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[EE] "
					+ ChatColor.RED + "Unable to load, invalid server version!");
			Bukkit.getPluginManager().disablePlugin(this);
		}
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "Extractable Enchantments " + 
				ChatColor.AQUA + "v" + PLUGIN_VERSION + ChatColor.GOLD + " disabled!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		CommandRegistry.onCommand(sender, command, args);
		return super.onCommand(sender, command, label, args);
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return CommandRegistry.onTabComplete(sender, command, args);
	}
	
	public static Plugin instance() {
		return plugin;
	}
	
	private void initializeMetrics() {
		new Metrics(this, 8524);
	}
	
	private static class UpdateAvailable implements Listener {
		
		public UpdateAvailable() {
			Bukkit.getPluginManager().registerEvents(this, plugin);
		}

		@EventHandler
		private void onJoin(PlayerJoinEvent event) {
			Player player = event.getPlayer();
			if(player.isOp() == false) return; 
			player.sendMessage(ChatColor.DARK_AQUA + "[EE] " + 
					ChatColor.YELLOW + "A newer version is available! " + ChatColor.GOLD + "To download visit: " + 
					"https://www.spigotmc.org/resources/extractable-enchantments.73954/");
		}

	}

}

package com.gmail.tetrasheep;


import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import command.CommandBenchmark;
import command.CommandFruit;
import command.CommandJuicy;
import command.CommandSetBenchmark;
import command.CommandStyle;
import listeners.PlayerListener;
import listeners.SheepListener;
import net.md_5.bungee.api.ChatColor;

public class FruiTy extends JavaPlugin implements Listener {
	
	
	FileConfiguration config = getConfig();
	
	private PluginManager pluginManager;
	
	private static ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	private Logger logger = Logger.getLogger("Minecraft"); {
		
	}
	
	public void onEnable() {
		console.sendMessage("§a§l§n§oFruiTy §ahas finished loading !");
		console.sendMessage("§a§l§n§oFruiTy++ §bis active !");
		getCommand("fruit").setExecutor(new CommandFruit());
		getCommand("juicy").setExecutor(new CommandJuicy());
		getCommand("setbenchmark").setExecutor(new CommandSetBenchmark(this));
		getCommand("benchmark").setExecutor(new CommandBenchmark(this));
		logger.info("Thanks for using FruiTy++! Developped by TetraSheep.");
		getCommand("style").setExecutor(new CommandStyle());
		
		pluginManager = Bukkit.getServer().getPluginManager();
		pluginManager.registerEvents(new SheepListener(), this);
		pluginManager.registerEvents(new PlayerListener(), this);
		
	    config.addDefault("WelcolmeMessage", true);
	    config.options().copyDefaults(true);
	    saveConfig();

	   // Enable our class to check for new players using onPlayerJoin()
	   getServer().getPluginManager().registerEvents(this, this);
	}

	// This method checks for incoming players and sends them a message
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
	    Player player = event.getPlayer();

	    if (config.getBoolean("WelcolmeMessage")) {
	        player.sendMessage(ChatColor.GOLD + "Welcolme to this server !");
	    } else {
	        player.sendMessage("");
	    }
	}

		
	
	
	public void onDisable() {
		console.sendMessage("§a§l§n§oFruiTy++ §cis disabled !");
		console.sendMessage("§6§l§n§oCODED BY TETRASHEEP.");
		
	}
	
	public void onLoad() {
		console.sendMessage("§a§l§n§oFruiTy §ais loading...");
		console.sendMessage("§a§l§n§o25%");
		console.sendMessage("§a§l§n§o50%");
		console.sendMessage("§a§l§n§o75%");
		console.sendMessage("§a§l§n§o100%");
		
	}
	
	public static ConsoleCommandSender getConsole() {
		return console;
	}
	
	{
	

	
	
	}
	
}


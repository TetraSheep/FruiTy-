package command;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.tetrasheep.FruiTy;

import net.md_5.bungee.api.ChatColor;

public class CommandBenchmark implements CommandExecutor{
	
	private FruiTy fruity;
	public CommandBenchmark(FruiTy fruity) {
		this.fruity = fruity;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(label.equalsIgnoreCase("benchmark")) {
			if(args.length == 0) {
				
				if(sender instanceof Player) {
					final Player player = (Player)sender;
					
                    final File file = new File(fruity.getDataFolder(), "data/benchmarks.yml");
				    final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
				    final String key = "players." + player.getUniqueId();
				    final ConfigurationSection configurationSection = configuration.getConfigurationSection(key);
				    
				    if (configurationSection == null) {
				    	 player.sendMessage(ChatColor.YELLOW + "[FruiTy++] You don't have any benchmark yet ! Use /setbenchmark to get one !");
				    } else {
				    	
				    	final World world = Bukkit.getWorld(configurationSection.getString("world"));
				    	final double x = configurationSection.getDouble("x");
				    	final double y = configurationSection.getDouble("y");
				    	final double z = configurationSection.getDouble("z");
				    	final float yaw = (float) configurationSection.getDouble("yaw");
				    	final float pitch = (float) configurationSection.getDouble("pitch");
				    	
				    	final Location benchmarklocation = new Location(world, x, y, z, yaw, pitch);
				    	
				    	player.teleport(benchmarklocation);
				    	player.sendMessage(ChatColor.YELLOW + "[FruiTy++] Teleporting to your benchmark..." );
				    }
				    
					
					
				}
				return true;
			}
		}
		
		return false;
	}

}

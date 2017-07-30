package command;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.tetrasheep.FruiTy;

public class CommandSetBenchmark implements CommandExecutor{
	
	private FruiTy fruity;
	
	
	public CommandSetBenchmark(FruiTy fruity) {
		this.fruity = fruity;
	
}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if(label.equalsIgnoreCase("setbenchmark")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
				    final Player player = (Player)sender;
				    final UUID uuid = player.getUniqueId();
				    final Location location = player.getLocation();
				    player.sendMessage(ChatColor.YELLOW + "[FruiTy++] Your benchmark was created with success !");
				    
				    final File file = new File(fruity.getDataFolder(), "data/benchmarks.yml");
				    
				    final YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
				    
				    final String key = "players." + uuid.toString();
				    
				    
				    configuration.set(key + ".world", location.getWorld().getName());
				    configuration.set(key + ".x", location.getX());
				    configuration.set(key + ".y", location.getY());
				    configuration.set(key + ".z", location.getZ());
				    configuration.set(key + ".yaw", location.getYaw());
				    configuration.set(key + ".pitch", location.getPitch());
				    
				    try {
						configuration.save(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				return true;
			}
		}
		
		return false;
	}

		{}
		return false;
		
	}}

package command;

import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;


import net.md_5.bungee.api.ChatColor;

public class CommandStyle implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	@Override
	
	public boolean onCommand (CommandSender commandSender, Command command, String label, String[] args ){
		
		if(label.equals("style")) {
			if(args.length == 0) {
				if(commandSender instanceof Player) {
					final Player player = (Player)commandSender;
					
					final World world = player.getWorld();
					player.setAllowFlight(true);
					world.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 50);
					world.playEffect(player.getLocation(), Effect.ITEM_BREAK, 10);
					world.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 40);
					commandSender.sendMessage(ChatColor.ITALIC + "[FruiTy++] Command effectued !");
					
         return true;
				}
				
					
				}
				
			} else {

				commandSender.sendMessage(ChatColor.BOLD.AQUA + "[FruiTy++] The command 'style' cannot contain more arguments ! !");
			}
			
			
		return false;
	}

}

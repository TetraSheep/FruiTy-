package command;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandFruit implements CommandExecutor{
	
	@Override
	
	public boolean onCommand (CommandSender commandSender, Command command, String label, String[] args ){
		
		if(label.equals("fruit")) {
			if(args.length == 0) {
				if(commandSender instanceof Player) {
					final Player player = (Player)commandSender;
					
					final World world = player.getWorld();
					player.getGameMode();
					player.getAllowFlight();
					world.createExplosion(player.getLocation(), 10);
					commandSender.sendMessage(ChatColor.BOLD.RED + "[FruiTy++] BOOM !");
				}
				
			} else {
				
				commandSender.sendMessage(ChatColor.GREEN.BOLD + "[FruiTy++] The command 'fruit' cannot contain more arguments !");
			}
			
			
			return true;
		}
		command.setPermissionMessage("§a§lTu n'as pas les permissions pour utiliser cette commande");
		return false;
	}

}

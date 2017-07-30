package command;

import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandJuicy implements CommandExecutor{
	
	@Override
	
	public boolean onCommand (CommandSender commandSender, Command command, String label, String[] args ){
		
		if(label.equals("juicy")) {
			if(args.length == 0) {
				if(commandSender instanceof Player) {
					final Player player = (Player)commandSender;
					
					final World world = player.getWorld();
					player.getGameMode();
					player.getAllowFlight();
					world.generateTree(player.getLocation(),TreeType.RED_MUSHROOM);
					commandSender.sendMessage(ChatColor.ITALIC.GREEN + "[FruiTy++] You just generated a beautiful mushroom !");
				}
				
			} else {
				
				commandSender.sendMessage(ChatColor.BOLD.AQUA + "[FruiTy++] The command 'juicy' cannot contain more arguments !.");
			}
			
			
			return true;
		}
		command.setPermissionMessage("§a§lTu n'as pas les permissions pour utiliser cette commande");
		return false;
	}

}

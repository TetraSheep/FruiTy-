package listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;


/*
 * AUTHOR KARIM
 */

public class PlayerListener implements Listener{
	
	@EventHandler (priority = EventPriority.HIGHEST)
	
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "A player joined the game.");
		
		final Player player = event.getPlayer();
		player.setCustomName(ChatColor.LIGHT_PURPLE + "TETRASHEEP");
		
	}
		
		

				 

}
	
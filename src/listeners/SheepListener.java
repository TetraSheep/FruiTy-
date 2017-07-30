package listeners;

import java.util.Random;

import org.bukkit.DyeColor;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SheepRegrowWoolEvent;

public class SheepListener implements Listener{
	
	@EventHandler (priority = EventPriority.NORMAL)
	
	public void onSheepRegainWool(SheepRegrowWoolEvent event) {
		
		final Sheep sheep = event.getEntity();
		DyeColor DyeColor_generatedColor = randomizeColor();
		sheep.setColor(DyeColor_generatedColor);
		
	}
		
		
	  private DyeColor randomizeColor() {
		  
		  final Random random = new Random();
		  
		  final int color = random.nextInt(16);
		  
		  
		  return DyeColor.values() [color];
				 

}
	}

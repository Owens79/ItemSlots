package at.Owens79.ItemSlots;

import java.util.Random;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SlotListener implements Listener {

	ItemSlots plugin;
	
	Random ran;
	
	Display display;
	
	SlotListener(ItemSlots itemSlots, Random ran) {
		
		this.plugin = itemSlots;
		
		this.ran = ran;
		
		this.display = new Display(itemSlots);
	}

	@EventHandler
	public void construct (BlockPlaceEvent event) {
		
		Build build = new Build(plugin, event);
		
		if(build.isLeverPlaced() && build.canBuild()) {

			if(build.PickMachine(build.getFacing())){
				
				//display.toPlayer(event.getPlayer(), String.valueOf(build.PickMachine(build.getFacing())));
				
				this.display.buildMessage(event.getPlayer());
				
			}//if machine is built
			
		}//Lamp is placed AND player can build
		
	}//construct (BlockPlaceEvent event)
	
	@EventHandler
	public void betting(final PlayerInteractEvent event) {
		
		Play play = new Play(plugin, event, this.ran);
		
		if( play.didActivateLever() && play.canUse()) {
			
			if(play.PickMachine(play.getFacing())) {
				
				play.runMac(ran.nextInt(100));
			}
		}
		
	}
}//SlotsListener class 

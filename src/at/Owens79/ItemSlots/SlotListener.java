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

		if(build.isLeverPlaced()) {

			//this.display.toPlayer(event.getPlayer(), "Lever Placed");
			
			//this.display.toPlayer(event.getPlayer(), String.valueOf(build.canBuild()));
			
			if (build.canBuild()) {
				
				if(build.PickMachine(build.getFacing())){

					//display.toPlayer(event.getPlayer(), String.valueOf(build.PickMachine(build.getFacing())));

					this.display.buildMessage(event.getPlayer());

				}//if machine is built

			}

		}//Lamp is placed

	}//construct (BlockPlaceEvent event)

	@EventHandler
	public void betting(final PlayerInteractEvent event) {

		Play play = new Play(plugin, event, this.ran);

		if( play.didActivateLever() && play.canUse()) {
			
			//this.display.toPlayer(event.getPlayer(), String.valueOf(play.canUse()));

			//this.display.toPlayer(event.getPlayer(), play.getFacing());
			
			if(play.PickMachine(play.getFacing())) {

				play.runMac(ran.nextInt(100));
			}
		}

	}
}//SlotsListener class 

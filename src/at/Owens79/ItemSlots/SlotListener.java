package at.Owens79.ItemSlots;

import java.util.Random;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import at.Owens79.ItemSlots.Parts.LampControl;

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

			if (build.canBuild()) {

				build.PickMachine(build.getFacing());
				
				if(build.isMachine()){

					this.display.buildMessage(event.getPlayer());

				}//if machine is built

			}//can build

		}//Lever is placed

		else {
			FakeMachines fake = new FakeMachines(event, plugin);
			
			if(fake.lampMachine()) {
				
				event.setCancelled(true);
			}
		}
		
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

	@EventHandler
	public void noPiston (BlockPlaceEvent event) {
		
		FakeMachines fake = new FakeMachines(event, plugin);
		LampControl lampCon = new LampControl(plugin);
		
		if(lampCon.isLamp(event.getBlockPlaced())) {
			
			if (fake.isPistonMachine(event)) {
				
				event.setCancelled(true);
			}
		}
		
		
		
	}
	
}//SlotsListener class 

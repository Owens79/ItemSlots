package at.Owens79.ItemSlots;

import java.util.Random;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import at.Owens79.ItemSlots.Parts.DispenserControl;
import at.Owens79.ItemSlots.Parts.LampControl;
import at.Owens79.ItemSlots.Parts.SignControl;

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
			
			else {
				
				event.setCancelled(true);
			}

		}//Lever is placed

		else {

			FakeMachines fake = new FakeMachines(event, plugin);
			LampControl lampCon = new LampControl(plugin);


			if (lampCon.isLamp(event.getBlockPlaced())) {

				if(fake.isLampMachine()){

					event.setCancelled(true);
				}

			}

			else {

				SignControl sgnCon = new SignControl(plugin);

				if(sgnCon.isWallSign(event.getBlockPlaced())) {

					if(fake.isSignMachine(build.getFacing())){

						event.setCancelled(true);

					}

				}

				else {

					DispenserControl disCon = new DispenserControl(plugin);

					if(disCon.isDispenser(event.getBlockPlaced())) {

						if(fake.isDispenserMachine()){

							event.setCancelled(true);
						}
					}
				}

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
	public void breaking(final BlockBreakEvent event) {

		Remove rem = new Remove(event, plugin);
		display = new Display(plugin);

		if(rem.isLeverBroken()) {

			if(rem.canBreak()) {

				rem.PickMachine(rem.getFacing());

				if (rem.isMachine()) {

					display.destroyMessage(event.getPlayer());
				}
			}// can break

			else { 

				event.setCancelled(true);
			}

		}//broke lever

		else {



			if (rem.isLampBroken()) {

				if (rem.isLampMachine()) {

					event.setCancelled(true);
				}

			}//lamp broken

			else if (rem.isSignBroken()) {

				if (rem.isSignMachine(rem.getFacing())) {

					event.setCancelled(true);
				}


			}//sign broke

			else if (rem.isDispenserBroken()) {

				if (rem.isDispenserMachine()) {

					event.setCancelled(true);
				}

			}//dispenser broken

		}//not lever broke

	}//Block break

}//SlotsListener class 

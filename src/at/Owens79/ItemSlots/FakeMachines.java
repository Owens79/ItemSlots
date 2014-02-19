package at.Owens79.ItemSlots;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import at.Owens79.ItemSlots.Locations.*;
import at.Owens79.ItemSlots.Parts.*;

public class FakeMachines {

	Boolean bool;

	ItemSlots plugin;
	BlockPlaceEvent event;
	Display display;

	Local local = null;
	North north = null;
	South south = null;
	East east = null;
	West west = null;


	LampControl lampCon;
	SignControl signCon;
	DispenserControl disCon;
	LeverControl levCon;




	FakeMachines(BlockPlaceEvent e, ItemSlots plug) {

		this.plugin = plug;
		this.event = e;
	}

	public void signMachine(String dir) {


	}

	public boolean lampMachine() {

		lampCon = new LampControl(plugin);
		signCon = new SignControl(plugin);
		levCon = new LeverControl(plugin);
		disCon = new DispenserControl(plugin);

		local = new Local(event);
		north = new North(event);
		south = new South(event);
		east = new East(event);
		west = new West(event);

		Block dis = local.getRelativeBlock(local.getLmpDis());

		if(this.lampCon.isLamp(event.getBlock())&& disCon.isDispenser(dis)) {

			Block sign = null;
			Block lever = null;


			sign = north.getRelativeBlock(north.getLmpSgn());
			lever = north.getRelativeBlock(north.getLmpLev());

			if(signCon.isWallSign(sign)&& levCon.isLever(lever)) {

				signCon.setSign(sign);
				bool = signCon.isMarkerValid();
			}

			else {

				sign = south.getRelativeBlock(south.getLmpSgn());
				lever = south.getRelativeBlock(south.getLmpLev());

				if(signCon.isWallSign(sign)&& levCon.isLever(lever)) {

					signCon.setSign(sign);
					bool = signCon.isMarkerValid();	
				}

				else {

					sign = east.getRelativeBlock(east.getLmpSgn());
					lever = east.getRelativeBlock(east.getLmpLev());

					if(signCon.isWallSign(sign)&& levCon.isLever(lever)) {

						signCon.setSign(sign);
						bool = signCon.isMarkerValid();
					}

					else {

						sign = west.getRelativeBlock(west.getLmpSgn());
						lever = west.getRelativeBlock(west.getLmpLev());

						if(signCon.isWallSign(sign)&& levCon.isLever(lever)) {

							signCon.setSign(sign);
							bool = signCon.isMarkerValid();

						}

						else {bool = false;}
					}
				}
			}

		}// if lamp is placed	

		else {bool = false;}

		return bool;
	}//lampMachine

	public boolean isPistonMachine(BlockPlaceEvent event) {

		local = new Local(event);
		signCon = new SignControl(plugin);

		Block sign = local.getRelativeBlock(local.getFakeLmpSgn());

		if(signCon.isWallSign(sign)) {

			signCon.setSign(sign);

			return signCon.isMarkerValid();
		}

		else {return false;}


	}//lampMachine

}//class

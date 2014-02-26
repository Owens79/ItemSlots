package at.Owens79.ItemSlots;

import org.bukkit.block.Block;
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
	
	private boolean isSignMac(Block la1, Block lev, Block dis) {
		
		this.lampCon = new LampControl(plugin);
		this.levCon = new LeverControl(plugin);
		this.disCon = new DispenserControl(plugin);
		
		return levCon.isLever(lev)&& disCon.isDispenser(dis) && lampCon.isLamp(la1);
		
	}

	public boolean isSignMachine(String dir) {

		Block lamp = null;
		Block dis = null;
		Block lev = null;
		
		switch(dir.toUpperCase()) {
		
		case "NORTH" :

			north = new North(event);
			
			lamp = north.getRelativeBlock(north.getSgnLmp());
								
			dis = north.getRelativeBlock(north.getSgnDrp());
			
			lev = north.getRelativeBlock(north.getSgnLev());

			break;

		case "SOUTH" : 

			south = new South(event);

			lamp = south.getRelativeBlock(south.getSgnLmp());
					
			dis = south.getRelativeBlock(south.getSgnDrp());
			
			lev = south.getRelativeBlock(south.getSgnLev());

			break;


		case "EAST" :

			east = new East(event);
			
			lamp = east.getRelativeBlock(east.getSgnLmp());
			
			dis = east.getRelativeBlock(east.getSgnDrp());
			
			lev = east.getRelativeBlock(east.getSgnLev());
		
			break;

		case "WEST" :

			west = new West(event);

			lamp = west.getRelativeBlock(west.getSgnLmp());
			
			dis = west.getRelativeBlock(west.getSgnDrp());
			
			lev = west.getRelativeBlock(west.getSgnLev());

			break;

		default:
		
		}
		bool = this.isSignMac(lamp, lev, dis);
		
		return this.bool;
	}
	

	public boolean isLampMachine() {

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

	
	public boolean isDispenserMachine() {
		
		levCon = new LeverControl(plugin);
		signCon = new SignControl(plugin);

		local = new Local(event);
		north = new North(event);
		south = new South(event);
		east = new East(event);
		west = new West(event);
		
		

			Block sign = null;
			Block lever = null;


			sign = north.getRelativeBlock(north.getDrpSgn());
			lever = north.getRelativeBlock(north.getDrpLev());

			if(signCon.isWallSign(sign)&& levCon.isLever(lever)) {

				signCon.setSign(sign);
				bool = signCon.isMarkerValid();
			}

			else {

				sign = south.getRelativeBlock(south.getDrpSgn());
				lever = south.getRelativeBlock(south.getDrpLev());

				if(signCon.isWallSign(sign)&& levCon.isLever(lever)) {

					signCon.setSign(sign);
					bool = signCon.isMarkerValid();	
				}

				else {

					sign = east.getRelativeBlock(east.getDrpSgn());
					lever = east.getRelativeBlock(east.getDrpLev());

					if(signCon.isWallSign(sign)&& levCon.isLever(lever)) {

						signCon.setSign(sign);
						bool = signCon.isMarkerValid();
					}

					else {

						sign = west.getRelativeBlock(west.getDrpSgn());
						lever = west.getRelativeBlock(west.getDrpLev());

						if(signCon.isWallSign(sign)&& levCon.isLever(lever)) {

							signCon.setSign(sign);
							bool = signCon.isMarkerValid();

						}

						else {bool = false;}
					}
				}
			}
 
		return bool;
	}
}//class

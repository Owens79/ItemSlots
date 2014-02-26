package at.Owens79.ItemSlots;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import at.Owens79.ItemSlots.Locations.*;
import at.Owens79.ItemSlots.Parts.*;


public class Remove {

	Boolean bool;
	
	ItemSlots plugin;
	BlockBreakEvent event;

	private LeverControl levCon;
	private LampControl lmpCon;
	private SignControl sgnCon;
	private DispenserControl disCon;

	Local local;
	North north;
	South south;
	East east;
	West west;

	Block sign = null;
	Block lamp = null;
	Block lever = null;
	Block disp = null;

	public Remove(BlockBreakEvent be, ItemSlots pl){

		this.event = be;
		this.plugin = pl;
	}

	/*********************************************
	 * canBreak()
	 * 
	 * @return does player have permission to break
	 *********************************************/
	public boolean canBreak() {

		return event.getPlayer().hasPermission("ItemSlots.Destroy") || event.getPlayer().isOp();

	}// can break

	public boolean isLeverBroken() {

		levCon = new LeverControl(plugin);

		return levCon.isLever(event.getBlock());
	}

	public boolean isLampBroken() {

		lmpCon = new LampControl(plugin);

		return lmpCon.isLamp(event.getBlock());
	}

	public boolean isSignBroken() {

		sgnCon = new SignControl(plugin);

		return sgnCon.isWallSign(event.getBlock());
	}

	public boolean isDispenserBroken() {

		disCon = new DispenserControl(plugin);

		return disCon.isDispenser(event.getBlock());
	}

	/****************************

	 ****************************/
	public boolean isMachine() {

		disCon = new DispenserControl(plugin);

		lmpCon = new LampControl(plugin);

		sgnCon = new SignControl(plugin);

		if (lmpCon.isLamp(lamp) && sgnCon.isWallSign(this.sign) && disCon.isDispenser(this.disp)) {

			sgnCon.setSign(sign);
			
			return sgnCon.isMarkerValid();

		}

		else {return false;}
	}

	/****************************

	 ****************************/
	public void PickMachine(String dir) {

		switch(dir.toUpperCase()) {

		case "NORTH" :

			north = new North(event);

			this.sign = north.getRelativeBlock(north.getLevSgn());

			this.lamp = north.getRelativeBlock(north.getLevLmp());

			this.disp = north.getRelativeBlock(north.getLevDrp());

			break;

		case "SOUTH" : 

			south = new South(event);

			this.sign = south.getRelativeBlock(south.getLevSgn());

			this.lamp = south.getRelativeBlock(south.getLevLmp());

			this.disp = south.getRelativeBlock(south.getLevDrp());

			break;


		case "EAST" :

			east = new East(event);

			this.sign = east.getRelativeBlock(east.getLevSgn());

			this.lamp = east.getRelativeBlock(east.getLevLmp());

			this.disp = east.getRelativeBlock(east.getLevDrp());

			break;

		case "WEST" :

			west = new West(event);

			this.sign = west.getRelativeBlock(west.getLevSgn());

			this.lamp = west.getRelativeBlock(west.getLevLmp());

			this.disp = west.getRelativeBlock(west.getLevDrp());

			break;

		default:
		}
	}

	/********************************************
	getFacing()

	Purpose gets the direction of the used block
	 ********************************************/
	public String getFacing() {

		local = new Local(event);

		return local.getFacing(event.getBlock(), event.getBlock().getType());
	}
	
	
private boolean isSignMac(Block la1, Block lev, Block dis) {
		
		this.lmpCon = new LampControl(plugin);
		this.levCon = new LeverControl(plugin);
		this.disCon = new DispenserControl(plugin);
		
		return levCon.isLever(lev)&& disCon.isDispenser(dis) && lmpCon.isLamp(la1);
		
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

		lmpCon = new LampControl(plugin);
		sgnCon = new SignControl(plugin);
		levCon = new LeverControl(plugin);
		disCon = new DispenserControl(plugin);

		local = new Local(event);
		north = new North(event);
		south = new South(event);
		east = new East(event);
		west = new West(event);

		Block dis = local.getRelativeBlock(local.getLmpDis());

		if(this.lmpCon.isLamp(event.getBlock())&& disCon.isDispenser(dis)) {

			Block sign = null;
			Block lever = null;


			sign = north.getRelativeBlock(north.getLmpSgn());
			lever = north.getRelativeBlock(north.getLmpLev());

			if(sgnCon.isWallSign(sign)&& levCon.isLever(lever)) {

				sgnCon.setSign(sign);
				bool = sgnCon.isMarkerValid();
			}

			else {

				sign = south.getRelativeBlock(south.getLmpSgn());
				lever = south.getRelativeBlock(south.getLmpLev());

				if(sgnCon.isWallSign(sign)&& levCon.isLever(lever)) {

					sgnCon.setSign(sign);
					bool = sgnCon.isMarkerValid();	
				}

				else {

					sign = east.getRelativeBlock(east.getLmpSgn());
					lever = east.getRelativeBlock(east.getLmpLev());

					if(sgnCon.isWallSign(sign)&& levCon.isLever(lever)) {

						sgnCon.setSign(sign);
						bool = sgnCon.isMarkerValid();
					}

					else {

						sign = west.getRelativeBlock(west.getLmpSgn());
						lever = west.getRelativeBlock(west.getLmpLev());

						if(sgnCon.isWallSign(sign)&& levCon.isLever(lever)) {

							sgnCon.setSign(sign);
							bool = sgnCon.isMarkerValid();

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
		sgnCon = new SignControl(plugin);

		local = new Local(event);
		north = new North(event);
		south = new South(event);
		east = new East(event);
		west = new West(event);
		
		

			Block sign = null;
			Block lever = null;


			sign = north.getRelativeBlock(north.getDrpSgn());
			lever = north.getRelativeBlock(north.getDrpLev());

			if(sgnCon.isWallSign(sign)&& levCon.isLever(lever)) {

				sgnCon.setSign(sign);
				bool = sgnCon.isMarkerValid();
			}

			else {

				sign = south.getRelativeBlock(south.getDrpSgn());
				lever = south.getRelativeBlock(south.getDrpLev());

				if(sgnCon.isWallSign(sign)&& levCon.isLever(lever)) {

					sgnCon.setSign(sign);
					bool = sgnCon.isMarkerValid();	
				}

				else {

					sign = east.getRelativeBlock(east.getDrpSgn());
					lever = east.getRelativeBlock(east.getDrpLev());

					if(sgnCon.isWallSign(sign)&& levCon.isLever(lever)) {

						sgnCon.setSign(sign);
						bool = sgnCon.isMarkerValid();
					}

					else {

						sign = west.getRelativeBlock(west.getDrpSgn());
						lever = west.getRelativeBlock(west.getDrpLev());

						if(sgnCon.isWallSign(sign)&& levCon.isLever(lever)) {

							sgnCon.setSign(sign);
							bool = sgnCon.isMarkerValid();

						}

						else {bool = false;}
					}
				}
			}
 
		return bool;
	}

}//class

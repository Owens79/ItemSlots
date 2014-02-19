package at.Owens79.ItemSlots;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import at.Owens79.ItemSlots.Locations.*;
import at.Owens79.ItemSlots.Parts.DispenserControl;
import at.Owens79.ItemSlots.Parts.LampControl;
import at.Owens79.ItemSlots.Parts.LeverControl;
import at.Owens79.ItemSlots.Parts.SignControl;

public class Build {

	private ItemSlots plugin;
	private BlockPlaceEvent event;
	private Player player;

	private North n;
	private South s;
	private East e;
	private West w;

	private Block sign;
	private Block dispenser;
	//private Block lever;
	private Block lamp;

	SignControl sgnCon;

	Local local;

	/****************************

	****************************/
	public Build(ItemSlots plugin, BlockPlaceEvent event) {

		this.event = event;

		this.player = event.getPlayer();

		this.setup(plugin);
	}

	/****************************

	****************************/
	private void setup(ItemSlots plugin) {

		this.plugin = plugin;

		this.dispenser = null;

		//this.lever = null;

		this.sign = null;

		sgnCon = new SignControl(plugin);

		local = new Local(event);

	}//setup

	/****************************

	****************************/
	public boolean isMachine() {

		DispenserControl dCon = new DispenserControl(plugin);

		LampControl lmpCon = new LampControl(plugin);
		
		SignControl signCon = new SignControl(plugin);

		if (lmpCon.isLamp(lamp) && signCon.isWallSign(this.sign) && dCon.isDispenser(this.dispenser)) {
			
			this.setSign(sign);

			return sgnCon.isMarkerValid();

		}

		else {return false;}
	}

	/****************************

	****************************/
	public void PickMachine(String dir) {

		switch(dir.toUpperCase()) {

		case "NORTH" :

			n = new North(event);

			this.sign = n.getRelativeBlock(n.getLevSgn());
			
			this.lamp = n.getRelativeBlock(n.getLevLmp());
			
			this.dispenser = n.getRelativeBlock(n.getLevDrp());

			break;

		case "SOUTH" : 

			s = new South(event);
			
			this.sign = s.getRelativeBlock(s.getLevSgn());
			
			this.lamp = s.getRelativeBlock(s.getLevLmp());
			
			this.dispenser = s.getRelativeBlock(s.getLevDrp());

			break;


		case "EAST" :

			e = new East(event);
			
			this.sign = e.getRelativeBlock(e.getLevSgn());
			
			this.lamp = e.getRelativeBlock(e.getLevLmp());
			
			this.dispenser = e.getRelativeBlock(e.getLevDrp());
			
			break;

		case "WEST" :

			w = new West(event);
			
			this.sign = w.getRelativeBlock(w.getLevSgn());
			
			this.lamp = w.getRelativeBlock(w.getLevLmp());
			
			this.dispenser = w.getRelativeBlock(w.getLevDrp());
			
			break;

		default:
		}
	}

	/*********************************************
	 * canBuild()
	 * 
	 * @return does player have permission to build
	 *********************************************/
	public boolean canBuild() {

		// plugin.toCon(String.valueOf(player.hasPermission("ItemSlots.Build")));

		return player.hasPermission("ItemSlots.Build") || player.isOp();

	}// can build

	/*****************************************
	 * isSignPlaced()
	 * 
	 * @return is placed block a red stone lamp
	 *****************************************/
	public boolean isSignPlaced() {

		SignControl sgnCon = new SignControl(plugin);

		return sgnCon.isWallSign(event.getBlock());

	}// isLampPlaced
	
	public boolean isLeverPlaced() {

		LeverControl levCon = new LeverControl(plugin);

		return levCon.isLever(event.getBlock());

	}// isLampPlaced
	
	/****************************

	****************************/
	private void setSign(Block sgn){

		sgnCon.setSign(sgn);

		sgnCon.setLines();

		sgnCon.printMarker();

		sgnCon.setLines();

		if(sgnCon.isMarkerValid()) {

			sgnCon.checkOddsHigh();

			sgnCon.checkOddsLow();

			sgnCon.checkPayHigh();

			sgnCon.checkPayLow();
		}
	}//setSign

	/********************************************
	getFacing()
	
	Purpose gets the direction of the used block
	********************************************/
	public String getFacing() {

		return local.getFacing(event.getBlock(), event.getBlock().getType());
	}


}//Build Class

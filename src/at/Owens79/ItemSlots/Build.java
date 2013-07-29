package at.Owens79.ItemSlots;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import at.Owens79.ItemSlots.Locations.*;

public class Build {

	private ItemSlots plugin;
	private BlockPlaceEvent event;
	private Player player;

	private North n;
	private South s;
	private East e;
	private West w;

	private Block sign;
	private Block dropper;
	private Block lever;
	private Block lamp;

	SignControl sgnCon;

	Local local;


	public Build(ItemSlots plugin, BlockPlaceEvent event) {

		this.event = event;

		this.player = event.getPlayer();

		this.setup(plugin);
	}

	private void setup(ItemSlots plugin) {

		this.plugin = plugin;

		this.dropper = null;

		this.lever = null;

		this.sign = null;

		sgnCon = new SignControl(plugin);

		local = new Local();

	}//setup

	public boolean isMachine() {

		DropperControl dropCon = new DropperControl(plugin);

		LampControl lmpCon = new LampControl(plugin);
		
		SignControl signCon = new SignControl(plugin);

		if (lmpCon.isLamp(lamp) && signCon.isWallSign(this.sign) && dropCon.isDropper(this.dropper)) {
			
			this.setSign(sign);

			return sgnCon.isMarkerValid();

		}

		else { return false; }
	}

	public boolean PickMachine(String dir) {

		switch(dir.toUpperCase()) {

		case "NORTH" :

			n = new North(event);

			//n.setMacSign();
			n.setMacLever();

			//this.lamp = n.getRelativeBlock(n.getSgnLmp());

			//this.lever = n.getRelativeBlock(n.getSgnLev());

			//this.dropper = n.getRelativeBlock(n.getSgnDrp());
			
			this.sign = n.getRelativeBlock(n.getLevSgn());
			
			this.lamp = n.getRelativeBlock(n.getLevLmp());
			
			this.dropper = n.getRelativeBlock(n.getLevDrp());

			break;

		case "SOUTH" : 

			s = new South(event);

			//s.setMacSign();
			
			s.setMacLever();

			//this.lamp = s.getRelativeBlock(s.getSgnLmp());

			//this.lever = s.getRelativeBlock(s.getSgnLev());

			//this.dropper = s.getRelativeBlock(s.getSgnDrp());
			
			this.sign = s.getRelativeBlock(s.getLevSgn());
			
			this.lamp = s.getRelativeBlock(s.getLevLmp());
			
			this.dropper = s.getRelativeBlock(s.getLevDrp());

			break;


		case "EAST" :

			e = new East(event);

			//e.setMacSign();

			//this.lamp = e.getRelativeBlock(e.getSgnLmp());

			//this.lever = e.getRelativeBlock(e.getSgnLev());

			//this.dropper = e.getRelativeBlock(e.getSgnDrp());

			e.setMacLever();
			
			this.sign = e.getRelativeBlock(e.getLevSgn());
			
			this.lamp = e.getRelativeBlock(e.getLevLmp());
			
			this.dropper = e.getRelativeBlock(e.getLevDrp());
			
			break;

		case "WEST" :

			w = new West(event);

			//w.setMacSign();

			//this.lamp = w.getRelativeBlock(w.getSgnLmp());

			//this.lever = w.getRelativeBlock(w.getSgnLev());

			//this.dropper = w.getRelativeBlock(w.getSgnDrp());

			w.setMacLever();
			
			this.sign = w.getRelativeBlock(w.getLevSgn());
			
			this.lamp = w.getRelativeBlock(w.getLevLmp());
			
			this.dropper = w.getRelativeBlock(w.getLevDrp());
			
			break;

		default:

			return false;
		}

		return this.isMachine();
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

	public String getFacing() {

		return local.getFacing(event.getBlock(), event.getBlock().getType());
	}

}//Build Class

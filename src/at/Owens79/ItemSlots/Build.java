package at.Owens79.ItemSlots;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;

import at.Owens79.ItemSlots.Locations.*;

public class Build {

	private ItemSlots plugin;
	private BlockPlaceEvent event;
	private Player player;
	
	private North north;
	private South south;
	private East east;
	private West west;
	
	private Block dropper;
	private Block lever;
	private Block sign;
	
	SignControl sgnCon;
	
	public Build(ItemSlots plugin, BlockPlaceEvent bpe) {
		
		this.plugin = plugin;
		
		this.event = bpe;
		
		this.player = event.getPlayer();
		
		this.dropper = null;
		
		this.lever = null;
		
		this.sign = null;
		
		sgnCon = new SignControl(plugin);
	}
	
	public boolean isMachine() {
		
		LeverControl levCon = new LeverControl(plugin);
		
		DropperControl dropCon = new DropperControl(plugin);
		
		if (sgnCon.isWallSign(sign) && levCon.isLever(lever) && dropCon.isDropper(this.dropper)) {

			this.setSign(sign);

			return sgnCon.isMarkerValid();

		}

		else { return false; }
	}
	
	public boolean PickMachine(String dir) {
		
		switch(dir.toUpperCase()) {
			
		case "NORTH" :
			
			north = new North(event);
			
			this.sign = north.getRelativeBlock(north.getLmpSgn());
			
			this.lever = north.getRelativeBlock(north.getLmpLev());
			
		break;
		
		case "SOUTH" : 
		
			south = new South(event);
			
			this.sign = south.getRelativeBlock(south.getLmpSgn());
			
			this.lever = south.getRelativeBlock(south.getLmpLev());
			
		break;
			
		
		case "EAST" :
			
			east = new East(event);
			
			this.sign = east.getRelativeBlock(east.getLmpSgn());
			
			this.lever = east.getRelativeBlock(east.getLmpLev());
			
		break;
		
		case "WEST" :
			
			west = new West(event);
			
			this.sign = west.getRelativeBlock(west.getLmpSgn());
			
			this.lever = west.getRelativeBlock(west.getLmpLev());
			
		break;
		}
		
		Local local = new Local();
		
		local.setLmpDrp();
		
		this.dropper = local.getRelativeBlock(local.getLmpDrp());
		
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
	 * isLampPlaced()
	 * 
	 * @return is placed block a red stone lamp
	 *****************************************/
	public boolean isLampPlaced() {

		LampControl lmpCon = new LampControl(plugin);
		
		// plugin.toCon(String.valueOf(event.getBlock().getType().equals(Material.REDSTONE_LAMP_OFF)));
		
		return lmpCon.isLamp(event.getBlock());

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
	}
	
	
}//Build Class

package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Lever;
import org.bukkit.material.Sign;

public class Local {

	protected World world;

	protected BlockPlaceEvent bpe;
	protected PlayerInteractEvent pie;

	protected Location orgin;
	protected Location lmpDrp;

	Sign sign;
	Lever lever;


	public Local() {
		
		
	}
	
	public Local(BlockPlaceEvent bpe) {

		this.bpe = bpe;

		this.orgin = bpe.getBlock().getLocation();

		this.world = bpe.getBlock().getWorld();

	}//Local

	public Local(World world, BlockPlaceEvent bpe, Location orgin) {

		this.world = world;

		this.bpe = bpe;

		this.orgin = orgin;

	}//Local

	public Local(PlayerInteractEvent pie) {

		this.pie = pie; 

		this.world = pie.getClickedBlock().getWorld();

		this.orgin = pie.getClickedBlock().getLocation();

	}//Local

	public Local(World world, PlayerInteractEvent pie, Location orgin) {

		this.world = world;

		this.pie = pie; 

		this.orgin = orgin;

	}//Local


	/****************************

	 ****************************/
	public Location setRelation(Location loc) {


		Location lo = this.orgin.clone();

		return lo.add(loc);
	}

	/****************************
	getRelativeBlock()

	@param Location loc

	@return the block at loc
	 ****************************/
	public Block getRelativeBlock(Location loc) {

		return setRelation(loc).getBlock();
	}

	
	public String getFacing(Block block, Material mat) {
		
		String dir = null;
		
		String matString = mat.toString();
		
		switch(matString) {
		
		case "WALL_SIGN": 
			
			sign = new Sign(mat, block.getData());
			
			dir = String.valueOf(sign.getFacing());
			
			break;
			
		case "LEVER" :
			
			lever = new Lever(mat, block.getData());
			
			dir = String.valueOf(lever.getFacing());
			
			break;
		
		}//switch
		
		return dir;
	}

	//Functions for Location for Dispenser LAMP based machine
	public void setLmpDrp() {this.lmpDrp = new Location(world, 0, -1, 0); }

	public Location getLmpDrp() {return this.lmpDrp;}

}//Local Class

//Y - axis vertical (up/down), second number

package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Dispenser;
import org.bukkit.material.Lever;
import org.bukkit.material.Sign;

import at.Owens79.ItemSlots.Display;


public class Local {

	protected World world;
	private BlockPlaceEvent event;
	
	Display display;
	
	protected Location orgin;
	
	protected Location lmpDis;
	
	private Location drp_Lmp;

	Sign sign;
	Lever lever;
	Dispenser dispenser;

	String dir = null;
	
	public Local() {
		
		
	}
	
	public Local(BlockPlaceEvent bpe) {

		this.orgin = bpe.getBlockPlaced().getLocation();

		this.world = bpe.getBlockPlaced().getLocation().getWorld();
		
		event = bpe;

		//this.debugLocal();
		
	}//Local

	public Local(World world, Location orgin) {

		this.world = world;

		this.orgin = orgin;

	}//Local

	public Local(PlayerInteractEvent pie) { 

		this.world = pie.getClickedBlock().getWorld();

		this.orgin = pie.getClickedBlock().getLocation();

	}//Local

	public Local(World world, PlayerInteractEvent pie, Location orgin) {

		this.world = world; 

		this.orgin = orgin;

	}//Local


	public Local(SignChangeEvent event) {

		this.orgin = event.getBlock().getLocation();

		this.world = event.getBlock().getLocation().getWorld();
	}

	/****************************

	 ****************************/
	public Location setRelation(Location loc) {

		loc.setWorld(world);
		
		Location lo = this.orgin.clone();
		
		lo.setWorld(world);
		
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
		
		switch(mat.toString()) {
		
		case "WALL_SIGN": 
			
			sign = new Sign(mat, block.getData());
			
			dir = sign.getFacing().toString();
			
			
			break;
			
		case "LEVER" :
			
			lever = new Lever(mat, block.getData());
			
			dir = lever.getFacing().toString();
			
			break;
		
		case "DISPENSER" :
			
			dispenser = new Dispenser(mat, block.getData());
			
			dir = dispenser.getFacing().toString();
		
		}//switch
		
		return dir;
	}

	//Functions for Location for Dispenser LAMP based machine
	public void setLmpDrp() {this.lmpDis = new Location(world, 0, -1, 0); }
	public Location getLmpDrp() {return this.lmpDis;}
	
	public void setDrpLmp() {this.drp_Lmp = new Location(world, 0, 1, 0); }
	public Location getDrpLmp() {return this.drp_Lmp;}

	
	public void debugLocal() {
		
		display = new Display(); 
		
		Player player = event.getPlayer();
		
		display.toPlayer(player, "Local created");
		//display.toPlayer(player, world.toString());
		//display.toPlayer(player, this.orgin.toString());
		
	}
}//Local Class

//Y - axis vertical (up/down), second number

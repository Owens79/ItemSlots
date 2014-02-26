package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
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
	
	Sign sign;
	Lever lever;
	Dispenser dispenser;

	String dir = null;
	
	/****************************
	Local : constructor
	
	@param BlockPlaceEvent bpe
	
	Sets the location and world
	 ****************************/
	public Local(BlockPlaceEvent bpe) {

		this.orgin = bpe.getBlockPlaced().getLocation();

		this.world = bpe.getBlockPlaced().getLocation().getWorld();

		this.event = bpe;
		
		//this.debugLocal();
		
	}//Local

	public Local(PlayerInteractEvent pie) { 

		this.world = pie.getClickedBlock().getWorld();

		this.orgin = pie.getClickedBlock().getLocation();

	}//Local

	public Local(SignChangeEvent event) {

		this.orgin = event.getBlock().getLocation();

		this.world = event.getBlock().getLocation().getWorld();
	}

	public Local(BlockBreakEvent event) {
				
		this.orgin = event.getBlock().getLocation();

		this.world = event.getBlock().getLocation().getWorld();
	}

	/****************************

	 ****************************/
	public Location setRelation(Location loc) {

		loc.setWorld(world);
		
		Location loca = this.orgin.clone();
		
		loca.setWorld(world);
		
		return loca.add(loc);
	}

	/****************************
	getRelativeBlock()

	@param Location part

	@return the block at part
	 ****************************/
	public Block getRelativeBlock(Location part) {

		return setRelation(part).getBlock();
	}

	
	public String getFacing(Block block, Material mat) {
		
		switch(mat.toString().toUpperCase()) {
		
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
	public Location getLmpDis() {return new Location(world, 0, -1, 0);}
	
	public Location getDisLmp() {return new Location(world, 0, 1, 0);}
	
	public Location getFakeLmpSgn() {return new Location (world, 0, 1, 0);}
	
	public Location getFakeSignLmp() {return new Location (world, 0 ,-1, 0);}

	
	public void debugLocal() {
		
		display = new Display(); 
		
		Player player = event.getPlayer();
		
		display.toPlayer(player, "Local created");
		//display.toPlayer(player, world.toString());
		//display.toPlayer(player, this.orgin.toString());
		
	}
}//Local Class

//Y - axis vertical (up/down), second number

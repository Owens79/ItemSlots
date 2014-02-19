package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class South extends Local{

	public South(BlockPlaceEvent event) {
		
		super(event);

	}
	
	public South (PlayerInteractEvent event){
		
		super(event);
	}
	
	public South(SignChangeEvent event) {
		
		super(event);
	}
	
	public South(BlockPistonExtendEvent pe) {
		super(pe);
	}
	//Locations for lamp based machine
	
	// X = -Left +Right
	// Y = +Up  -Down
	// Z = +Back -Forward

	//Lamp Based  
	public Location getLmpSgn() {return new Location(world, 0, 1, 1);}
	
	public Location getLmpLev() {return new Location(world, 1, 0, 1);}
		
	// X = -Left +Right
	// Y = +Up  -Down
	// Z = +Back -Forward
	
	//Lever Base

	public Location getLevLmp() {return new Location(world, -1, 0, -1); }

	public Location getLevSgn() {return new Location(world, -1, 1, 0); }

	public Location getLevDrp() {return new Location(world, -1, -1, -1);}
	
	// X = -Left +Right
	// Y = +Up  -Down
	// Z = +Back -Forward
	
	//Dropper Base
	
	public Location getDrpSgn() {return  new Location(world, 0, 2, 1);}
	
	public Location getDrpLev() {return new Location(world, 1, 1, 1);}

	
	// X = -Left +Right
	// Y = +Up  -Down
	// Z = +Back -Forward
	
	//Sign Base

	public Location getSgnLmp() {return new Location(world, 0, -1, -1);}
	
	public Location getSgnLev() {return new Location(world, 1, -1, 0);}
	
	public Location getSgnDrp() {return new Location(world, 0, -2, -1);}

	
}//South Class

//Y - axis vertical (up/down), second number

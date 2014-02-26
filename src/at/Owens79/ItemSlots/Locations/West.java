package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class West extends Local{

	public West(BlockPlaceEvent event) {

		super(event);

	}

	public West (PlayerInteractEvent event){

		super(event);
	}
	
	public West(SignChangeEvent event) {
		
		super(event);
	}

		public West(BlockBreakEvent event) {
			
			super(event);
	}

	// X = +Forward -Back 
	// Y = +Up  -Down
	// Z = +Right -Left


	//Lamp Base
	public Location getLmpLev() {return new Location(world, -1, 0, 1);}

	public Location getLmpSgn() {return new Location(world, -1, 1, 0);}

	// X = +Forward -Back 
	// Y = +Up  -Down
	// Z = +Right -Left
	
	//Lever Base

	public Location getLevLmp() { return  new Location(world, 1, 0, -1); }

	public Location getLevSgn() { return new Location(world, 0 , 1, -1); }

	public Location getLevDrp() { return new Location(world, 1, -1, -1); }
	
	
	// X = +Forward -Back 
	// Y = +Up  -Down
	// Z = +Right -Left
	
	//Dropper Base
	
	public Location getDrpSgn() {return new Location(world, -1, 2, 0);}
	
	public Location getDrpLev() {return new Location(world, -1, 1, 1);}

	
	// X = +Forward -Back 
	// Y = +Up  -Down
	// Z = -Left +Right
	
	//Sign Base

	public Location getSgnLmp() {return new Location(world, 1, -1, 0);}
	
	public Location getSgnLev() {return new Location(world, 0, -1, 1);}
	
	public Location getSgnDrp() {return new Location(world, 1, -2, 0);}

	
}//West Class

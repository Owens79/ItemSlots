package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class East extends Local{

	public East(BlockPlaceEvent event) {

		super(event);
	}

	public East(PlayerInteractEvent event) {

		super(event);
	}
	
	public East(SignChangeEvent event) {
		
		super(event);
	}
	
	public East(BlockPistonExtendEvent pe) {

		super(pe);
	}
	// X = +Back -Forward
	// Y = +Up -Down
	// Z = +Left -Right

	//LampBased
	public Location getLmpLev() {return new Location(world, 1, 0, -1);}

	public Location getLmpSgn() {return new Location(world, 1, 1,0);}

	// X = +Back -Forward
	// Y = +Up -Down
	// Z = +Left -Right
	
	//Lever Based

	public Location getLevLmp() { return new Location(world, -1, 0, 1); }

	public Location getLevSgn() { return new Location(world, 0, 1, 1); }

	public Location getLevDrp() { return new Location(world, -1, -1, 1); }
		
	// X = +Back -Forward
	// Y = +Up -Down
	// Z = +Left -Right
	
	//Dropper Base

	public Location getDrpSgn() {return new Location(world, 1, 2, 0);}
	
	public Location getDrpLev() {return new Location(world, 1, 1, -1);}

	// X = +Back -Forward
	// Y = +Up -Down
	// Z = +Left -Right
	
	//Sign Base
	
	public Location getSgnLmp() {return new Location(world, -1, -1, 0);}
	
	public Location getSgnLev() {return new Location(world, 0, -1, -1);}
	
	public Location getSgnDrp() {return new Location(world, -1, -2, 0); }

}// East class

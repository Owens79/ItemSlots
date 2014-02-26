package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class North extends Local{

	public North(BlockPlaceEvent event) {

		super(event);

	}

	public North (PlayerInteractEvent event){

		super(event);
		
	}
	
	public North(SignChangeEvent event) {
		
		super(event);
	}



	// X = +Left -Right
	// Y = +Up -Down
	// Z = +Forward -Back

	public North(BlockBreakEvent event) {
		
		super(event);
	}

	//Lamp Base
	public Location getLmpLev() {return new Location(world, -1, 0, -1);}

	public Location getLmpSgn() {return new Location(world, 0, 1, -1);}


	// X = +Left -Right
	// Y = +Up -Down
	// Z = +Forward -Back
	
	//Lever Base
	public Location getLevLmp() { return new Location(world, 1, 0, 1); }

	public Location getLevSgn() { return new Location(world, 1, 1, 0); }

	public Location getLevDrp() { return new Location(world, 1, -1, 1); }

	
	// X = +Left -Right
	// Y = +Up -Down
	// Z = +Forward -Back
	
	//Dropper Base
	public Location getDrpSgn() {return new Location(world, 0, 2, -1);}
	
	public Location getDrpLev() {return new Location(world, -1, 1, -1);}

	
	// X = +Left -Right
	// Y = +Up -Down
	// Z = +Forward -Back
	
	//Sign Base	
	public Location getSgnLmp() {return new Location(world, 0, -1, 1);}
	
	public Location getSgnLev() {return new Location(world, -1, -1, 0);}
	
	public Location getSgnDrp() {return new Location(world, 0, -2, 1);}


}//North Class

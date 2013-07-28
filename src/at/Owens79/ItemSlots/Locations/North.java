package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class North extends Local{

	//Lamp Based
	private Location lmp_Lev; //Lever
	private Location lmp_Sgn; //Sign

	//Lever Based
	private Location lev_Dis; //Dispenser
	private Location lev_Sgn; //Sign
	private Location lev_Lmp; //Lamp

	public North(BlockPlaceEvent event) {

		super(event);

	}

	North (PlayerInteractEvent event){

		super(event);
	}

	// X = +Left -Right
	// Y = +Up -Down
	// Z = +Forward -Back

	
	//Lamp Base
	public void setLmpLev() {this.lmp_Lev = new Location(world, -1, 0, -1);}

	public void setLmpSgn() {this.lmp_Sgn = new Location(world, 0, 1, -1);}
	
	public Location getLmpLev() {return this.lmp_Lev;}

	public Location getLmpSgn() {return this.lmp_Sgn;}

	//Lever Base
	public void setLevLmp() { this.lev_Lmp = new Location(world, 1, 0, 1); }

	public void setLevSgn() { this.lev_Sgn = new Location(world, 1, 1, 0); }

	public void setLevDis() { this.lev_Dis = new Location(world, 1, -1, 1); }

	public Location getLevLmp() { return this.lev_Lmp; }

	public Location getLevSgn() { return this.lev_Sgn; }

	public Location getLevDis() { return this.lev_Dis; }

}//North Class

package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class South extends Local{
	
	//Lamp Based
	private Location lmp_Sgn; //Sign
	private Location lmp_Lev; //Lever
	
	//Lever Based
	private Location lev_Lmp; //Lamp
	private Location lev_Sgn; //Sign
	private Location lev_Dis; //Dispenser

	public South(BlockPlaceEvent event) {
		
		super(event);

	}
	
	South (PlayerInteractEvent event){
		
		super(event);
	}
	
	//Locations for lamp based machine
	
	// X = +Right -Left
	// Y =  +Up  -Down
	// Z = +Back -Forward
		
	
	//Lamp Based
	
	public void setLmpSgn() {this.lmp_Sgn = new Location(world, 0, 1, 1);} //Sign for a Lamp Based machine
	
	public void setLmpLev() {this.lmp_Lev = new Location(world, 1, 0, 1);} //Lever for a Lamp Based machine  
	
	public Location getLmpSgn() {return this.lmp_Sgn;}
	
	public Location getLmpLev() {return this.lmp_Lev;}
	
	//Lever Base

	public void setLevLmp() { this.lev_Lmp = new Location(world, -1, 0, -1); }

	public void setLevSgn() { this.lev_Sgn = new Location(world, -1, 1, 0); }

	public void setLevDis() { this.lev_Dis = new Location(world, -1, -1, -1); }

	public Location getLevLmp() {return this.lev_Lmp; }

	public Location getLevSgn() {return this.lev_Sgn; }

	public Location getLevDis() {return this.lev_Dis; }
	
	
}//South Class

//Y - axis vertical (up/down), second number

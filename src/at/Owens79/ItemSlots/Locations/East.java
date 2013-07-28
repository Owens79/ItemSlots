package at.Owens79.ItemSlots.Locations;

import org.bukkit.Location;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class East extends Local{

	//Lamp Based
	private Location lmp_Lev; //Lever
	private Location lmp_Sgn; //Sign

	//Lever Based
	private Location lev_Lmp; //Lamp
	private Location lev_Sgn; //Sign
	private Location lev_Dis; //Dispenser
	
	//Dropper Based
	private Location drp_Sgn; //Sign
	private Location drp_Lev;//Lever
	
	//Sign Based
	private Location sgn_Lmp;//Lamp
	private Location sgn_Lev;//Lever
	private Location sgn_Drp;//Dropper

	public East(BlockPlaceEvent event) {

		super(event);
	}

	public East(PlayerInteractEvent event) {

		super(event);
	}
	
	public East(SignChangeEvent event) {
		
		super(event);
	}

	// X = +Back -Forward
	// Y = +Up -Down
	// Z = +Left -Right



	//LampBased
	public void setLmpLev() {this.lmp_Lev = new Location(world, 1, 0, -1);}

	public void setLmpSgn() {this.lmp_Sgn = new Location(world, 1, 1,0);}

	public Location getLmpLev() {return this.lmp_Lev;}

	public Location getLmpSgn() {return this.lmp_Sgn;}

	// X = +Back -Forward
	// Y = +Up -Down
	// Z = +Left -Right
	
	//Lever Based
	public void setLevLmp() { this.lev_Lmp = new Location(world, -1, 0, 1); }

	public void setLevSgn() { this.lev_Sgn = new Location(world, 0, 1, 1);  }

	public void setLevDrp() { this.lev_Dis = new Location(world, -1, -1, 1);  }

	public Location getLevLmp() { return this.lev_Lmp; }

	public Location getLevSgn() { return this.lev_Sgn; }

	public Location getLevDrp() { return this.lev_Dis; }
	
	// X = +Back -Forward
	// Y = +Up -Down
	// Z = +Left -Right
	
	//Dropper Base
	public void setDrpSgn(){this.drp_Sgn = new Location(world, 1, 2, 0); }
	
	public void setDrpLev(){this.drp_Lev = new Location(world, 1, 1, -1); }
	
	public Location getDrpSgn() {return this.drp_Sgn;}
	
	public Location getDrpLev() {return this.drp_Lev;}

	// X = +Back -Forward
	// Y = +Up -Down
	// Z = +Left -Right
	
	//Sign Base
	public void setSgnLmp() {this.sgn_Lmp = new Location(world, -1, -1, 0);}
	
	public void setSgnLev() {this.sgn_Lev = new Location(world, 0, -1, -1);}
	
	public void setSgnDrp() {this.sgn_Drp = new Location(world, -1, -2, 0);}
	
	public Location getSgnLmp() {return this.sgn_Lmp;}
	
	public Location getSgnLev() {return this.sgn_Lev;}
	
	public Location getSgnDrp() {return this.sgn_Drp;}
	
	public void setMacSgn(){
		
		this.setSgnLmp();
		this.setSgnLev();
		this.setSgnDrp();
	}
}// East class

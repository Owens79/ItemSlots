package at.Owens79.ItemSlots;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;
import org.bukkit.inventory.ItemStack;



public class DropperControl {
	
	ItemSlots plugin;

	Block block;
	
	Dropper dropper;

	ItemStack[] contents;

	public DropperControl(ItemSlots plugin) {
		
		this.plugin = plugin;
	}

	public void setBlock(Block block) {

		this.block = block;
	}

	/********************************************************
	isDropper()
	@param Block block: block to be checked
	@return boolean: is the block a dropper
	 ********************************************************/
	public boolean isDropper() {

		return block.getType().equals(Material.DROPPER);

	}


	public boolean isDropper(Block block) {

		return block.getType().equals(Material.DROPPER);

	}

	public void setDropper() {

		try{

			this.dropper = (Dropper) block.getState();

		}

		catch(Exception e) {

			e.printStackTrace();
		}
	}


	public void setDropper(Block block) {

		this.setBlock(block);

		this.setDropper();
	}

	public Dropper getDropper() {

		return this.dropper;
	}

	public Dropper getDropper(Block block) {

		this.setBlock(block);

		this.setDropper();

		return this.dropper;
	}

	/********************************************************************
	setIventory()

	Purpose: sets the contents of the dropper to a field for later use
	 ********************************************************************/
	public void setIventory() {

		this.contents = this.dropper.getInventory().getContents();
	}

	/*********************************
	clearOut()

	Purpose: clears out the dropper
	 *********************************/
	
	public void clearOut() {

		this.dropper.getInventory().clear();

	}//clearOut()
	
	/********************************************************
	runDropper()
	@param Block block: the dropper
	@param int pay: the number used for how many drops
	********************************************************/
	public void runDropper(int pay) {

		for (ItemStack con : contents) {

			for (int i = 0; i < pay; i++) {

				if (con != null) {
					
					this.dropper.drop();
					
					//block.getWorld().dropItem(player.getLocation(), con); //drop contents
				
				}//if con is not null
			}//loop for each set
		}//for each con
	}// runDropper()
	
}//DropperControl class

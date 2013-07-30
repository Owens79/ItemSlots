package at.Owens79.ItemSlots;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

//TODO try changing dispenser to dropper

public class DispenserControl {
	
	ItemSlots plugin;

	Block block;
	
	Dispenser dispenser;

	ItemStack[] contents;

	private Player player;

	public DispenserControl(ItemSlots plugin, Player player) {

		this.player = player;
		
		
	}

	public DispenserControl(ItemSlots plugin) {
		
		this.plugin = plugin;
	}

	public void setBlock(Block block) {

		this.block = block;
	}

	/********************************************************
	isDispenser()
	@param Block block: block to be checked
	@return is the block a dispenser
	 ********************************************************/
	public boolean isDispenser() {

		return block.getType().equals(Material.DISPENSER);

	}


	public boolean isDispenser(Block block) {

		return block.getType().equals(Material.DISPENSER);

	}

	public void setDispenser() {

		try{

			this.dispenser = (Dispenser) block.getState();

		}

		catch(Exception e) {

			e.printStackTrace();
		}
	}


	public void setDispenser(Block block) {

		this.setBlock(block);

		this.setDispenser();
	}

	public Dispenser getDispenser() {

		return this.dispenser;
	}

	public Dispenser getDispenser(Block block) {

		this.setBlock(block);

		this.setDispenser();

		return this.dispenser;
	}

	/********************************************************************
	setIventory()

	Purpose: sets the contents of the dispenser to a field for later use
	 ********************************************************************/
	public void setIventory() {

		this.contents = this.dispenser.getInventory().getContents();
	}

	/*********************************
	clearOut()

	Purpose: clears out the dispenser
	 *********************************/
	
	public void clearOut() {

		this.dispenser.getInventory().clear();

	}//clearOut()
	
	/********************************************************
	runDispenser()
	@param Block block: the dispenser
	@param int pay: the number used for how many drops
	********************************************************/
	public void runDispenser(int pay) {

		for (ItemStack con : contents) {

			for (int i = 0; i < pay; i++) {

				if (con != null) {
					
					block.getWorld().dropItem(player.getLocation(), con); //drop contents
				
				}//if con is not null
			}//loop for each set
		}//for each con
	}// runDispenser()
	
}//DispenserControl class

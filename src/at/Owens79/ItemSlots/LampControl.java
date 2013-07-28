package at.Owens79.ItemSlots;


import at.Owens79.ItemSlots.ItemSlots;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class LampControl {
	
	@SuppressWarnings("unused")
	private ItemSlots plugin;
	
	
	
	
	 public LampControl(ItemSlots plugin) {
		
		 this.plugin = plugin;
	}

	public boolean isLamp(Block block) {
		
		return block.getType().equals(Material.REDSTONE_LAMP_OFF);
	}
	
	public void lampOn(Block block){
		
		block.setType(Material.REDSTONE_LAMP_ON);
	}

}

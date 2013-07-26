package at.Owens79.ItemSlots;

import java.util.Random;

import org.bukkit.event.Listener;

public class SlotListener implements Listener {

	ItemSlots plugin;
	
	Random ran;
	
	SlotListener(ItemSlots itemSlots, Random ran) {
		
		this.plugin = itemSlots;
		
		this.ran = ran;
	}

	
	
}//SlotsListener class 

package at.Owens79.ItemSlots;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;




public class LeverControl {

	@SuppressWarnings("unused")
	private ItemSlots plugin;

	@SuppressWarnings("unused")
	private Display display;


	private PlayerInteractEvent event;

	public LeverControl(ItemSlots plugin) {

		this.plugin = plugin;
		this.display = new Display();
	}

	public LeverControl(ItemSlots plugin, PlayerInteractEvent event) {

		this.event = event;

	}

	/*************************************
	 * isLever()
	 * 
	 * @param Block
	 * @return is the checked block a lever
	 *************************************/
	public boolean isLever(Block block) {

		return block.getType().equals(Material.LEVER);

	}

	public boolean didClickLever() {

		return event.getAction().equals(Action.RIGHT_CLICK_BLOCK)
				&& this.isLever(event.getClickedBlock());
	}

}

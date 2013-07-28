package at.Owens79.ItemSlots;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class Display {

	public final Logger logger = Logger.getLogger("Minecraft");

	private ItemSlots plugin;

	public Display() {

	}

	public Display(ItemSlots plugin) {

		this.plugin = plugin;
	}

	/**********************************************
	toCon()
	
	@param String info: the string to be displayed
	
	Purpose: display information to the console
	**********************************************/
	public void toCon(String info) {

		this.logger.info(info);
		
	}//toCon()
	
	/**********************************************
	toCon()
	
	@param int i
	
	Purpose: display information to the console
	**********************************************/
	public void toCon(int i) {
		
		this.logger.info(String.valueOf(i));
	}
	
	/**********************************************
	toCon()
	
	@param boolean b;
	
	Purpose: display information to the console
	**********************************************/
	public void toCon(boolean b) {
		
		this.logger.info(String.valueOf(b));
	}

	/*****************************************************
	toPlayer(Player player, String info)
	
	@param Player player: the player getting the message
	
	@param String info: the string being displayed
	
	Purpose: display information to the player
	*****************************************************/
	public void toPlayer(Player player, String info) {

		player.sendMessage(info);
	
	}//toPlayer

	/*************************************************************
	toBoth(Player player, String info)
	
	@param Player player: player receiving the information
	
	@param String info: the information being displayed
	
	Purpose: sends information to player as well as to the console
	**************************************************************/
	public void toBoth(Player player, String info) {

		toCon(info);

		toPlayer(player, info);
	}

	
	/********************************************************
	 enableMessage(PluginDescriptionFile pdFile)
	 
	 @param PluginDescriptionFile pdFile
	********************************************************/
	public void enableMessage(PluginDescriptionFile pdFile) {

		this.toCon(pdFile.getName() + " " + pdFile.getVersion() + " is active");
	}

	
	/********************************************************
	 disableMessage(PluginDescriptionFile)
	 
	 @param PluginDescriptionFile pdFile
	********************************************************/
	public void disableMessage(PluginDescriptionFile pdFile) {

		this.toCon("Exiting " + pdFile.getName() + " " + pdFile.getVersion());
	}

	
	/********************************************************
	 buildMessage(Player player)
	 
	 @param Player player
	********************************************************/
	public void buildMessage(Player player) {

		toPlayer(player, plugin.getConfig().getString(PathNames.BUILT_MSG));
		
		toCon(plugin.getConfig().getString(PathNames.BUILT_MSG) + " by " + player.getDisplayName());
	}

	
	/********************************************************
	 destroyMessage(Player player)
	 
	 @param Player player
	********************************************************/
	public void destroyMessage(Player player) {

		toPlayer(player, plugin.getConfig().getString(PathNames.DESTROY_MSG));
		
		toCon(plugin.getConfig().getString(PathNames.DESTROY_MSG) + " by " + player.getDisplayName());
	}

	/********************************************************
	 winMessage(Player player)
	 
	 @param Player player
	********************************************************/
	public void winMessage(Player player) {

		toPlayer(player, plugin.getConfig().getString(PathNames.WIN_MSG));

	}

	/********************************************************
	 loseMessage(Player player)
	 
	 @param Player player
	********************************************************/
	public void loseMessage(Player player) {

		toPlayer(player, plugin.getConfig().getString(PathNames.Lose_MSG));
	}

}//Display Class

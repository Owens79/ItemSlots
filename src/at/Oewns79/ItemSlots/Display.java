package at.Oewns79.ItemSlots;

import java.util.logging.Logger;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class Display {

	public final Logger logger = Logger.getLogger("Minecraft");
	
	public ItemSlots plugin;
	
	Display(ItemSlots plugin) {
		
		this.plugin = plugin;
		
	}//Constructor
	

	/**********************************************
	toCon()
	
	@param String info: the string to be displayed
	
	Purpose: display information to the console
	**********************************************/
	public void toCon(String info) {

		this.logger.info(info);
		
	}//toCon()
	
	public void toCon(int i) {
		
		this.logger.info(String.valueOf(i));
	}
	
	public void toCon(boolean b) {
		
		this.logger.info(String.valueOf(b));
	}

	/*****************************************************
	toPlayer()
	
	@param Player player: the player getting the message
	
	@param String info: the string being displayed
	
	Purpose: display information to the player
	*****************************************************/
	public void toPlayer(Player player, String info) {

		player.sendMessage(info);
	
	}//toPlayer

	/*************************************************************
	toBoth()
	
	@param Player player: player receiving the information
	
	@param String info: the information being displayed
	
	Purpose: sends information to player as well as to the console
	**************************************************************/
	public void toBoth(Player player, String info) {

		toCon(info);

		toPlayer(player, info);
	}

	
	/******************************************************** 
	 enableMessage()
	  
	 @param pdFile
	 
	 Purpose: sends the enable message to the console
	********************************************************/
	public void enableMessage(PluginDescriptionFile pdFile) {

		this.toCon(pdFile.getName() + " " + pdFile.getVersion() + " is active");
	}

	
	/******************************************************** 
	 disableMessage()
	  
	 @param pdFile
	 
	 Purpose: sends the disable message to the console
	********************************************************/
	public void disableMessage(PluginDescriptionFile pdFile) {

		this.toCon("Exiting " + pdFile.getName() + " " + pdFile.getVersion());
	}

	
	/****************************************************************** 
	 buildMessage()
	  
	 @param player
	 
	 Purpose: sends a message to the player when a machine is built
	******************************************************************/
	public void buildMessage(Player player) {

		toPlayer(player, plugin.getConfig().getString(PathNames.BUILT_MSG));
	}

	
	/****************************************************************** 
	 destroyMessage()
	  
	 @param player
	 
	 Purpose: sends a message to the player when a machine is destroyed
	******************************************************************/
	public void destroyMessage(Player player) {

		toPlayer(player, plugin.getConfig().getString(PathNames.DESTROY_MSG));
	}

	/****************************************************************** 
	 winMessage()
	  
	 @param player
	 
	 Purpose: sends a message to the player they win
	******************************************************************/
	public void winMessage(Player player) {

		toPlayer(player, plugin.getConfig().getString(PathNames.WIN_MSG));

	}

	/****************************************************************** 
	 loseMessage()
	  
	 @param player
	 
	 Purpose: sends a message to the player when they lose
	******************************************************************/
	public void loseMessage(Player player) {

		toPlayer(player, plugin.getConfig().getString(PathNames.Lose_MSG));
	}

	
}//Display

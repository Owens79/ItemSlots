package at.Owens79.ItemSlots;

import java.util.Random;

import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;
import at.Owens79.ItemSlots.Locations.*;
import at.Owens79.ItemSlots.Parts.DispenserControl;
import at.Owens79.ItemSlots.Parts.LampControl;
import at.Owens79.ItemSlots.Parts.LeverControl;
import at.Owens79.ItemSlots.Parts.SignControl;


public class Play {

	public ItemSlots plugin;
	private PlayerInteractEvent event;

	private Display display;
	private SignControl sgnCon;
	private DispenserControl dCon;
	private LampControl lmpCon;

	private North n;
	private South s;
	private East e;
	private West w;

	private Block dispenser;
	private Block sign;
	private Block lamp;
	@SuppressWarnings("unused")
	private Block lever;

	int odds;
	int pay;
	int ran;

	/****************************

	****************************/
	Play(ItemSlots plugin, PlayerInteractEvent event, Random ran){

		this.plugin = plugin;
		this.event = event;
		this.display = new Display(plugin);

		this.sgnCon = new SignControl(plugin);
		this.dCon = new DispenserControl(plugin, event.getPlayer());
		this.lmpCon = new LampControl(plugin);

	}//Play

	/****************************
	canUse()
	
	Purpose: Checks user permission
	****************************/
	public boolean canUse() {

		return event.getPlayer().hasPermission("ItemLsots.Use");
	
	}//canUse

	/***********************************************
	setSign(Block block)
	
	@param Block block
	
	Purpose: Sets the sign in the SignControl Class
	***********************************************/
	private void setSign(Block block){

		sgnCon.setSign(block);
		sgnCon.setLines();
	
	}//setSign

	/****************************

	****************************/
	public boolean isMachine() {

		if (sgnCon.isWallSign(sign) && lmpCon.isLamp(lamp) && dCon.isDispenser(this.dispenser)) {

			//this.display.toPlayer(event.getPlayer(), String.valueOf(sgnCon.isWallSign(sign)));
			
			this.setSign(sign);

			return sgnCon.isMarkerValid();

		}

		else { return false; }
	
	}//isMachine	

	/****************************

	****************************/
	public boolean PickMachine(String dir) {
		
		switch(dir.toUpperCase()) {

		case "NORTH" :
			
			n = new North(event);

			n.setMacLever();
			
			this.sign = n.getRelativeBlock(n.getLevSgn());
			
			this.lamp = n.getRelativeBlock(n.getLevLmp());
			
			this.dispenser = n.getRelativeBlock(n.getLevDrp());
			
			break; //North

		case "SOUTH" : 

			s = new South(event);

			s.setMacLever();

			this.sign = s.getRelativeBlock(s.getLevSgn());

			this.lamp = s.getRelativeBlock(s.getLevLmp());

			this.dispenser = s.getRelativeBlock(s.getLevDrp());

			break;//South


		case "EAST" :

			e = new East(event);

			e.setMacLever();//east

			this.sign = e.getRelativeBlock(e.getLevSgn());

			this.lamp = e.getRelativeBlock(e.getLevLmp());

			this.dispenser = e.getRelativeBlock(e.getLevDrp());

			break;

		case "WEST" :

			w = new West(event);

			w.setMacLever();

			this.sign = w.getRelativeBlock(w.getLevSgn());

			this.lamp = w.getRelativeBlock(w.getLevLmp());

			this.dispenser = w.getRelativeBlock(w.getLevDrp());

			break;

		default:

			//this.display.toPlayer(event.getPlayer(), "false");
			
			return false;
		}

		this.display.toPlayer(event.getPlayer(), String.valueOf(sign.getType()));
		
		this.lever = event.getClickedBlock();
		
		return this.isMachine();
	
	}//PickMachine

	/************************************************
	setOdds()
	
	Purpose: gets the odds of winning from the sign
	************************************************/
	private void setOdds() {

		this.odds = sgnCon.getPrintedOdds();
	
	}//setOdds

	/*********************************************
	setPay()
	
	Purpose: gets the pay out amount from the sign 
	**********************************************/
	private void setPay() {

		this.pay = sgnCon.getPrintedPay();
	
	}//setPay

	/****************************

	****************************/
	public void blink(ItemSlots plugin) {

		Long pause = 10L;

		lmpCon.lampOn(lamp);
		
		@SuppressWarnings("unused")
		Delay del = new Delay(plugin, pause){

			public void run() {

				lmpCon.lampOn(lamp);

				if (odds >= ran) {

					display.winMessage(event.getPlayer());

					dCon.runDispenser(pay);
				}//if player wins

				else {

					display.loseMessage(event.getPlayer());
					
					dCon.clearOut();
				
				}//else player loses
			}
		};
		
	}//blink

	/****************************
	runMac(final int ran)
	
	@param final int ran;
	
	Purpose: runs the bet
	****************************/
	public void runMac(final int ran) {

		this.ran = ran;

		event.setCancelled(true);

		if( lmpCon.isLamp(lamp) && dCon.isDispenser(dispenser)) {

			this.setOdds();
			this.setPay();

			dCon.getDispenser(dispenser);
			dCon.setIventory();
			dCon.clearOut();

			this.blink(plugin);

		}//if lamp AND dispenser
	
	}//runMac
	
	/********************************************
	getFacing()
	
	Purpose gets the direction of the used block
	********************************************/
	public String getFacing() {

		Local local = new Local(event);
		
		return local.getFacing(event.getClickedBlock(), event.getClickedBlock().getType());
	}
	
	public boolean isLever(Block block) {
		
		LeverControl lc = new LeverControl(plugin);
		
		return lc.isLever(block);
	}
	
	public boolean didActivateLever() {
		
		LeverControl levCon = new LeverControl(plugin, event);
		
		return levCon.didClickLever();
	}
	
}//Player Class

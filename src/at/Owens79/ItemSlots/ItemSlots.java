package at.Owens79.ItemSlots;

import java.util.Random;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemSlots extends JavaPlugin {

	private Random ran;
	
	Display show = new Display(this);
	
	PluginDescriptionFile pdFile; 
	
	void loadConfig() {

		getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
	@Override
	public void onEnable() {
		
		this.pdFile = this.getDescription();
		
		ran = new Random();
		
		this.loadConfig();
		
		show.enableMessage(pdFile);
		
		getServer().getPluginManager().registerEvents(new SlotListener(this, ran), this);
		
	}//onEnable
	
	@Override
	public void onDisable() {
		
		this.getServer().getScheduler().cancelAllTasks();

		show.disableMessage(pdFile);
		
	}//onDisable
	
}//ItemSlots class

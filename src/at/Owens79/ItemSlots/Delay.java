/****************************
Project: ItemSlots
Class: Delay.java
Programmer: Travis Warren
Date: 11/2/2102
Purpose: Delayed Task
****************************/

package at.Owens79.ItemSlots;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public abstract class Delay implements Runnable{

	private int taskID;
	
	private BukkitTask task;
	
	private final ItemSlots plugin;
	
	private long pause;
	
	/****************************
	Delay()
	@param ItemSlots
	@param long
	Purpose: Constructor
	****************************/
	
	public Delay(ItemSlots plug, long p) {
		
		plugin = plug;
		
		this.pause=p;
		
		task = plugin.getServer().getScheduler().runTaskLater(plugin, this, pause);
		
		taskID = task.getTaskId();
	
	}
	
	/*************************************
	isWorking()
	@return is the task currently working
	*************************************/
	public boolean isWorking() {
		
		return Bukkit.getScheduler().isQueued(taskID) || Bukkit.getScheduler().isCurrentlyRunning(taskID);
	}
	
	/****************************
	cancel()
	
	Purpose: cancels the task
	****************************/
	public void cancel() {
		
		plugin.getServer().getScheduler().cancelTask(taskID);
		
	}
	
	/****************************
	getTaskID()
	
	@return taskID
	****************************/
	public int getTaskID(){
		
		return taskID;
	}
}

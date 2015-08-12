package com.lothrazar.samscontent;

import java.util.HashMap; 
import org.apache.logging.log4j.Logger; 

import com.lothrazar.util.Reference;

import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.config.Configuration; 
import net.minecraft.world.World;   
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
 
public class HandlerSurvivalFlying  
{ 
	private boolean quickSortEnabled;  
 
    
	public static int StartFlyingLevel = 2;
	public static int StartFlyingHealth = 20;
	public static int StartFlyingHunger = 14;
	public static boolean NoArmorOnly = false;
	public static boolean cannotFlyWhileBurning = false;
	public static int difficultyRequiredToFly = 3; 
	public static boolean cannotFlyAtNight = true;
	public static boolean cannotFlyInRain = true;
	public static boolean doesDrainHunger = true;
	public static boolean doesWeaknessFatigue = true;

	public static boolean canFlySurvival = true;
	//was 70 in old mod, farily fast
	public static int flyDamageCounterLimit = 300;// speed of countdown. changed by cfg file. one for all players
  
	//private HashMap<String, Integer> playerFlyDamageCounters = new HashMap<String, Integer>();


	private boolean doesDrainLevels = false;//TODO: FIx this as it doesnt work
  
	 
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{   
		if(canFlySurvival == false ) { return; }//disable whole module
		if( !event.player.worldObj.isRemote  ){ return; }
		if( event.player.capabilities.isCreativeMode){return;}//leave flying alone
		
 
		//use the players display name as the hashmap key for the flyCountdown
		String pname = event.player.getDisplayName();
	 
		//start at zero, of course. it counts up to the limit (from config)
	//	if(playerFlyDamageCounters.containsKey(pname) == false) { playerFlyDamageCounters.put(pname, 0); }
		 
		boolean disabledFromDifficulty = false;
		boolean disabledFromRain = false;
		boolean disabledFromNight = false;
		
		World world = event.player.worldObj;
	
		int difficultyCurrent = world.difficultySetting.ordinal();//this.world.difficultySetting.ordinal();
		
		//ex: if current is peaceful, required is easy, then disabled is true
		//but, if current and required and both peaceful (equal) or if current > required then disabled false
		
		if(difficultyCurrent < difficultyRequiredToFly ) { disabledFromDifficulty = true; } 
		 
		//if not allowed, and is raining, then disable
		if(cannotFlyInRain && world.getWorldInfo().isRaining()) { disabledFromRain = true; }
		
		//if we are not allowed, and its night, then disable
		if(cannotFlyAtNight && !world.isDaytime()) { disabledFromNight = true; } 
	  		  
		boolean isNaked = (
				   event.player.getEquipmentInSlot(1) == null
				&& event.player.getEquipmentInSlot(2) == null
				&& event.player.getEquipmentInSlot(3) == null 
				&& event.player.getEquipmentInSlot(4) == null);
 
		// if we are not naked, AND the rule is set to "no armor only" then its
		// not allowed
		boolean disabledFromArmor = (isNaked == false) && NoArmorOnly;
		// event.player.mc.theWorld.difficultySetting == EnumDifficulty.HARD
	 
		// if we ARE burning, and we may NOT fly while burning, then disabled
		boolean disabledFromBurning = event.player.isBurning() && cannotFlyWhileBurning;

		// only if single player and NOT creative


		//http://minecraft.gamepedia.com/Status_effect 
		//int miningFatigue = 4;
		//int weakness = 18;
			// entire block is disabled

		if (       event.player.getHealth() >= StartFlyingHealth
				&& event.player.getFoodStats().getFoodLevel() >= StartFlyingHunger
				&& event.player.experienceLevel >= StartFlyingLevel
				&& disabledFromArmor == false// did wearing armor disable 
				&& disabledFromBurning == false// are we burning disabled 
				&& disabledFromDifficulty == false//is difficulty too low
				&& disabledFromRain == false
				&& disabledFromNight == false
		)
		{
			//okay, you have passed all the tests
			event.player.capabilities.allowFlying = true;  
		} 
		else
		{  
			// disable flying in future
			event.player.capabilities.allowFlying = false; 
			// turn off current flying ability
			event.player.capabilities.isFlying = false; 
			//reset the timer for this player
			//playerFlyDamageCounters.put(pname, 0); 
		}
		if (event.player.capabilities.isFlying)
		{ 
			//if the config is set to drain your xp, then up this counter
			/*
			if(doesDrainLevels) //DOESNT WORK
			{
				
				//do flyDamageCounter++; but use put and get of hashmap
				int prevCounter = playerFlyDamageCounters.get(pname);
				
				prevCounter++;
				   
				if (prevCounter == flyDamageCounterLimit)
				{
					prevCounter = 0;//this will get set into the hashmap regardless
					event.player.experience = 0;
					event.player.experienceLevel--;
				}
				
				//save the prev counter. is eitehr zero, or it was increased by one
	 
				//playerFlyDamageCounters.put(pname, prevCounter); 
			} //if the counter is never increased, the counter never reaches the limit (stays at 0 of default max 70)
			*/
			//int hunger = 17;
			 
			int duration = 2 * Reference.TICKS_PER_SEC ;//20 ticks = 1 second. and this is added every time, so cosntant effect  until we land
			int level = 4;//no number is actually default, so this makes potion effect 2 == III, 4 == V
			  
			if(doesWeaknessFatigue)
			{
				event.player.addPotionEffect(new PotionEffect(Reference.potion_FATIGUE, duration, level));
				event.player.addPotionEffect(new PotionEffect(Reference.potion_WEAKNESS, duration, level));
				
			}
			if(doesDrainHunger) {event.player.addPotionEffect(new PotionEffect(Reference.potion_HUNGER, duration, 0));}
			   
		} // end if isFlying
		else //so therefore isFlying is false
		{ 
			// i am not flying so do the fall damage thing
			if (event.player.posY < event.player.prevPosY)
			{
				// we are falling 
				//double fallen = Math.max(	(event.player.prevPosY - event.player.posY), 0);
//dont add the number, it doubles (ish) our fall damage
				//event.player.fallDistance += (fallen * 0.5);
				
					 
				event.player.capabilities.allowFlying = false;// to enable  fall distance

				//dont leave them lingering with 0:00 potions forever 
				if(doesWeaknessFatigue)
				{
				
					
					 event.player.removePotionEffect(Reference.potion_FATIGUE);
					 event.player.removePotionEffect(Reference.potion_WEAKNESS);
				}
				
				if(doesDrainHunger) {event.player.removePotionEffect(Reference.potion_HUNGER);}
			} 
		}  
	}// end player tick event
}

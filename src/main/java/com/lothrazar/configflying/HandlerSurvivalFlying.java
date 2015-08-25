package com.lothrazar.configflying;

import java.util.HashMap; 

import org.apache.logging.log4j.Logger; 

import net.minecraft.entity.player.EntityPlayer;
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
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
 
public class HandlerSurvivalFlying  
{ 
	//private boolean quickSortEnabled;  
 
    
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
 
	//was 70 in old mod, farily fast
	public static int flyDamageCounterLimit = 300;// speed of countdown. changed by cfg file. one for all players
  
	//private HashMap<String, Integer> playerFlyDamageCounters = new HashMap<String, Integer>();


	private boolean doesDrainLevels = true;//TODO: FIx this as it doesnt work
	/*
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) 
    {   
        if(ClientProxy.keyFlyToggle.isPressed() )
        { 	     
        	 network.sendToServer( new MessageKeyPressed(ClientProxy.keyShiftUp.getKeyCode()));  
        	
        	
        	
        	
        }      
	 
    }*/
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event)
	{    

		if( event.player.worldObj.isRemote == false ){ return; }//not client side
		if( event.player.capabilities.isCreativeMode){return;}//leave flying alone
		
 
		//use the players display name as the hashmap key for the flyCountdown
		//String pname = event.player.getDisplayName();
	 
		//start at zero, of course. it counts up to the limit (from config)
	//	if(playerFlyDamageCounters.containsKey(pname) == false) { playerFlyDamageCounters.put(pname, 0); }
		 
		//boolean disabledFromDifficulty = false;
		//boolean disabledFromRain = false;
		//boolean disabledFromNight = false;
		
		World world = event.player.worldObj;
	
		int difficultyCurrent = world.difficultySetting.ordinal();//this.world.difficultySetting.ordinal();
		
		//ex: if current is peaceful, required is easy, then disabled is true
		//but, if current and required and both peaceful (equal) or if current > required then disabled false
		
		//if(difficultyCurrent < difficultyRequiredToFly ) { disabledFromDifficulty = true; } 

 
		//if(cannotFlyInRain && world.getWorldInfo().isRaining()) { disabledFromRain = true; }
		
		//if we are not allowed, and its night, then disable
		//if(cannotFlyAtNight && !world.isDaytime()) { disabledFromNight = true; } 
	  		  
		
 
		// if we are not naked, AND the rule is set to "no armor only" then its
		// not allowed
		//boolean disabledFromArmor = (isNaked == false) && NoArmorOnly;
		// event.player.mc.theWorld.difficultySetting == EnumDifficulty.HARD
	 
		// if we ARE burning, and we may NOT fly while burning, then disabled
		//boolean disabledFromBurning = event.player.isBurning() && cannotFlyWhileBurning;

		// only if single player and NOT creative

//boolean hasEnoughHunger = event.player.getFoodStats().getFoodLevel() >= StartFlyingHunger;
//boolean hasEnoughHealth = event.player.getHealth() >= StartFlyingHealth;
 
/*
System.out.println("hasEnoughHunger "+hasEnoughHunger);
System.out.println("hasEnoughHealth "+hasEnoughHealth);
System.out.println("disabledFromArmor "+disabledFromArmor);
System.out.println("disabledFromBurning "+disabledFromBurning);
System.out.println("disabledFromDifficulty "+disabledFromDifficulty);
System.out.println("disabledFromRain "+disabledFromRain);
System.out.println("disabledFromNight "+disabledFromNight);
*/
		/*
		if (       hasEnoughHunger
				&& hasEnoughHealth
				//&& event.player.experienceLevel >= StartFlyingLevel
				&& disabledFromArmor == false// did wearing armor disable 
				&& disabledFromBurning == false// are we burning disabled 
				&& disabledFromDifficulty == false//is difficulty too low
				&& disabledFromRain == false
				&& disabledFromNight == false
		)*/
		boolean isNaked = (
				   event.player.getEquipmentInSlot(1) == null
				&& event.player.getEquipmentInSlot(2) == null
				&& event.player.getEquipmentInSlot(3) == null 
				&& event.player.getEquipmentInSlot(4) == null);
		
		if(isNaked && event.player.experienceTotal > 0)
		{
			event.player.capabilities.allowFlying = true;  
		} 
		else
		{  
			event.player.capabilities.allowFlying = false; 
			event.player.capabilities.isFlying = false; 
		}
		
		if (event.player.capabilities.isFlying)
		{ 
			//if the config is set to drain your xp, then up this counter
			//TODO:
			//System.out.println(event.player.worldObj.getWorldTime()%40);
			int seconds = 5;
			if(event.player.experienceTotal > 0 && 
					event.player.worldObj.getWorldTime() % seconds*20 == 0)
			{
				UtilExperience.drainExp(event.player, 1.0F);
			}
		} 
		else
		{ 
			if (event.player.posY < event.player.prevPosY)// i am not flying so do the fall damage thing
			{
				event.player.capabilities.allowFlying = false;// to enable  fall distance

				// we are falling 
				//double fallen = Math.max(	(event.player.prevPosY - event.player.posY), 0);
//dont add the number, it doubles (ish) our fall damage
				//event.player.fallDistance += (fallen * 0.5);
		
			} 
		}  
	}// end player tick event

	
}

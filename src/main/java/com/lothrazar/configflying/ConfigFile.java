package com.lothrazar.configflying;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;



public class ConfigFile
{
	public boolean swiftDeposit = true;
	public boolean smartEnderchest = true;
	public boolean increasedStackSizes = true;
	public boolean moreFuel = true;
	public boolean moreFutureTrades = true;
	public boolean skullSignNames;
	public boolean betterDebugScreen; 
	
	public boolean craftableTransmuteRecords = true;  
	public boolean craftableFlatDoubleSlab = true; 
	public boolean craftableBonemealColouredWool;   
	public boolean craftableMobHeads;
	public boolean betterBonemeal;
	public boolean decorativeBlocks;
	public boolean mutton;
	public boolean recipes;
	//boolean incompSlime;
	public boolean uncraftGeneral;
	public boolean runestones;
	public boolean magicApples;
	public boolean fishingNetBlock;
	public boolean xRayBlock;
	public boolean masterWand;
	public boolean enderBook;
	public boolean weatherBlock;
	public boolean gameruleBlocks;
	public boolean craftableMushroomBlocks;
	public boolean searchtrade;
	public boolean searchitem;
	public boolean killall;
	public boolean enderchest;
	public boolean simplewaypoint;
	public boolean todo;
	public boolean deathItemsChest;
	public boolean home;
	public boolean worldhome;
	public boolean lootObsidian;
	public boolean lootAllRecords;
	public boolean lootGlowstone;
	public boolean lootQuartz;
 

	//to go between main and sub levels nested in the json style cfg file
	private static String LevelSep = ".";
	
	public ConfigFile()
	{
		String category = Configuration.CATEGORY_GENERAL;
		
		category = "flyingInSurvival";

		HandlerSurvivalFlying.canFlySurvival = ModSamsContent.config.getBoolean("all_canFlySurvival",category, true
				,"Set to false to disable this whole area.  If true, players can fly in survival mode, with restrictions and costs as listed here.  Also has a /flyhelp command for more info."); 
		
		HandlerSurvivalFlying.cannotFlyWhileBurning = ModSamsContent.config.getBoolean("disableWhileBurning",category, true
				,"When true, this disables flying while you are burning."); 

		HandlerSurvivalFlying.NoArmorOnly = ModSamsContent.config.getBoolean( "disableWithArmor",category,false
				,"When this is true, you may only fly if not wearing any armor. ");
		
		HandlerSurvivalFlying.cannotFlyAtNight = ModSamsContent.config.getBoolean( "disableAtNight",category,false
			,"When this is true, you cannot use survival flying at night.");
		
		HandlerSurvivalFlying.cannotFlyInRain = ModSamsContent.config.getBoolean( "disableInRain",category,false
				,"When this is true, you cannot use survival flying in the rain.");
 
		HandlerSurvivalFlying.StartFlyingLevel = ModSamsContent.config.getInt( "minLevel",category, 10,0,99// default,min,max
					,"The minimum level required to fly in survival.  ");
		  
		HandlerSurvivalFlying.difficultyRequiredToFly = ModSamsContent.config.getInt( "difficultyRequired",category, 3,0,3
				,"Minimum difficulty required for survival fly (0 = Peaceful, 3 = Hard).");
		  
		HandlerSurvivalFlying.StartFlyingHealth = ModSamsContent.config.getInt( "minHealth",category, 10,1,20
				,"The minimum health required in order to fly in survival.  Each number is one half heart, " +
						"so 20 means 10 hearts.");
		 
		HandlerSurvivalFlying.StartFlyingHunger = ModSamsContent.config.getInt( "minHunger",category, 5,1,20,
				"Minimum hunger required to fly.  Each number is one half hunger, so 20 means full hunger.");
		 
		HandlerSurvivalFlying.doesDrainHunger = ModSamsContent.config.getBoolean( "doesDrainHunger",category,true,
			"When this is true, your hunger Levels will drain while flying in survival."); 
		 
		HandlerSurvivalFlying.doesWeaknessFatigue = ModSamsContent.config.getBoolean( "doesWeaknessFatigue",category,true,
				"When this is true, survival flying will cause Weakness IV and Mining Fatigue IV."); 
	
		if(ModSamsContent.config.hasChanged()){ ModSamsContent.config.save(); }
	}
}

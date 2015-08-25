package com.lothrazar.configflying;

import net.minecraftforge.common.config.Configuration;

public class ConfigFile
{
	public ConfigFile()
	{
		String category = Configuration.CATEGORY_GENERAL;
		 
 
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

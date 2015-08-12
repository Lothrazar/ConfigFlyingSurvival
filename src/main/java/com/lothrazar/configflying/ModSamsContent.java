package com.lothrazar.configflying;

import org.apache.logging.log4j.Logger; 
 
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
 
//TODO: fix // ,guiFactory = "com.lothrazar.samspowerups.gui.ConfigGuiFactory"
@Mod(modid = ModSamsContent.MODID,useMetadata = true) 
public class ModSamsContent
{
	@Instance(value = ModSamsContent.MODID)
	public static ModSamsContent instance;
	public static Logger logger;
	public final static String MODID = "configflying"; 

	public static Configuration config;
	public static ConfigFile settings;
	
	//TODO: try asm out http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/1571568-tutorial-1-6-2-changing-vanilla-without-editing

	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event)
	{ 
		logger = event.getModLog();
		
		config = new Configuration(event.getSuggestedConfigurationFile());
 
		settings = new ConfigFile();
     	
     	//TODO: we could use an interface, and flag each one according to what BUS it goes to
     	
		HandlerSurvivalFlying h = new HandlerSurvivalFlying();
  
		MinecraftForge.EVENT_BUS.register(h);
		FMLCommonHandler.instance().bus().register(h);
      
	}

	@EventHandler
	public void onServerLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandFlyHelp());
	}
}

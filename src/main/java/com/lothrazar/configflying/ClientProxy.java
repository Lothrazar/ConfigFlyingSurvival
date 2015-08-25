package com.lothrazar.configflying;

import org.lwjgl.input.Keyboard; 
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class ClientProxy extends CommonProxy
{
	public static KeyBinding keyFlyToggle;
	public static String keyCategory = "key.categories.inventory";
	
	@Override
    public void registerRenderers() 
    {  
		
	//	keyFlyToggle = new KeyBinding("keyFlyToggle", Keyboard.KEY_V, keyCategory);
       // ClientRegistry.registerKeyBinding(keyFlyToggle);
       
    }
}

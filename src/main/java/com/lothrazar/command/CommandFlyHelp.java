package com.lothrazar.command;
 
import java.util.ArrayList;   

import com.lothrazar.samscontent.HandlerSurvivalFlying;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer; 
import net.minecraft.util.ChatComponentTranslation;

public class CommandFlyHelp implements ICommand
{ 
	  private ArrayList<String> aliases;
	  public CommandFlyHelp()
	  {
	      this.aliases = new ArrayList<String>();
	      this.aliases.add("fh");
	      this.aliases.add("flyhelp"); 
	      this.aliases.add("flyhelp");  
	  }
 
	  @Override
	  public String getCommandName()
	  {
	    return "flyhelp";
	  }

	  @Override
	  public String getCommandUsage(ICommandSender icommandsender)
	  {
	    return "flyhelp";
	  }

	  @Override
	  public ArrayList<String> getCommandAliases()
	  {
	    return this.aliases;
	  }

	  @Override
	  public void processCommand(ICommandSender icommandsender, String[] astring)
	  { 
		  EntityPlayer p = (EntityPlayer)icommandsender;

			p.addChatMessage(new ChatComponentTranslation( 
					  "Expensive flying is enabled if:" 
					)); 
		  
		  String strdiff = "";
		  switch(HandlerSurvivalFlying.difficultyRequiredToFly)//iknow i know, there is a better way maybe with EnumDifficulty ....
		  {
		  	case 0: strdiff = "Peaceful";break;
		  	case 1: strdiff = "Easy"; break;
		  	case 2: strdiff = "Normal"; break;
		  	case 3: strdiff = "Hard"; break;
		  }
		  
		  p.addChatMessage(new ChatComponentTranslation(  "- Your world difficulty is "+strdiff+" ("+
				  	HandlerSurvivalFlying.difficultyRequiredToFly+") or greater")); 
		   
		  if(HandlerSurvivalFlying.NoArmorOnly)p.addChatMessage(new ChatComponentTranslation(  "- You are not wearing armor"));
		  if(HandlerSurvivalFlying.cannotFlyWhileBurning) p.addChatMessage(new ChatComponentTranslation(  "- You are not on fire"));
		    
		  if(HandlerSurvivalFlying.cannotFlyAtNight) p.addChatMessage(new ChatComponentTranslation(  "- It is not night"));
		  if(HandlerSurvivalFlying.cannotFlyInRain) p.addChatMessage(new ChatComponentTranslation( "- It is not raining"));
		  
		  double hearts = HandlerSurvivalFlying.StartFlyingHealth / 2;
		  double hunger = HandlerSurvivalFlying.StartFlyingHunger / 2;
		  
		  p.addChatMessage(new ChatComponentTranslation( "- You have at least "+hearts+" hearts , and at least "+hunger+" hunger"));
  
		  p.addChatMessage(new ChatComponentTranslation( "- You have at least "+HandlerSurvivalFlying.StartFlyingLevel+" levels"));  
		  
		  //no message needed for xp drain
	  }
	   
	  @Override
	  public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	  { 
	     return true;
	  }

	  @Override
	  public ArrayList<String> addTabCompletionOptions(ICommandSender icommandsender,  String[] astring)
	  {
	    return null;
	  }

	  @Override
	  public boolean isUsernameIndex(String[] astring, int i)
	  {
	    return false;
	  }

	  @Override
	  public int compareTo(Object o)
	  {
	    return 0;
	  }
}

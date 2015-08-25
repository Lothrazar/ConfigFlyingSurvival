package com.lothrazar.configflying;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;

public class MessageKeyPressed implements IMessage, IMessageHandler<MessageKeyPressed, IMessage> 
{

	@Override
	public IMessage onMessage(MessageKeyPressed message, MessageContext ctx) 
	{
		EntityPlayer player = ctx.getServerHandler().playerEntity; 
		
		
	//	HandlerSurvivalFlying.toggleFlying(player);
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{

		
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{

		
	}

}

/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 * 
 * Quark is Open Source and distributed under the
 * [ADD-LICENSE-HERE]
 * 
 * File Created @ [26/03/2016, 21:53:17 (GMT)]
 */
package vazkii.quark.vanity.feature;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vazkii.aurelienribon.tweenengine.Tween;
import vazkii.quark.base.module.Feature;
import vazkii.quark.vanity.client.emotes.EmoteCheer;
import vazkii.quark.vanity.client.emotes.EmoteClap;
import vazkii.quark.vanity.client.emotes.EmoteFacepalm;
import vazkii.quark.vanity.client.emotes.EmoteHeadbang;
import vazkii.quark.vanity.client.emotes.EmoteNo;
import vazkii.quark.vanity.client.emotes.EmotePoint;
import vazkii.quark.vanity.client.emotes.EmoteSalute;
import vazkii.quark.vanity.client.emotes.EmoteShrug;
import vazkii.quark.vanity.client.emotes.EmoteWave;
import vazkii.quark.vanity.client.emotes.EmoteYes;
import vazkii.quark.vanity.client.emotes.base.EmoteHandler;
import vazkii.quark.vanity.client.emotes.base.ModelAccessor;
import vazkii.quark.vanity.command.CommandEmote;

public class EmoteSystem extends Feature {

	@Override
	@SideOnly(Side.CLIENT)
	public void preInitClient(FMLPreInitializationEvent event) {
		Tween.registerAccessor(ModelBiped.class, new ModelAccessor());

		MinecraftForge.EVENT_BUS.register(new EmoteHandler.TickHandler());
		
		EmoteHandler.emoteMap.put("wave", EmoteWave.class);
		EmoteHandler.emoteMap.put("yes", EmoteYes.class);
		EmoteHandler.emoteMap.put("no", EmoteNo.class);
		
		EmoteHandler.emoteMap.put("cheer", EmoteCheer.class);
		EmoteHandler.emoteMap.put("clap", EmoteClap.class);
		EmoteHandler.emoteMap.put("salute", EmoteSalute.class);
		
		EmoteHandler.emoteMap.put("facepalm", EmoteFacepalm.class);
		EmoteHandler.emoteMap.put("shrug", EmoteShrug.class);
		EmoteHandler.emoteMap.put("point", EmotePoint.class);

		EmoteHandler.emoteMap.put("headbang", EmoteHeadbang.class);
	}
	
	@Override
	public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandEmote());
	}
	
}
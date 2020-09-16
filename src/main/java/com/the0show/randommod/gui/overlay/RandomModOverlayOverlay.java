
package com.the0show.randommod.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class RandomModOverlayOverlay extends RandomModModElements.ModElement {
	public RandomModOverlayOverlay(RandomModModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (true) {
				Minecraft.getInstance().fontRenderer.drawString("Random Mod by The0Show", posX + 105, posY + -119, -1);
				Minecraft.getInstance().fontRenderer.drawString("This block is located at " + x + " " + y + " and " + z + ".", posX + 9, posY + -110,
						-1);
			}
		}
	}
}

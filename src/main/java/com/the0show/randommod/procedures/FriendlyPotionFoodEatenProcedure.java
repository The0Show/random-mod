package com.the0show.randommod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class FriendlyPotionFoodEatenProcedure extends RandomModModElements.ModElement {
	public FriendlyPotionFoodEatenProcedure(RandomModModElements instance) {
		super(instance, 15);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FriendlyPotionFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) 99999, (int) 0, (false), (false)));
	}
}

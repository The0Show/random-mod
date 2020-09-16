package com.the0show.randommod.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class FireStickLivingEntityIsHitWithToolProcedure extends RandomModModElements.ModElement {
	public FireStickLivingEntityIsHitWithToolProcedure(RandomModModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FireStickLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 18);
	}
}

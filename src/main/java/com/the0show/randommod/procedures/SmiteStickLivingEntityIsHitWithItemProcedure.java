package com.the0show.randommod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.entity.effect.LightningBoltEntity;

import java.util.Map;

import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class SmiteStickLivingEntityIsHitWithItemProcedure extends RandomModModElements.ModElement {
	public SmiteStickLivingEntityIsHitWithItemProcedure(RandomModModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SmiteStickLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SmiteStickLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SmiteStickLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SmiteStickLivingEntityIsHitWithItem!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld)
			((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) x, (int) y, (int) z, false));
	}
}

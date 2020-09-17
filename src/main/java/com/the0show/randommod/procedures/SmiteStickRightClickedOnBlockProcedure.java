package com.the0show.randommod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.entity.effect.LightningBoltEntity;

import java.util.Map;

import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class SmiteStickRightClickedOnBlockProcedure extends RandomModModElements.ModElement {
	public SmiteStickRightClickedOnBlockProcedure(RandomModModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SmiteStickRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SmiteStickRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SmiteStickRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SmiteStickRightClickedOnBlock!");
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

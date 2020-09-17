
package com.the0show.randommod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import java.util.Map;
import java.util.HashMap;

import com.the0show.randommod.procedures.FriendlyPotionFoodEatenProcedure;
import com.the0show.randommod.itemgroup.RandomModTabItemGroup;
import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class FriendlyPotionItem extends RandomModModElements.ModElement {
	@ObjectHolder("random_mod:friendly_potion")
	public static final Item block = null;
	public FriendlyPotionItem(RandomModModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(RandomModTabItemGroup.tab).maxStackSize(1)
					.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("friendly_potion");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				FriendlyPotionFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}

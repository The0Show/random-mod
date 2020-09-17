
package com.the0show.randommod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import com.the0show.randommod.itemgroup.RandomModTabItemGroup;
import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class LongFoodItem extends RandomModModElements.ModElement {
	@ObjectHolder("random_mod:long_food")
	public static final Item block = null;
	public LongFoodItem(RandomModModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(RandomModTabItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
			setRegistryName("long_food");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 100;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}

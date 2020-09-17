
package com.the0show.randommod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import com.the0show.randommod.itemgroup.RandomModTabItemGroup;
import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class RickrollItem extends RandomModModElements.ModElement {
	@ObjectHolder("random_mod:rickroll")
	public static final Item block = null;
	public RickrollItem(RandomModModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, RandomModModElements.sounds.get(new ResourceLocation("random_mod:musicdisc.rickroll")),
					new Item.Properties().group(RandomModTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("rickroll");
		}
	}
}

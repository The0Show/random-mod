
package com.the0show.randommod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import com.the0show.randommod.itemgroup.RandomModTabItemGroup;
import com.the0show.randommod.RandomModModElements;

@RandomModModElements.ModElement.Tag
public class Song1Item extends RandomModModElements.ModElement {
	@ObjectHolder("random_mod:song_1")
	public static final Item block = null;
	public Song1Item(RandomModModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, RandomModModElements.sounds.get(new ResourceLocation("random_mod:musicdisc.sawsquare")),
					new Item.Properties().group(RandomModTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("song_1");
		}
	}
}


package com.the0show.randommod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import com.the0show.randommod.procedures.SmiteStickRightClickedOnBlockProcedure;
import com.the0show.randommod.procedures.SmiteStickLivingEntityIsHitWithItemProcedure;
import com.the0show.randommod.itemgroup.RandomModTabItemGroup;
import com.the0show.randommod.RandomModModElements;

import com.google.common.collect.Multimap;

@RandomModModElements.ModElement.Tag
public class SmiteStickItem extends RandomModModElements.ModElement {
	@ObjectHolder("random_mod:smite_stick")
	public static final Item block = null;
	public SmiteStickItem(RandomModModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(RandomModTabItemGroup.tab).maxStackSize(64));
			setRegistryName("smite_stick");
		}

		@Override
		public int getItemEnchantability() {
			return 15;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
			Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot);
			if (slot == EquipmentSlotType.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "item_damage", (double) -1, AttributeModifier.Operation.ADDITION));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "item_attack_speed", -2.4, AttributeModifier.Operation.ADDITION));
			}
			return multimap;
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUseFirst(stack, context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SmiteStickRightClickedOnBlockProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
			boolean retval = super.hitEntity(itemstack, entity, sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SmiteStickLivingEntityIsHitWithItemProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}

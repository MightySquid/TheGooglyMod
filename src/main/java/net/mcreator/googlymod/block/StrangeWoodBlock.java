
package net.mcreator.googlymod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.googlymod.itemgroup.GooglyModItemGroup;
import net.mcreator.googlymod.GooglymodModElements;

import java.util.List;
import java.util.Collections;

@GooglymodModElements.ModElement.Tag
public class StrangeWoodBlock extends GooglymodModElements.ModElement {
	@ObjectHolder("googlymod:strange_wood")
	public static final Block block = null;
	public StrangeWoodBlock(GooglymodModElements instance) {
		super(instance, 76);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(GooglyModItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.NETHER_WOOD).sound(SoundType.NETHER_VINE_LOWER_PITCH).hardnessAndResistance(1.1f, 10f)
					.setLightLevel(s -> 1).harvestLevel(3).harvestTool(ToolType.AXE).setNeedsPostProcessing((bs, br, bp) -> true)
					.setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("strange_wood");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}

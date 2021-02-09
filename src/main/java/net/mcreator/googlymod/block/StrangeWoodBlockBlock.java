
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
public class StrangeWoodBlockBlock extends GooglymodModElements.ModElement {
	@ObjectHolder("googlymod:strange_wood_block")
	public static final Block block = null;
	public StrangeWoodBlockBlock(GooglymodModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(GooglyModItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.NETHER_WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.05f, 10f).setLightLevel(s -> 1)
					.harvestLevel(2).harvestTool(ToolType.AXE).setNeedsPostProcessing((bs, br, bp) -> true)
					.setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("strange_wood_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(StrangeWoodBlock.block, (int) (1)));
		}
	}
}

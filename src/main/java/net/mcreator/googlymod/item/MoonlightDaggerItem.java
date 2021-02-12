
package net.mcreator.googlymod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.googlymod.procedures.MoonlightProcedureProcedure;
import net.mcreator.googlymod.itemgroup.GooglyModItemGroup;
import net.mcreator.googlymod.GooglymodModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@GooglymodModElements.ModElement.Tag
public class MoonlightDaggerItem extends GooglymodModElements.ModElement {
	@ObjectHolder("googlymod:moonlight_dagger")
	public static final Item block = null;
	public MoonlightDaggerItem(GooglymodModElements instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShearsItem(new Item.Properties().group(GooglyModItemGroup.tab).maxDamage(3000).isImmuneToFire()) {
			@Override
			public int getItemEnchantability() {
				return 20;
			}

			@Override
			public float getDestroySpeed(ItemStack stack, BlockState block) {
				return 4f;
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Reflects light in a strange way"));
				list.add(new StringTextComponent("and glows like a crescent moon."));
				list.add(new StringTextComponent("Gives buffs on crits"));
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
					$_dependencies.put("sourceentity", sourceentity);
					MoonlightProcedureProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("moonlight_dagger"));
	}
}

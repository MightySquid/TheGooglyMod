package net.mcreator.googlymod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.googlymod.enchantment.LifeStealEnchantment;
import net.mcreator.googlymod.GooglymodModElements;
import net.mcreator.googlymod.GooglymodMod;

import java.util.Map;

@GooglymodModElements.ModElement.Tag
public class LifestealProcedureProcedure extends GooglymodModElements.ModElement {
	public LifestealProcedureProcedure(GooglymodModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GooglymodMod.LOGGER.warn("Failed to load dependency sourceentity for procedure LifestealProcedure!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				GooglymodMod.LOGGER.warn("Failed to load dependency itemstack for procedure LifestealProcedure!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((EnchantmentHelper.getEnchantmentLevel(LifeStealEnchantment.enchantment, (itemstack))) == 1)) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 15, (int) 1));
		} else if (((EnchantmentHelper.getEnchantmentLevel(LifeStealEnchantment.enchantment, (itemstack))) == 2)) {
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 15, (int) 1));
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 2));
		}
	}
}

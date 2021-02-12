package net.mcreator.googlymod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.googlymod.GooglymodModElements;
import net.mcreator.googlymod.GooglymodMod;

import java.util.Map;

@GooglymodModElements.ModElement.Tag
public class MoonlightProcedureProcedure extends GooglymodModElements.ModElement {
	public MoonlightProcedureProcedure(GooglymodModElements instance) {
		super(instance, 87);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				GooglymodMod.LOGGER.warn("Failed to load dependency sourceentity for procedure MoonlightProcedure!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 125, (int) 1));
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 100, (int) 1));
	}
}

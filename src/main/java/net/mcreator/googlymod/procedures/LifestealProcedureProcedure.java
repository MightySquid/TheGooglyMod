package net.mcreator.googlymod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.googlymod.enchantment.LifeStealEnchantment;
import net.mcreator.googlymod.GooglymodModElements;
import net.mcreator.googlymod.GooglymodMod;

import java.util.Map;
import java.util.HashMap;

@GooglymodModElements.ModElement.Tag
public class LifestealProcedureProcedure extends GooglymodModElements.ModElement {
	public LifestealProcedureProcedure(GooglymodModElements instance) {
		super(instance, 32);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				GooglymodMod.LOGGER.warn("Failed to load dependency entity for procedure LifestealProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).isEnchanted())) {
			if (((EnchantmentHelper.getEnchantmentLevel(LifeStealEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 15, (int) 1));
			} else if (((EnchantmentHelper.getEnchantmentLevel(LifeStealEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 15, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 2));
			} else if (((EnchantmentHelper.getEnchantmentLevel(LifeStealEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 3)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 30, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 20, (int) 2));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerCriticalHit(CriticalHitEvent event) {
		Entity entity = event.getTarget();
		PlayerEntity sourceentity = event.getPlayer();
		double i = sourceentity.getPosX();
		double j = sourceentity.getPosY();
		double k = sourceentity.getPosZ();
		World world = sourceentity.world;
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("sourceentity", sourceentity);
		dependencies.put("damagemodifier", event.getDamageModifier());
		dependencies.put("isvanillacritical", event.isVanillaCritical());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}

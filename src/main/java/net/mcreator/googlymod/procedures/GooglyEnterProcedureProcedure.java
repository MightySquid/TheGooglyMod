package net.mcreator.googlymod.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import net.mcreator.googlymod.GooglymodModElements;
import net.mcreator.googlymod.GooglymodMod;

import java.util.Map;

@GooglymodModElements.ModElement.Tag
public class GooglyEnterProcedureProcedure extends GooglymodModElements.ModElement {
	public GooglyEnterProcedureProcedure(GooglymodModElements instance) {
		super(instance, 79);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				GooglymodMod.LOGGER.warn("Failed to load dependency world for procedure GooglyEnterProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(
						new StringTextComponent(
								"\u00A75 You Enter The Googly Realm, a Place of Danger, but Also Wonder. Tread Carefully, Mortal \u00A75"),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
	}
}

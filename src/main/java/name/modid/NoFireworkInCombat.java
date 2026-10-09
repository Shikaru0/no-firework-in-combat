package name.modid;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.resources.Identifier;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoFireworkInCombat implements ModInitializer {
	public static final String MOD_ID = "no-firework-in-combat";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final boolean disable = true;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		UseItemCallback.EVENT.register(((player, _, hand) -> {
			if (!(player instanceof ServerPlayer)) return InteractionResult.PASS;
			if (!player.getItemInHand(hand).is(Items.FIREWORK_ROCKET)) return InteractionResult.PASS;
			if (!disable) return InteractionResult.PASS;

			return InteractionResult.FAIL;
		}));
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

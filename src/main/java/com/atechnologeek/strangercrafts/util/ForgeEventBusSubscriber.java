package com.atechnologeek.strangercrafts.util;

import com.atechnologeek.strangercrafts.StrangerCrafts;
import com.atechnologeek.strangercrafts.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid=StrangerCrafts.MOD_ID, bus=Bus.FORGE)
public class ForgeEventBusSubscriber {
	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if (DimensionType.byName(StrangerCrafts.UPSIDE_DOWN_TYPE) == null) {
			DimensionManager.registerDimension(StrangerCrafts.UPSIDE_DOWN_TYPE, DimensionInit.UPSIDE_DOWN.get(), null, false);
		}
		StrangerCrafts.LOGGER.info("Dimensions Registered!");
	}
}
